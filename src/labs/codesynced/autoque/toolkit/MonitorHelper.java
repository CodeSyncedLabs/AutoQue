package labs.codesynced.autoque.toolkit;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class MonitorHelper
{

	private static GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public static int getSizeWidth()
	{
		return screenSize.width;
	}

	public static int getSizeHeight()
	{
		return screenSize.height;
	}

	public static ArrayList<Integer> getScreenRefreshRate()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < monitorNumber(); i++)
		{
			DisplayMode displayMode = graphicsDevices[i].getDisplayMode();

			if(displayMode.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN)
			{
				temp.add(-1);
			} else {
				temp.add(displayMode.getRefreshRate());
			}
		}
		return temp;
	}

	public static ArrayList<List<Integer>> screenSizes() {
		ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
		for(int i = 0; i < monitorNumber(); i++) {
			List<Integer> cacheList = new ArrayList<Integer>();
			cacheList.add(new Integer(graphicsDevices[i].getDisplayMode().getWidth()));
			cacheList.add(new Integer(graphicsDevices[i].getDisplayMode().getHeight()));
			temp.add(cacheList);
		}
		return temp;
	}

	public static ArrayList<Integer> getScreensWidth() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < monitorNumber(); i++) {
			temp.add(graphicsDevices[i].getDisplayMode().getWidth());
		}
		return temp;
	}

	public static ArrayList<Integer> getScreensHeight() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < monitorNumber(); i++) {
			temp.add(graphicsDevices[i].getDisplayMode().getHeight());
		}
		return temp;
	}

	public static int monitorNumber()
	{
		return graphicsDevices.length;
	}

}
