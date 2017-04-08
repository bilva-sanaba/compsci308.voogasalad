package view;

import java.util.ArrayList;

import components.SpriteComponent;
import entity.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EntityBuilderWindow {
	
	private ObservableList<ImageView> blocksList;

	
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	private Image myImageImage = new Image(getClass().getClassLoader().getResourceAsStream("empty.jpg"));
	private ImageView myImage = new ImageView(myImageImage);
	private String myImagePath;
	private Entity myEntity;
	private ImageChooser imageChooser = new ImageChooser();
	private UtilityFactory util;
	private Stage myStage = new Stage();
	
	public EntityBuilderWindow(UtilityFactory utilIn, ObservableList<ImageView> blocksListIn){ 
		blocksList = blocksListIn;
		util = utilIn;
		nodeList.add(myImage);
		GridPane.setConstraints(myImage, 0, 0);
		myStage.setScene(buildScene());
	}
	
	public void showEntityBuilder(){
		myStage.show();
	}
	
	private Scene buildScene(){
		Node imageButton = util.buildButton("ChooseImageLabel", e->{
			myImagePath = imageChooser.chooseFile();
			Image image = new Image(myImagePath);
			myImage.setImage(image);
	        myImage.setFitWidth(50);
			myImage.setFitHeight(50);
		});
		nodeList.add(imageButton);
		GridPane.setConstraints(imageButton, 0, 1);
		
		Node okayButton = util.buildButton("OkayLabel", e->{
			myEntity = new Entity(19);
			myEntity.addComponent(new SpriteComponent(myImagePath));
			ImageView temp = new ImageView(new Image(myImagePath));
			blocksList.add(temp);
			myStage.close();
		});
		nodeList.add(okayButton);
		GridPane.setConstraints(okayButton, 0, 2);
		
		GridPane pane = buildPane();
		return new Scene(pane);
	}
	
	public ImageView getImage(){
		return myImage;
	}
	
	public Entity myEntity(){
		return myEntity;
	}
	
	private GridPane buildPane(){
		GridPane pane = new GridPane();
		pane.getChildren().addAll(nodeList);
		return pane;
	}

}
