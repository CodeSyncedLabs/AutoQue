package labs.codesynced.autoque.module.modules;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class Module
{

	private String name;
	private String description;

	public Module(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

}
