package input.commands;

import javafx.event.ActionEvent;
import ui.UI;

import java.io.IOException;

public class DoLoad {
    public static void doLoad(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/loadGame.fxml", actionEvent);
    }

    private DoLoad(){} //hiding the implicit public constructor
}
