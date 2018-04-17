package useacabecajava.beatbox.parte1;

import javax.sound.midi.*;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp musicApp = new MiniMusicApp();
        musicApp.play();
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(144,1,46,100);
            MidiEvent noteOn = new MidiEvent(msg1,1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(msg2,10);
            track.add(noteOff);

            player.setSequence(sequence);
            player.start();
            Thread.sleep(1000*2);
            player.close();
            System.exit(0);

        } catch (MidiUnavailableException e) {
            System.out.println("MidiUnavailableException");
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            System.out.println("InvalidMidiDataException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
    }
}
