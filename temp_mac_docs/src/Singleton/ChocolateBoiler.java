package Singleton;

public class ChocolateBoiler {

    private volatile static ChocolateBoiler chocolateBoilerInstance;

    private ChocolateBoiler(){
        empty=true;
        boiled=false;
    }
    private boolean empty;
    private boolean boiled;

    public static ChocolateBoiler getInstance(){
        if(chocolateBoilerInstance==null){
            synchronized (ChocolateBoiler.class){
                chocolateBoilerInstance= new ChocolateBoiler();
            }

        }
        return chocolateBoilerInstance;
    }

    public void fill(){
        if(isEmpty()){
            empty=false;
            boiled=false;
            System.out.println("Filling the boiler");
        }
    }

    public void drain(){
        if(!isEmpty() && isBoiled()){
            empty=true;
            System.out.println("Draining the choclate milk");
        }
    }

    public void boil(){
        if(!isEmpty() && !isBoiled()){
            boiled=true;

            System.out.println("Boiling the choclate and milk");
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

}
