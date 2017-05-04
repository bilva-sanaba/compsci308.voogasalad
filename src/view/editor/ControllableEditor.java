package view.editor;

import components.IComponent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import view.UtilityFactory;

public class ControllableEditor extends ComponentEditor {
	private EditableComponents componentName = EditableComponents.Controllable;
	private String[] cont = { "false" }; // Initialize array
	private HBox myBox;
	private boolean myControl;

	public ControllableEditor(UtilityFactory utilf) {
		myBox = new HBox();
		final ToggleGroup group = utilf.buildRadioButtonGroup("SelectControllable", myBox);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				cont = (String[]) new_toggle.getUserData();
				myControl = cont[0].equals("true");
			}
		});
		setInputNode(myBox);
	}

	@Override
	public IComponent getComponent() {
		return getCompF().getComponent(componentName.toString(), myControl);
	}

}
