package view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


/**
 * @author Justin Yang
 *
 */
public class GridView extends GUIComponent {
	GridPane myGrid;
	
	public GridView(UtilityFactory utilF, int rows, int cols) {
		myGrid = new GridPane();
		myGrid.setGridLinesVisible(true);
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				addMouseListenerPane(row, col);
			}
		}
	}
	
	private void addMouseListenerPane(int row, int col) {
		Rectangle rect = new Rectangle(40, 40);
		rect.setFill(Color.GRAY);
		rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println(String.format("Click at row %d col %d", row, col));
			}
		});
		myGrid.add(rect, row, col);
	}
	
	@Override
	public Region buildComponent() {
		return myGrid;
	}
}
