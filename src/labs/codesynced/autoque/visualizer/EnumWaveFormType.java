package labs.codesynced.autoque.visualizer;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public enum EnumWaveFormType
{

	STANDARD("STANDARD", 0);

	private String id;
	private int type;
	EnumWaveFormType(String id, int type)
	{
		this.id = id;
		this.type = type;
	}

	public String getId()
	{
		return id;
	}

	public int getType()
	{
		return type;
	}

}
