package pe.edu.upeu.tresenraya.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Control {

    @FXML private Button btn0;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Label lblTurno;
    @FXML private Label puntosJugador1;
    @FXML private Label puntosJugador2;
    @FXML private TextField nombreJugador1;
    @FXML private TextField nombreJugador2;

    private boolean turnoJugador1 = true;
    private int puntuacionJugador1 = 0;
    private int puntuacionJugador2 = 0;
    private Button[] botones;

    @FXML
    public void initialize() {
        botones = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        iniciarPartida();
    }

    @FXML
    private void marcarPosicion(javafx.event.ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        if (botonPresionado.getText().isEmpty()) {
            if (turnoJugador1) {
                botonPresionado.setText("X");
                lblTurno.setText("Turno: Jugador 2 (O)");
            } else {
                botonPresionado.setText("O");
                lblTurno.setText("Turno: Jugador 1 (X)");
            }
            turnoJugador1 = !turnoJugador1;
            verificarGanador();
        }
    }

    private void verificarGanador() {
        // Implementa la lógica para verificar el ganador
        // Actualiza los puntajes y limpia el tablero si es necesario
    }

    @FXML
    private void iniciarPartida() {
        for (Button boton : botones) {
            boton.setText("");
            boton.setDisable(false);
        }
        lblTurno.setText("Turno: Jugador 1 (X)");
    }

    @FXML
    private void anularPartida() {
        iniciarPartida();
        nombreJugador1.clear();
        nombreJugador2.clear();
    }
}
