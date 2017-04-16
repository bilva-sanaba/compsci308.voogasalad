package gameView;

import components.entityComponents.XYComponent;
import components.movementcomponents.LocationComponent;

public class Coordinate {

	private double myX;
	private double myY;

	public Coordinate(double x, double y) {
		myX = x;
		myY = y;
	}

	public Coordinate(XYComponent xy) {
		myX = xy.getX();
		myY = xy.getY();
	}

	public double getX() {
		return myX;
	}

	public double getY() {
		return myY;
	}

}
