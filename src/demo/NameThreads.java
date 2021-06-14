package demo;

public class NameThreads extends Thread{
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

    public static void main(String[] args) {
        NameThreads objnamedthread = new NameThreads();
        objnamedthread.setName("Thread1");
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(objnamedthread.isAlive());

        objnamedthread.start();
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(objnamedthread.isAlive());
    }
}
