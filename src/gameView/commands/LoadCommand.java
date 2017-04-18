package gameView.commands;

import javafx.stage.Stage;
import gameView.ICommandView;
import gameView.UIView;
import gameView.tools.GameChooser;

public class LoadCommand extends AbstractCommand {

	public LoadCommand(ICommandView m) {
		super(m);
	}

	@Override
	public void execute(Stage s) {
		GameChooser gameChoice = new GameChooser(s);
		Stage newStage = gameChoice.selectFile();
		newStage.showAndWait();
		getView().loadGame(gameChoice.getFile());
	}

	@Override
	public String getName() {
		return "Load";
	}

}
