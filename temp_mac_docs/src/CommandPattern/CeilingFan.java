package CommandPattern;

public class CeilingFan {
    String room;
    public CeilingFan(String room) {
        this.room=room;
    }

    public void on(){
        System.out.println(room + " ka Light jal gaya");
    }

    public void off(){
        System.out.println(room + " ka Light band ho gaya");
    }
}
