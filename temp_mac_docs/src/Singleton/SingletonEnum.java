package Singleton;

public enum SingletonEnum {
    UNIQUEINSTANCE;

    private boolean empty;
    private boolean boiled;

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
