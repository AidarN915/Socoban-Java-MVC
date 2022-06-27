import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.FloatControl;

public class Sound {

    private AudioInputStream stream;
    private Clip clip;
    private FloatControl volumeControl;
    private boolean released;
    private boolean playing;

    public Sound(String fileName) {
        File file = new File(fileName);
        try {
            stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(stream);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(0.9f);
            released = true;
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException uafe) {
            System.out.println(uafe);
            released = false;
            close();

        }

    }

    public void play(boolean breakOld) {
        if (released) {
            if (breakOld) {
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
                playing = true;
            } else if (!isPlaying()) {
                clip.setFramePosition(0);
                clip.start();
                playing = true;
            }
        }
    }

    public void play() {
        play(true);
    }


    public void stop() {
        if (playing) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null)
            clip.close();

        if (stream != null)
            try {
                stream.close();
            } catch (IOException ioe) {
                System.err.println(ioe);
            }
    }

    public void setVolume(float x) {
        if (x < 0) x = 0;
        if (x > 1) x = 1;
        float min = volumeControl.getMinimum();
        float max = volumeControl.getMaximum();
        volumeControl.setValue((max - min) * x + min);
    }

    public float getVolume() {
        float v = volumeControl.getValue();
        float min = volumeControl.getMinimum();
        float max = volumeControl.getMaximum();
        return (v - min) / (max - min);
    }

    public void join() {
        if (!released) return;
        synchronized (clip) {
            try {
                while (playing)
                    clip.wait();
            } catch (InterruptedException ie) {
                System.err.println(ie);
            }
        }
    }

    public Clip getClip() {
        return clip;
    }


    public boolean isReleased() {
        return released;
    }

    public boolean isPlaying() {
        return playing;
    }


}
