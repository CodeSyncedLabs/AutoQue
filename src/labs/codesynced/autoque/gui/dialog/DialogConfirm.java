package labs.codesynced.autoque.gui.dialog;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import labs.codesynced.autoque.AutoQue;
import labs.codesynced.autoque.go.ShowTime;
import labs.codesynced.autoque.toolkit.MonitorHelper;
import labs.codesynced.autoque.toolkit.Resources;

/**
 * @author Wylan Shoemaker - 9/18/2016
 */
public class DialogConfirm
{

	private String dialog;
	private String button0;
	private String button1;

	private Stage stage;
	private FXMLLoader loader;
	private AnchorPane anchorPane;
	private Scene scene;

	//@FXML
	private Button dialogYes, dialogNo;
	//@FXML
	private Label dialogLabel;

	public DialogConfirm(String dialog, String button0, String button1)
	{
		this.dialog = dialog;
		this.button0 = button0;
		this.button1 = button1;
		setup();
	}

	protected void setup()
	{
		try {
			setupButton();
			setupTextArea();
			setupStage();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void setupStage() throws Exception
	{
		loader = new FXMLLoader();
		loader.setLocation(AutoQue.class.getResource(Resources.INTERNAL_GUI_PATH + "LayoutConfirmDialog.fxml"));

		anchorPane = (AnchorPane) loader.load();

		anchorPane.getChildren().add(dialogLabel);
		anchorPane.getChildren().add(dialogYes);
		anchorPane.getChildren().add(dialogNo);

		this.scene = new Scene(anchorPane, MonitorHelper.getSizeWidth(), MonitorHelper.getSizeHeight());

		this.stage = new Stage();
		this.stage.initModality(Modality.APPLICATION_MODAL);
		stage.setMaxWidth(250);
		stage.setMaxHeight(100);
		stage.setResizable(false);
		stage.setTitle("Are you sure?");
		stage.setAlwaysOnTop(true);
		stage.showAndWait();
	}

	protected void setupButton()
	{
		dialogYes = new Button(button0);
		dialogNo = new Button(button1);

		dialogYes.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent event)
			{
				ShowTime.wrap(stage);
			}
		});

		dialogNo.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent event)
			{

			}
		});
	}

	protected void setupTextArea()
	{
		dialogLabel = new Label();
		dialogLabel.setText("Are you sure?");
	}

}
