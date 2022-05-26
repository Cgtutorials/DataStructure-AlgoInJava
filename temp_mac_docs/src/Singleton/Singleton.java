package Singleton;

public class Singleton {
    private  static Singleton mySingletonInstance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(mySingletonInstance==null){
            mySingletonInstance= new Singleton();
        }
        return mySingletonInstance;
    }
}
