package achievements;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Achievement implements IAchievement {
	private final String ACHIEVEMENTUNLOCKED = "Achievement Unlocked: ";
	private final int PADDING = 20;
	private final int WIDTH = 2;
	private final int HEIGHT = 4;
	private final int xCORRECTION = 50;
	private final int yCORRECTION = 350;
	
	private String message;
	private Group group;
	
	public Achievement(String message){
		this.message = message;
		group = new Group();
	}
	
	public Group execute() {
		return createEllipse();
	}
	
	private Group createEllipse(){
		Group group = new Group();
		
		Label t = new Label(ACHIEVEMENTUNLOCKED+message);
		Ellipse ellipse = new Ellipse();
		
		DoubleBinding halfWidth = t.widthProperty().divide(WIDTH).add(PADDING);
		DoubleBinding halfHeight = t.heightProperty().divide(HEIGHT).add(PADDING);
		DoubleBinding xLoc = halfWidth.subtract(xCORRECTION);
		DoubleBinding yLoc = halfHeight.add(yCORRECTION);
		
		ellipse.radiusXProperty().bind(halfWidth);
		ellipse.radiusYProperty().bind(halfHeight);
		ellipse.centerXProperty().bind(xLoc);
		ellipse.centerYProperty().bind(yLoc);
		ellipse.setFill(Color.LIGHTGREEN);
		
		t.layoutXProperty().bind(xLoc.subtract(t.widthProperty().divide(2)));
		t.layoutYProperty().bind(yLoc.subtract(t.heightProperty().divide(2)));
		
		group.getChildren().addAll(ellipse, t);
		return group;
		
	}
	
}
