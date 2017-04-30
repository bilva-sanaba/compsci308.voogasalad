package gameView.userInput;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class UserInputData implements IRestrictedUserInputData, IUserInputData {

	private DoubleProperty myRewind;
	
	public UserInputData() {
		myRewind = new SimpleDoubleProperty(0);
	}

	@Override
	public ReadOnlyDoubleProperty getRewind() {
		return (ReadOnlyDoubleProperty) myRewind;
	}

	@Override
	public void setRewind(double k) {
		myRewind.setValue(k);
	}
	
	
}
