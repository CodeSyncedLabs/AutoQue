package labs.codesynced.autoque.module;

import labs.codesynced.autoque.module.modules.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class ModuleHelper
{

	private static List<Module> moduleList = new ArrayList<Module>();

	public ModuleHelper()
	{

	}

	public static List<Module> getModuleList()
	{
		return moduleList;
	}

	public static Module getModuleByName(String name)
	{
		for(Module module : moduleList)
		{
			if(module.getName() == name)
			{
				return module;
			}
		}
		return null;
	}

}
