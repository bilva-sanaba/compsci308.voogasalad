package entity.restricted;

import java.util.Observer;

import components.entityComponents.ImagePropertiesComponent;

import java.util.Observer;

import gameView.Coordinate;
/**
 * Interface for objects which the front end will receive
**/

public interface IRestrictedEntity {
	/**
	 * 
	 * @return ID of RestrictedEntity
	 */
	public int getID();
	/**
	 * 
	 * @return Coordinate of Entities location
	 */
	public Coordinate getLocation();
	/**
	 * 
	 * @return String which is the ImagePath of the Entity
	 */
	public String getImagePath();
	/**
	 * 
	 * @return ImagePropertiesComponent
	 */
	public ImagePropertiesComponent getIPComponent();
	
	
	public void addObserver(Observer obs);

}
