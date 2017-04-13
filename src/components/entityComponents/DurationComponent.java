package components.entityComponents;

import components.IComponent;

public class DurationComponent implements IComponent {
	private double duration;

	public DurationComponent(double d) {
		duration = d;
	}
	
	public DurationComponent(){
		super();
	}

	@Override
	public ComponentType getComponentType() {
		return ComponentType.Duration;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double d) {
		duration = d;
	}

	public IComponent newCopy() {
		return new DurationComponent(getDuration());
	}
}
