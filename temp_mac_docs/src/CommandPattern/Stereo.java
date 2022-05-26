package CommandPattern;

public class Stereo {
    String room;
    public Stereo(String room) {
        this.room=room;
    }

    public void on(){
        System.out.println("System On");
    }

    public void off(){
        System.out.println("System Off");
    }

    public void setCD(){
        System.out.println("Mode changed to CD");
    }

    public void setDVD(){
        System.out.println("Mode changed to DVD");

    }
    public void setVolume(int vol){
        System.out.println("Volume has been set to " + vol);
    }

}
