package labs.codesynced.autoque.toolkit;

/**
 * @author Wylan Shoemaker - 9/17/2016
 */
public class Logger
{

	private String name;

	public Logger(String name)
	{
		this.name = name;
	}

	public void info(String info)
	{
		System.out.println(formattedName() + info);
	}

	public void error(String error)
	{
		System.err.println(formattedName() + error);
	}

	private String formattedName()
	{
		return "[" + name + "]";
	}

}
