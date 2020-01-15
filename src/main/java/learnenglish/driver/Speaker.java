package learnenglish.driver;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.DataLine.Info;

public class Speaker {
	public void play(String Path) {
//		final File file = new File(Path);
		URL file=null;
		try {
			file = new URL("https://howjsay.com/mp3/car.mp3");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (final AudioInputStream inputStream = getAudioInputStream(file)) {

			final AudioFormat audioFormat = getOutputFormat(inputStream.getFormat());
			final Info in = new Info(SourceDataLine.class, audioFormat);

			try (final SourceDataLine dataline = (SourceDataLine) AudioSystem.getLine(in)) {

				if (dataline != null) {
					dataline.open(audioFormat);
					dataline.start();
					stream(getAudioInputStream(audioFormat, inputStream), dataline);
					dataline.drain();
					dataline.stop();
				}
			}

		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			throw new IllegalStateException(e);
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
