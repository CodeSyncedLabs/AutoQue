package labs.codesynced.autoque;

import javafx.application.Application;
import javafx.stage.Stage;
import labs.codesynced.autoque.gui.GUIMain;
import labs.codesynced.autoque.toolkit.Logger;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class AutoQue extends Application
{

    private static AutoQue INSTANCE = new AutoQue();
    private static Logger logger = new Logger("AutoQue");

    private GUIMain guiMain;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        guiMain = new GUIMain("[AutoQue] - Default Layout", true);
        guiMain.init(stage);
    }

    public static AutoQue getInstance()
    {
        return INSTANCE;
    }

    public static Logger getLogger() {return logger;};

}
