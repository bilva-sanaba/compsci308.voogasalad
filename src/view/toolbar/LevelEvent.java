package view.toolbar;

import data_interfaces.GameSavingDataTool;
import view.SplashScreenBuilderWindow;
import view.ViewData;

public class LevelEvent extends GameSavingDataTool implements ToolBarButtonEvent {
	private ViewData myData;
	
	public LevelEvent(ViewData data) {
		myData = data;
	}
	
	@Override
	public void event() {
		System.out.println("maybe");
		SplashScreenBuilderWindow window = new SplashScreenBuilderWindow();
		window.openWindow();
	}

}