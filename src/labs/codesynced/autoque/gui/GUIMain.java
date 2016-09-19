package labs.codesynced.autoque.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import labs.codesynced.autoque.AutoQue;
import labs.codesynced.autoque.go.ShowTime;
import labs.codesynced.autoque.toolkit.MonitorHelper;

/**
 * @author Wylan Shoemaker - 9/16/2016
 */
public class GUIMain
{

	/**
	 * Handling Elements
	 */
	private String name;
	private boolean startCenter;

	/**
	 * JavaFX Elements
	 */
	private AnchorPane layout;
	private FXMLLoader fxmlLoader;
	private Scene scene;
	private Stage stage;

	public GUIMain(String name, boolean startCenter)
	{
		this.name = name;
		this.startCenter = startCenter;
	}

	/**
	 * Initializes the scene. Should always be called else the scene will not be set up
	 * @param stage the parent stage
	 * @throws Exception thrown by setupLayout() when creating the FXML file.
	 */
	public void init(Stage stage) throws Exception
	{
		this.stage = stage;

		this.setupStage();
		this.setupLayout();
		this.setupScene();
		ShowTime.begin(this.stage);
	}

	/**
	 * Listens for a change in the size of the Scene. Should be impossible
	 * @param scene the scene that is being listened to
	 */
	private void resizeListener(Scene scene)
	{
		this.scene.widthProperty().addListener((observable, oldValue, newValue) -> layout.resize(scene.getWidth(), scene.getHeight()));

		this.scene.heightProperty().addListener((observable, oldValue, newValue) -> layout.resize(scene.getWidth(), scene.getHeight()));

	}

	/**
	 * Sets up the primary stage with basic functions
	 */
	protected void setupStage()
	{
		this.stage = new Stage();
		this.stage.setTitle(name);
		this.stage.setWidth(810);
		this.stage.setHeight(700);

		this.stage.setResizable(false);

		if(this.startCenter) this.stage.centerOnScreen();

		this.closeStageEvent();
	}

	/**
	 * Sets up the AnchorPane with the FXML file
	 * @throws Exception thrown by creating the FXML File
	 */
	protected void setupLayout() throws Exception
	{
		this.fxmlLoader = new FXMLLoader();
		this.fxmlLoader.setLocation(AutoQue.class.getResource("gui/layout/LayoutGuiMain.fxml"));

		this.layout = this.fxmlLoader.load();
		this.layout.autosize();
		this.layout.isResizable();
	}

	/**
	 * Sets up the scene
	 */
	protected void setupScene()
	{
		this.scene = new Scene(layout, MonitorHelper.getSizeWidth(), MonitorHelper.getSizeHeight());
		this.resizeListener(scene);
		this.stage.setScene(scene);
	}

	protected void closeStageEvent()
	{
		stage.setOnCloseRequest(event -> ShowTime.wrap(stage));
	}

	/**
	 * Gets the name of the stage
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the stage. NOTE: [AutoQue] cannot be removed.
	 * @param name
	 */
	public void setName(String name)
	{
		StringBuilder stringBuilder = new StringBuilder(this.name);

		this.name = "";

		stringBuilder.append(" - " + name);
		this.name = stringBuilder.toString();
	}

}
