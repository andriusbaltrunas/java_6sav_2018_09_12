package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private TextField userGuessTextField;
    @FXML
    private Label generatedNumberLabel;
    @FXML
    private Label guessNumberLabel;

    public void playGame(ActionEvent event) {
        Random rand = new Random();
        int random = rand.nextInt(10) + 1;
        if (!userGuessTextField.getText().equals("")) {
            try {
                int spejimas = Integer.parseInt(userGuessTextField.getText());
                if (random == spejimas) {
                    generatedNumberLabel.setText("Sveikiname Jus laimejot, sugalvotas skaicius buvo " + random);
                    guessNumberLabel.setText("");
                } else {
                    guessNumberLabel.setText("Jusu skaicius buvo neteisingas " + random);
                    generatedNumberLabel.setText("");
                }
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Iveskite skaiciu");
                alert.show();
            }
            userGuessTextField.setText("");

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tusciu reiksmiu ivesti negalima");
            alert.show();
        }
    }
}