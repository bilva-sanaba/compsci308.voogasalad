package actions;

import class_annotations.BottomAction;
import class_annotations.LeftAction;
import class_annotations.RightAction;
import class_annotations.TopAction;
import components.entityComponents.ComponentType;
import components.entityComponents.ImagePropertiesComponent;
import components.entityComponents.LocationComponent;
import entity.IEntity;
import entity.IEntityManager;
import gamedata.IRestrictedGameData;


@TopAction()
@LeftAction()
@BottomAction()
@RightAction()
public class DoubleSize  extends AbstractAction implements IAction {
	private boolean c;
	
	public DoubleSize(boolean correction){
		c = correction;
	}
	@Override
	public IRestrictedGameData executeAction(IEntity player, IEntity npc, IEntityManager myEM, IRestrictedGameData currentGameData) {
//		SpriteComponent x = (SpriteComponent) player.getComponent(ComponentType.Sprite);
		
//		x.setClassPath(imagePath);
		ImagePropertiesComponent y = (ImagePropertiesComponent) player.getComponent(ComponentType.ImageProperties);
		if (c){
		LocationComponent t = (LocationComponent) player.getComponent(ComponentType.Location);
//		VelocityComponent v = (VelocityComponent) player.getComponent(ComponentType.Velocity);
		t.setY(t.getY()-y.getHeight());
		}
		y.setHeight(y.getHeight()*2);
		y.setWidth(y.getWidth()*2);
		player.changed(player);

		return getGameDataFactory().blankEntityData(currentGameData);
	}

}
