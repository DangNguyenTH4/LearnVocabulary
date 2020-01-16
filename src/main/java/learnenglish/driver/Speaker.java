package learnenglish.driver;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learnenglish.model.ManagerPlayer;

public class Speaker {
	private Logger logger = LoggerFactory.getLogger(Speaker.class); 
	public void play(String words) {
			try(ManagerPlayer mp1 = createManagerPlayer(words)) {
				playOne(mp1);
			} catch (UnsupportedAudioFileException | IOException e) {
				logger.info(e.getMessage());
			} catch (LineUnavailableException e) {
				logger.info(e.getMessage());
			}
		
	}
	private ManagerPlayer createManagerPlayer(String word) throws UnsupportedAudioFileException, IOException {
		URL file = null;
		word = word.trim();
		word = word.replaceAll(" ", "%20");
		file = new URL("https://howjsay.com/mp3/"+word+".mp3");
		AudioInputStream inputStream = getAudioInputStream(file);
		AudioFormat audioFormat = getOutputFormat(inputStream.getFormat());
		Info in = new Info(SourceDataLine.class, audioFormat);
		ManagerPlayer mp = new ManagerPlayer();
		mp.setAudioFormat(audioFormat);
		mp.setIn(in);
		mp.setInputStream(inputStream);
		return mp;
		
	}
	private void playOne(ManagerPlayer mp) throws LineUnavailableException, IOException {
		Info in = mp.getIn();
		AudioInputStream inputStream = mp.getInputStream();
		AudioFormat audioFormat = mp.getAudioFormat();
		
		try (final SourceDataLine dataline = (SourceDataLine) AudioSystem.getLine(in)) {

			if (dataline != null) {
				dataline.open(audioFormat);
				dataline.start();
				stream(getAudioInputStream(audioFormat, inputStream), dataline);
				dataline.drain();
				dataline.stop();
			}
		}
	}
	private AudioFormat getOutputFormat(AudioFormat audioFormat) {
		final int channel = audioFormat.getChannels();
		final float audiorate = audioFormat.getSampleRate();
		return new AudioFormat(PCM_SIGNED, audiorate, 16, channel, channel * 2, audiorate, false);
	}

	private void stream(AudioInputStream inputStream, SourceDataLine dataLine) throws IOException {
		final byte[] bufferStream = new byte[65536];
		for (int n = 0; n != -1; n = inputStream.read(bufferStream, 0, bufferStream.length)) {
			dataLine.write(bufferStream, 0, n);
		}
	}
}
