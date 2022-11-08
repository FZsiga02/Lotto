package hu.petrik.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoController {
    @FXML
    private Button sorsolGomb;

    @FXML
    private Label sorsoltSzamLabel;

    @FXML
    private HBox sorsoltSzamok;

    private static final Random RND = new Random();

    private final List<Integer> sorsoltSzamokLista = new ArrayList<>();

    public void sorsolClick(ActionEvent actionEvent) {
        if (sorsolGomb.getText().equals("Rendez")){
            Collections.sort(sorsoltSzamokLista);
            szamokFrissiteseListaAlapjan();
            sorsoltSzamokLista.clear();
            sorsolGomb.setText("Sorsol");
        }else {
            int sorsoltSzam = RND.nextInt(90) + 1;
            while (sorsoltSzamokLista.contains(sorsoltSzam)) {
                sorsoltSzam = RND.nextInt(90) + 1;
            }
            sorsoltSzamokLista.add(sorsoltSzam);
            sorsoltSzamLabel.setText(String.valueOf(sorsoltSzam));

            szamokFrissiteseListaAlapjan();

            if (sorsoltSzamokLista.size() == 5) {
                sorsolGomb.setText("Rendez");
            }
        }
    }

    private void szamokFrissiteseListaAlapjan() {
        sorsoltSzamok.getChildren().clear();
        for (int szam: sorsoltSzamokLista){
            sorsoltSzamok.getChildren().add(new Label(String.valueOf(szam)));
        }
    }
}