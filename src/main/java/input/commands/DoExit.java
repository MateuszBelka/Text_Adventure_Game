package input.commands;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class DoExit {
    public static void doExit (ActionEvent actionEvent) throws URISyntaxException {
        DoSave.doSave();
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.close();
    }

    private DoExit(){} //hiding the implicit public constructor
}
