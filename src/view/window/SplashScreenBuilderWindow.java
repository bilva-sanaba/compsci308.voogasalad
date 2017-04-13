package view.window;

import entity.Entity;
import entity.SplashEntity;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.ImageChooser;
import view.UtilityFactory;

public class SplashScreenBuilderWindow implements IWindow{	
	private UtilityFactory utilF;
	private Text myFilePathDisplay;
	private String splashScreenImagePath;
	private String gameTitle;
	private String instructions;
	private TextField gameTitleInput;
	private TextField instructionsInput;
	
	public SplashScreenBuilderWindow() {
		myFilePathDisplay = new Text("");
	}
	
//	This shit needs to be refactored
	public SplashEntity createEntity() {
		myRoot.setPadding(new Insets(10));
//		pickColor(root);
		selectText(myRoot);
		myFilePathDisplay = new Text("");
		Button chooseImageButton = new Button("Choose Image");
		chooseImageButton.setOnAction(e -> {
			ImageChooser ic = new ImageChooser();
			splashScreenImagePath = ic.chooseFile();
			myFilePathDisplay.setText(splashScreenImagePath);
		});
		Button okayButton = new Button("OkayButtonLabel");
		okayButton.setOnAction(e -> {
			gameTitle = gameTitleInput.getText();
			instructions = instructionsInput.getText();
			myStage.close();
		});
		myRoot.getChildren().add(chooseImageButton);
		myRoot.getChildren().add(myFilePathDisplay);
		myRoot.getChildren().add(okayButton);
		Scene scene = new Scene(myRoot, 350, 300);
		myStage.setScene(scene);
		myStage.setTitle("Customize Splash Screen");
		openWindow();
		
//		beneath here is a splash entity which you instantiate with all the values you just found at the x's
		SplashEntity s = new SplashEntity(1, gameTitle, instructions, splashScreenImagePath);
		return s;
	}
	
//	private void pickColor(Pane root){
//		Label backgroundColorTitle = new Label("Background Color");
//		GridPane.setConstraints(backgroundColorTitle, 0, 0);
//		ColorPicker colorPicker = new ColorPicker();
//		GridPane.setConstraints(colorPicker, 1, 1);
//		Circle circle = new Circle(50);
//		GridPane.setConstraints(circle, 0, 1);
//		circle.setFill(colorPicker.getValue());
//		colorPicker.setOnAction(e -> circle.setFill(colorPicker.getValue()));
//		root.getChildren().addAll(backgroundColorTitle, circle, colorPicker);	
//	}
	
	private void selectText(Pane root){
		Label getGameTitle = new Label("Game Title:");
		gameTitleInput = new TextField();
		root.getChildren().addAll(getGameTitle, gameTitleInput);
		
		Label getInstructions = new Label("Instructions:");
		instructionsInput = new TextField();
		root.getChildren().addAll(getInstructions, instructionsInput);
	}

	@Override
	public void openWindow() {
		myStage.show();
	}
}