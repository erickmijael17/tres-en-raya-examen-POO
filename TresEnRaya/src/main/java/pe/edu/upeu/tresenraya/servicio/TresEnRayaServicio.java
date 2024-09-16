package pe.edu.upeu.tresenraya.servicio;

import pe.edu.upeu.tresenraya.modelo.Jugador;
import pe.edu.upeu.tresenraya.modelo.Partida;

public class TresEnRayaServicio {
    private Partida partidaActual;

    public void iniciarPartida(Jugador jugador1, Jugador jugador2) {
        partidaActual = new Partida(jugador1, jugador2);
    }

    public Partida getPartidaActual() {
        return partidaActual;
    }

    public boolean marcarPosicion(int fila, int columna, int jugador) {
        if (partidaActual.getTablero()[fila][columna] == 0) {
            partidaActual.marcarPosicion(fila, columna, jugador);
            return true;
        }
        return false;
    }

    public boolean verificarGanador() {
        return partidaActual.hayGanador();
    }

    public boolean verificarEmpate() {
        return partidaActual.estaCompleto() && !partidaActual.hayGanador();
    }

    public void finalizarPartida() {
        partidaActual.setEstado("Terminado");
    }

    public void anularPartida() {
        partidaActual.setEstado("Anulado");
    }
}
