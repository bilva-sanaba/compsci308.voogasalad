package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import components.IComponent;
import components.entityComponents.ComponentType;
import components.entityComponents.ImagePropertiesComponent;
import components.entityComponents.SpriteComponent;
import components.entityComponents.XYComponent;
import entity.restricted.IRestrictedEntity;
import entity.restricted.IRestrictedEntityManager;
import entity.restricted.RestrictedEntity;
import entity.restricted.RestrictedEntityManager;
import gameView.Coordinate;

public class EntityManager extends Observable implements IEntityManager, IRestrictedEntityManager {
	private Collection<Entity> myEntities;

	public EntityManager(Collection<Entity> entities){
		myEntities = new ArrayList<Entity>();
		for (Entity e: entities) {
			if (e.getComponent(ComponentType.Location) != null) {
				myEntities.add(e);
			}
		}
	}

	@Override
	public Map<Integer, IComponent> getCertainComponents(
			ComponentType certainComponent) {
		Map<Integer, IComponent> certainComponents = new HashMap<Integer, IComponent>();
		for (Entity e : myEntities) {

			certainComponents.put(e.getID(), e.getComponent(certainComponent));
		}
		return certainComponents;
	}
	public Collection<Entity> copy(){
		Collection<Entity> copy = new ArrayList<Entity>();
		for (Entity e: myEntities){
			Entity entCopy = e.clone();
			copy.add(e);
		}
		return copy;
	}

	@Override
	public RestrictedEntityManager getRestricted() {
		Collection<RestrictedEntity> certainComponents = new ArrayList<RestrictedEntity>();
		for (Entity e : myEntities){
			certainComponents.add( new RestrictedEntity(e.getID(),new Coordinate((XYComponent) e.getComponent(ComponentType.Location)),
					((SpriteComponent) e.getComponent(ComponentType.Sprite)).getClassPath(), (ImagePropertiesComponent) e.getComponent(ComponentType.ImageProperties)));

		}
		return new RestrictedEntityManager(certainComponents);
	}

	@Override
	public Map<IEntity, IRestrictedEntity> getEntityMap() {
		Map<IEntity, IRestrictedEntity> entityToRestricted = new HashMap<IEntity, IRestrictedEntity>();
		
		for (Entity e : myEntities) {
			if (e.getComponent(ComponentType.Location)!=null &&e.getComponent(ComponentType.Sprite)!=null){
			entityToRestricted.put(e,
					new RestrictedEntity(e.getID(), new Coordinate(
							(XYComponent) e
									.getComponent(ComponentType.Location)),
							((SpriteComponent) e
									.getComponent(ComponentType.Sprite))
									.getClassPath(),(ImagePropertiesComponent) e.getComponent(ComponentType.ImageProperties)));

		}
		;}
		return entityToRestricted;
	}
	
	public Entity getEntityByID(int ID){
		for(Entity currentEntity: myEntities){
			if(currentEntity.getID() == ID){
				return currentEntity;
			}
		}
		return null;
	}

	@Override
	public Collection<IRestrictedEntity> getRestrictedEntities() {
		Collection<IRestrictedEntity> restricted = new ArrayList<IRestrictedEntity>();
		for (Entity e : myEntities) {
			restricted.add((IRestrictedEntity) e);
		}
		return restricted;
	}
}
