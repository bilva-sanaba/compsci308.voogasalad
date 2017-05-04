package view;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import components.entityComponents.ComponentType;
import entity.Entity;

public class ViewController implements Observer {
	private ViewData myData;
	private LevelTabView levelTabs;
	private TabView myTab;
	private UtilityFactory utilF;

	public ViewController(ViewData dataIn, LevelTabView levelIn, TabView tabIn, UtilityFactory utilIn) {
		myData = dataIn;
		levelTabs = levelIn;
		myTab = tabIn;
		utilF = utilIn;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null){
			Entity currentlySelected = myData.getUserSelectedEntity();
			LevelTab level = levelTabs.getTabsList().get(myData.getCurrentLevel());
			level.getGrid().clearEntitiesOnGrid();
			level.getGrid().drawPlacedEntities();
			level.getGrid().updateBackground();
			
			
			myTab.clearEntitiesOnTab();
			//myTab.addPresetEntities();
			myTab.addDefinedEntities();
			myTab.selectEntity(currentlySelected);
		}
		else if(arg.equals("reset")){
			levelTabs.clearTabs();
			for(int i : myData.getPlacedEntityMap().keySet()){
				GridView tempGrid = new GridView(utilF, i, myData, GUIBuilder.INITIAL_GRID_ROWS, GUIBuilder.INITIAL_GRID_COLS);
				levelTabs.addNewTab(tempGrid, i);
			}
		}
		
	}

}
