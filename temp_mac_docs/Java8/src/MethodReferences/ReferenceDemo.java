package MethodReferences;

public class ReferenceDemo {

    public static void main(String[] args) {
        System.out.println(" Learning method references");

      /*  WorkInter workInter= () ->{
            System.out.println("this is do task new method");
        }; */

        WorkInter workInter = Stuff :: doStuff;

        workInter.doTask();

       Runnable runnable= Stuff::threadTask;
       Thread d= new Thread(runnable);
       d.start();


       //for non static methods we need object references
        Stuff stuffObject= new Stuff();
        Runnable run2= stuffObject::printNmber;
        Thread d1= new Thread(run2);
        d1.start();
    }
}
