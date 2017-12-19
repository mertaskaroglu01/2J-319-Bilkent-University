package GameManagement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
	
	//Sounds sounds;
	String background = "src/background.wav";
	String slap = "src/slap_sound.wav";
	String pop = "src/pop.wav";
	String round_end = "src/round_end.wav";
	boolean playing;
	
	public SoundManager() {
		playing = false;
	}
	
	public Clip play(int soundId) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		Clip clip;
		switch(soundId) {
		case 1: clip = playSound(background);
				playing = true;
				return clip;
		case 2: clip = playSound(slap);
				return clip;
		case 3: clip = playSound(pop);
				return clip;
		case 4: clip = playSound(round_end);
				return clip;
		default: clip = playSound(pop); return clip;
		}
	}
	
	public boolean getPlaying() {
		return this.playing;
	}
	
	public Clip playSound(String soundFile) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {	
		File f = new File("./" + soundFile);
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);
	    clip.start();
	    playing = true;
	    return clip;
	}
	
	public void stopSound(Clip clip) {
		clip.stop();
		playing = false;
	}

	
}
