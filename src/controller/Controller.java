package controller;

import data_interfaces.*;

import view_interfaces.UIViewInterface;
import javafx.stage.Stage;
import data_interfaces.XMLException;
import view.GUIBuilder;
import view.UtilityFactory;
import controller_interfaces.ControllerInterface;
import entity.EntityManager;

import gameEngine_interface.GameEngine;

/**
 * 
 * @author Jacob
 *
 */

public class Controller implements ControllerInterface {
	
	UIViewInterface myGameView;
	private GameEngine myGameEngine;
	private WorldAnimator myWorldAnimator;
	private Stage myStage;
	private String filePath;
	
	private GUIBuilder myGUIBuilder;
	
	
	public Controller(Stage s) {
		myStage = s;
		myGUIBuilder = new GUIBuilder(new UtilityFactory("English"));
		myGameView = new UIView(s, this);
		myWorldAnimator = new WorldAnimator();
	}

	@Override
	public void save(String fileName) {
		// TODO Auto-generated method stub
		//loop through and save all write all items to XML
		XMLWriter xw = new XMLWriter();
<<<<<<< HEAD
		xw.writeFile(fileName, myEntityManager.getEntities());
	}

	@Override
	public void loadNewGame(String filePath) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
		myGameEngine = new GameEngine(filePath);
=======
		xw.writeFile(filename, myGameEngine.save());
	}

	@Override
	public void loadNewGame(String gameName) {
		Communicator c = new Communicator(gameName);
		myGameEngine.loadData(c);
		RestrictedEntityManager restrictedEntityManager = myGameEngine.getRestrictedEntityManager();
		
>>>>>>> 5e6301035bc8d61251ead2fd0f04e528a985e67e
	}

	@Override
	public void resetCurrentGame() throws XMLException {
		if(!filePath.equals(null)){
			myGameEngine = new GameEngine(filePath);
		}
		else{
			throw new XMLException(String.format("No current game"));
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		//call world animator
		myWorldAnimator.start(myStage, myGameEngine);
	}

}
