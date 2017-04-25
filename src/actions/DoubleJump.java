package actions;

import components.entityComponents.AccelerationComponent;
import components.entityComponents.ComponentType;
import components.entityComponents.VelocityComponent;
import entity.IEntity;
import entity.IEntityManager;
import gamedata.GameDataFactory;
import gamedata.IRestrictedGameData;

public class DoubleJump implements IAction {

	@Override
	public IRestrictedGameData executeAction(IEntity player, IEntity npc, IEntityManager myEM,
			IRestrictedGameData currentGameData) {
		VelocityComponent vc = (VelocityComponent) player.getComponent(ComponentType.Velocity);
		AccelerationComponent ac = (AccelerationComponent) player.getComponent(ComponentType.Acceleration);
		vc.setY(-5);
		ac.setY(.2);
		
		GameDataFactory gdf = new GameDataFactory();
		return gdf.blankEntityData(currentGameData);
	}
	

}