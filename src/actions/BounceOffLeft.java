package actions;

import class_annotations.LeftAction;
import components.entityComponents.ComponentType;
import components.entityComponents.ImagePropertiesComponent;
import components.entityComponents.LocationComponent;
import components.entityComponents.VelocityComponent;
import entity.IEntity;
import entity.IEntityManager;
import gamedata.IRestrictedGameData;


@LeftAction()
public class BounceOffLeft extends AbstractAction  implements IAction {
	
	public static final double VELOCITY_REVERSE = -1;
	public static final double BOUNCE_FACTOR = 0.5;

	@Override

	public IRestrictedGameData executeAction(IEntity e,IEntity e2, IEntityManager myEM, IRestrictedGameData currentGameData) {

//		AccelerationComponent ac = (AccelerationComponent) e.getComponent(ComponentType.Acceleration);
		VelocityComponent vc = (VelocityComponent) e.getComponent(ComponentType.Velocity);
		LocationComponent lcE0 = (LocationComponent) e.getComponent(ComponentType.Location);
		ImagePropertiesComponent ipE0 = (ImagePropertiesComponent) e.getComponent(ComponentType.ImageProperties);
		LocationComponent lcE1 = (LocationComponent) e2.getComponent(ComponentType.Location);
		lcE0.setX(lcE1.getX()-ipE0.getWidth());
		
		
		if(vc.getX() > 0) {
			vc.setX(vc.getX()*VELOCITY_REVERSE*BOUNCE_FACTOR);
		}
		
		return getGameDataFactory().blankEntityData(currentGameData);

	}
}
