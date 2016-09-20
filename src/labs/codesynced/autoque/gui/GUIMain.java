package labs.codesynced.autoque.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import labs.codesynced.autoque.AutoQue;
import labs.codesynced.autoque.go.ShowTime;
import labs.codesynced.autoque.gui.dialog.DialogConfirm;
import labs.codesynced.autoque.toolkit.MonitorHelper;
import labs.codesynced.autoque.toolkit.Resources;

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
	@FXML
	private Button buttonGo, buttonStop, buttonBack, buttonPause, buttonPlay;

	private Image imageGo, imageStop, imageBack, imagePause, imagePlay;

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
		this.setupButtons();
		this.setupScene();
		ShowTime.begin(this.stage);
	}

	private void setupButtons()
	{
		buttonGo = (Button) this.fxmlLoader.getNamespace().get("buttonGo");
		buttonStop = (Button) this.fxmlLoader.getNamespace().get("buttonStop");
		buttonBack = (Button) this.fxmlLoader.getNamespace().get("buttonBack");
		buttonPause = (Button) this.fxmlLoader.getNamespace().get("buttonPause");
		buttonPlay = (Button) this.fxmlLoader.getNamespace().get("buttonPlay");

		imageGo = new Image(AutoQue.class.getResourceAsStream(Resources.ICON_RESOURCE_PATH + "megaphone.png"));
		imageStop = new Image(AutoQue.class.getResourceAsStream(Resources.ICON_RESOURCE_PATH + "stop-1.png"));
		imageBack = new Image(AutoQue.class.getResourceAsStream(Resources.ICON_RESOURCE_PATH + "previous.png"));
		imagePause = new Image(AutoQue.class.getResourceAsStream(Resources.ICON_RESOURCE_PATH + "pause-1.png"));
		imagePlay = new Image(AutoQue.class.getResourceAsStream(Resources.ICON_RESOURCE_PATH + "play-button-1.png"));

		buttonGo.setGraphic(newImageView(buttonGo, imageGo));
		buttonStop.setGraphic(newImageView(buttonStop, imageStop));
		buttonBack.setGraphic(newImageView(buttonBack, imageBack));
		buttonPause.setGraphic(newImageView(buttonPause, imagePause));
		buttonPlay.setGraphic(newImageView(buttonPlay, imagePlay));
	}

	private ImageView newImageView(Button button, Image image)
	{
		ImageView view = new ImageView(image);
		view.setFitHeight(button.getPrefHeight());
		view.setFitWidth(button.getPrefWidth());
		view.setPreserveRatio(true);
		button.setTooltip(new Tooltip(button.getText()));
		button.setText(null);
		button.setCursor(Cursor.HAND);
		button.setBackground(Background.EMPTY);
		return view;
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
		this.fxmlLoader.setLocation(AutoQue.class.getResource(Resources.INTERNAL_GUI_PATH + "LayoutGuiMain.fxml"));

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
		stage.setOnCloseRequest(event -> new DialogConfirm("Are you sure?", "Yes", "No"));
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
