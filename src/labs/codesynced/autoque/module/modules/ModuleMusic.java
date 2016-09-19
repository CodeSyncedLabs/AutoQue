package labs.codesynced.autoque.module.modules;

import labs.codesynced.autoque.file.MusicFormat;

/**
 * @author Wylan Shoemaker - 9/17/2016
 */
public class ModuleMusic extends Module
{

	private MusicFormat musicFormat;
	private double preWait;
	private double postWait;
	private int target;
	private int position;

	/**
	 * Create a module for music playing
	 * @param name name identifier
	 * @param description description of what it does
	 * @param musicFormat file to be played
	 * @param preWait fade in time (seconds)
	 * @param postWait fade out time (seconds)
	 * @param target should always be 1
	 * @param position queue position
	 */
	public ModuleMusic(String name, String description, MusicFormat musicFormat, double preWait, double postWait, int target, int position)
	{
		super(name, description);
		this.musicFormat = musicFormat;
		this.preWait = preWait;
		this.postWait = postWait;
		this.target = target;
		this.position = position;
	}

	/**
	 * Getter for property 'musicFormat'.
	 *
	 * @return Value for property 'musicFormat'.
	 */
	public MusicFormat getMusicFormat()
	{
		return musicFormat;
	}

	/**
	 * Setter for property 'musicFormat'.
	 *
	 * @param musicFormat Value to set for property 'musicFormat'.
	 */
	public void setMusicFormat(MusicFormat musicFormat)
	{
		this.musicFormat = musicFormat;
	}

	/**
	 * Getter for property 'preWait'.
	 *
	 * @return Value for property 'preWait'.
	 */
	public double getPreWait()
	{
		return preWait;
	}

	/**
	 * Setter for property 'preWait'.
	 *
	 * @param preWait Value to set for property 'preWait'.
	 */
	public void setPreWait(double preWait)
	{
		this.preWait = preWait;
	}

	/**
	 * Getter for property 'postWait'.
	 *
	 * @return Value for property 'postWait'.
	 */
	public double getPostWait()
	{
		return postWait;
	}

	/**
	 * Setter for property 'postWait'.
	 *
	 * @param postWait Value to set for property 'postWait'.
	 */
	public void setPostWait(double postWait)
	{
		this.postWait = postWait;
	}

	/**
	 * Getter for property 'target'.
	 *
	 * @return Value for property 'target'.
	 */
	public int getTarget()
	{
		return target;
	}

	/**
	 * Setter for property 'target'.
	 *
	 * @param target Value to set for property 'target'.
	 */
	public void setTarget(int target)
	{
		this.target = target;
	}

	/**
	 * Getter for property 'position'.
	 *
	 * @return Value for property 'position'.
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * Setter for property 'position'.
	 *
	 * @param position Value to set for property 'position'.
	 */
	public void setPosition(int position)
	{
		this.position = position;
	}

}
