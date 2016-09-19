package labs.codesynced.autoque.file;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Wylan Shoemaker - 9/17/2016
 */
public class MusicFormat
{

	private File file;
	private AudioInputStream audioInputStream;
	private AudioFormat audioFormat;
	private long frameRate;
	private double duration;

	private Clip clip;

	public MusicFormat(File file)
	{
		this.file = file;
		try
		{
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws IOException, UnsupportedAudioFileException
	{
		this.audioInputStream = AudioSystem.getAudioInputStream(file);
		this.audioFormat = audioInputStream.getFormat();
		this.frameRate = audioInputStream.getFrameLength();
		this.duration = (frameRate + 0.0) / audioFormat.getFrameRate();
	}

	public void play() throws Exception
	{
		this.clip = AudioSystem.getClip();
		this.clip.open(audioInputStream);
		this.clip.start();
	}

	public void stop()
	{
		this.clip.stop();
	}

	public  File getFile()
	{
		return file;
	}

	public AudioInputStream getAudioInputStream()
	{
		return audioInputStream;
	}

	public AudioFormat getAudioFormat()
	{
		return audioFormat;
	}

	public long getFrameRate()
	{
		return frameRate;
	}

	public double getDuration()
	{
		return duration;
	}

}
