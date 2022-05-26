package CommandPattern;

public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl= new RemoteControl();

        Light livingRoomLight= new Light("Living Room");
        Light KitchenLight= new Light("Kitchen");
        CeilingFan ceilingFan= new CeilingFan("Living Room");
        GarageDoor garageDoor= new GarageDoor("Garage");
        Stereo stereo= new Stereo("Living Room");


        LightOnCommand livingRoomLightOn= new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff= new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn= new LightOnCommand(KitchenLight);
        LightOffCommand kitchenLightOff= new LightOffCommand(KitchenLight);

        CeilingFanOnCommand ceilingFanOn= new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff= new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand= new GarageDoorDownCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCDCommand= new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff= new StereoOffCommand(stereo);

        remoteControl.setCommand(0,kitchenLightOn,kitchenLightOff);
        remoteControl.setCommand(1,livingRoomLightOn,livingRoomLightOff);
        remoteControl.setCommand(2,ceilingFanOn,ceilingFanOff);
        remoteControl.setCommand(3,stereoOnWithCDCommand,stereoOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}
