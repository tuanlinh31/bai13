package MultiThread;

import javax.management.loading.MLet;

public class MultiThread extends Thread{
    String name;
    public void run(){
        while (true){
            name = Thread.currentThread().getName();
            System.out.println(name);
            try{
                int a = (int) (Math.random() *1000);
                Thread.sleep(a);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        MultiThread m1 = new MultiThread();
        m1.setName("Thread 2");

        MultiThread m2 = new MultiThread();
        m2.setName("Thread 3");

        m1.start();
        m2.start();

        System.out.println(Thread.activeCount());
    }
}
