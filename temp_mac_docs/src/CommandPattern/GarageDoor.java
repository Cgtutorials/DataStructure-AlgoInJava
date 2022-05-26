package CommandPattern;

public class GarageDoor {
    String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void up(){
        System.out.println(name + " is Up");
    }

    public void down(){
        System.out.println(name + " is Down");
    }

    public void stop(){
        System.out.println(name + " is  Stoppped");
    }
    public void lightOn(){
        System.out.println(name + " light is on");
    }
    public void lightOff(){
        System.out.println(name + "  light is off");
    }
}
