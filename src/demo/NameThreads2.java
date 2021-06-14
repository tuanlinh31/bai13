package demo;

public class NameThreads2 implements Runnable{
    String name;
    public void run(){
        int count =0;
        while (count<=3){
            System.out.println(Thread.activeCount());

            name = Thread.currentThread().getName();
            count++;
            System.out.println(name);

            if (name.equals("Thread1")){
                System.out.println("Marimba");
            }else {
                System.out.println("Jini");
            }
        }
        System.out.println("Thread end");
    }
}
