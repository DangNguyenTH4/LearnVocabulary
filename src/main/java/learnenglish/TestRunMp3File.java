package learnenglish;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

public class TestRunMp3File {
	public static void main(String[] args) {
		final TestRunMp3File player = new TestRunMp3File();
//		player.play("C:\\Users\\dangnt\\Desktop\\Image_SDD\\car.mp3");
		System.out.println("Play done");
		player.play("https://howjsay.com/mp3/car.mp3");
		System.out.println("Playdone2");
	}

	public void play(String Path) {
//		final File file = new File(Path);
		URL file = null;
		try {
			file = new URL("https://howjsay.com/mp3/car.mp3");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		AudioInputStream inputStream=null;
		try  {
			inputStream = getAudioInputStream(file);
			final AudioFormat audioFormat = getOutputFormat(inputStream.getFormat());
			final Info in = new Info(SourceDataLine.class, audioFormat);

			playReal(in, audioFormat, inputStream);

		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			throw new IllegalStateException(e);
		}finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void playReal(Info in, AudioFormat audioFormat, AudioInputStream inputStream)
			throws LineUnavailableException, IOException {
		try (final SourceDataLine dataline = (SourceDataLine) AudioSystem.getLine(in)) {
			System.out.println(dataline);
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
