//class MyTask {
//    void executeTask() {
//        for(int doc = 1; doc <= 10; ++doc) {
//            System.out.println("@@ Printing Document # " + doc + " - Printer 2");
//        }
//
//    }
//}

class Irrelevant{

}

//MyTask is a thread
class MyTask extends Irrelevant implements Runnable{
    @Override
    public void run() {
        for(int doc = 1; doc <= 10; ++doc) {
            System.out.println("@@ Printing Document # " + doc + " - Printer 2");
        }

    }
}

public class App {
    public App() {
    }
    //main thread
    public static void main(String[] args) {
        //threads always execute jobs in a sequence
        //Execution Context

        // job 1
        System.out.println("xXx App Started xXx");
        // job 2
//        task.executeTask(); //main use case
//        MyTask task = new MyTask(); //Child Thread / Worker Thread // solution 1
//        task.start(); // start shell internally, execute run method // solution 1

        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.start();

        //until job2 is finished, no further jobs can be started
        //if job2 is a long-running operation, OS/JVM might give a message that app is not responding
        //sluggish behaviour might be noticed, app seems to hang

        // job3
        for(int doc = 1; doc <= 10; ++doc) {
            System.out.println("$$ Printing Document # " + doc + " - Printer 1");
        }
        // job 4
        System.out.println("xXx App Closed xXx");
    }
}