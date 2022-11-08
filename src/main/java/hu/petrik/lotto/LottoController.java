package hu.petrik.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Random;

public class LottoController {
    @FXML
    private Button sorsolGomb;

    @FXML
    private Label sorsoltSzamLabel;

    @FXML
    private HBox sorsoltSzamok;

    private static final Random RND = new Random();

    public void sorsolClick(ActionEvent actionEvent) {
        int sorsoltSzam = RND.nextInt();
    }
}