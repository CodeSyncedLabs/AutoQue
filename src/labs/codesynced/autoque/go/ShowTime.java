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

	/**
	 * Halt the show for a given amount of time
	 * @param stage the stage to be halter
	 * @param time the number of SECONDS it is to be halted
	 */
	public static void intermission(Stage stage, long time)
	{
		time *= 60;
		try {
			Thread.sleep(time);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void wrap(Stage stage)
	{
		AutoQue.getLogger().info("That's a wrap!");
		AutoQue.getLogger().info("Closing stage: " + stage.getTitle().substring(12));
		stage.close();
	}

}
