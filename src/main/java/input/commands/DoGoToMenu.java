package input.commands;

import javafx.event.ActionEvent;
import ui.UI;

import java.io.IOException;

public class DoGoToMenu {
    public static void doGoToMenu(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
    }
}
