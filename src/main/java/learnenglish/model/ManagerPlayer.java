package learnenglish.model;

import java.io.Closeable;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.DataLine.Info;

public class ManagerPlayer implements Closeable {
	private AudioFormat audioFormat;
	private Info in;
	private AudioInputStream inputStream;
	public AudioFormat getAudioFormat() {
		return audioFormat;
	}
	public void setAudioFormat(AudioFormat audioFormat) {
		this.audioFormat = audioFormat;
	}
	public Info getIn() {
		return in;
	}
	public void setIn(Info in) {
		this.in = in;
	}
	public AudioInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(AudioInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public void closeAudioInputStream() throws IOException {
		if(inputStream!=null) {
			inputStream.close();
		}
	}
	@Override
	public void close() throws IOException {
		if(inputStream!=null) {
			inputStream.close();
		}
	}
	
}
