package labs.codesynced.autoque.module;

import labs.codesynced.autoque.module.modules.Module;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class ModuleRegistry
{

	public static void registerModule(Module module)
	{
		ModuleHelper.getModuleList().add(module);
	}

}
