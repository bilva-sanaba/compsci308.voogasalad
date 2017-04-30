package components.entityComponents;

import components.IComponent;

public class GoalComponent implements IComponent {
	
	private boolean goalSatisfied = false;

	@Override
	public ComponentType getComponentType() {
		return ComponentType.Goal;
	}

	@Override
	public IComponent newCopy() {
		GoalComponent myGoalComponent = new GoalComponent();
		if(goalSatisfied == true){
			myGoalComponent.satisfyGoal(true);
		}
		return myGoalComponent;
	}
	
	public void satisfyGoal(boolean bool){
		goalSatisfied = bool;
	}
	
	public boolean checkIfSatisfied(){
		return goalSatisfied;
	}
	
}
