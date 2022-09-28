class MyTask {
    MyTask() {
    }

    void executeTask() {
        for(int doc = 1; doc <= 10; ++doc) {
            System.out.println("@@ Printing Document # " + doc + " - Printer 2");
        }

    }
}

public class App {
    public App() {
    }
    //main threadd
    public static void main(String[] args) {
        //threads always execute jobs in a sequence
        //Execution Context

        // job 1
        System.out.println("xXx App Started xXx");
        // job 2
        MyTask task = new MyTask();
        task.executeTask();
        //until job2 is finished, no further jobs can be started
        //if job2 is a long-running operation, OS/JVM might give a message that app is not responding
        //sluggish behaviour might be noticed, app seems to hang

        // job3
        System.out.println("stuffs we wanna print - Printer 1");
        // job 4
        System.out.println("xXx App Closed xXx");
    }
}