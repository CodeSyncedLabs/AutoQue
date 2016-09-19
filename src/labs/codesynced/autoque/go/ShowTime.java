package labs.codesynced.autoque.go;

import javafx.stage.Stage;
import labs.codesynced.autoque.AutoQue;

/**
 * @author Wylan Shoemaker - 9/18/2016
 */
public class ShowTime
{

	public static void begin(Stage stage)
	{
		AutoQue.getLogger().info("Break a leg!");
		AutoQue.getLogger().info("Showing stage: " + stage.getTitle().substring(12));
		stage.show();
	}

}
