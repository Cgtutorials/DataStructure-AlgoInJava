package CommandPattern;

public class StereoOnWithCDCommand implements Command{
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.off();
        stereo.setVolume(11);
    }
}
