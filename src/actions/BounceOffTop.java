package actions;

import java.util.ArrayList;
import java.util.List;

import class_annotations.TopAction;
import components.entityComponents.ComponentType;

import components.entityComponents.VelocityComponent;

import entity.IEntity;
import entity.IEntityManager;
import gamedata.GameDataFactory;
import gamedata.IRestrictedGameData;

@TopAction()

public class BounceOffTop implements IAction {
	public static final double VELOCITY_REVERSE = -1;
	public static final double BOUNCE_FACTOR = 0.66;

	

	@Override

	public IRestrictedGameData executeAction(IEntity player, IEntity npc, IEntityManager myEM, IRestrictedGameData currentGameData) {

		VelocityComponent vc = (VelocityComponent) player.getComponent(ComponentType.Velocity);
		
		if (vc.getY()>0 && vc.getY()<0.25) {
			vc.setY(0);
			
		} else {
			if (vc.getY()>0) {
				vc.setY(vc.getY()*VELOCITY_REVERSE*BOUNCE_FACTOR);
			} 
		}
		
		
		GameDataFactory gdf = new GameDataFactory();
		return gdf.blankEntityData(currentGameData);
	}

}
