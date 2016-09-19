package labs.codesynced.autoque.que;

import labs.codesynced.autoque.module.modules.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wylan Shoemaker - 9/17/2016
 */
public class QueRegistry
{

	private static List<Module> moduleList = new ArrayList<Module>();
	private static int queLength = moduleList.size();

	public static void addModule(Module module)
	{
		moduleList.add(module);
	}

	public static List<Module> getModuleList()
	{
		return moduleList;
	}

	public static int getNextQuePosition()
	{
		return queLength++;
	}

}
