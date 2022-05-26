package MethodReferences;

public class Stuff {
    public static void doStuff() {
        System.out.println("Stuff");
    }
    public static void threadTask()  {
        for(int i=0;i<=10;i++){
            System.out.println(i*2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printNmber()  {
        for(int i=1;i<=10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
