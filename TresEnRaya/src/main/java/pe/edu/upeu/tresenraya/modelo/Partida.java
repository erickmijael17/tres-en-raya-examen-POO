package pe.edu.upeu.tresenraya.modelo;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private String estado; // "En juego", "Terminado", "Anulado"
    private int[][] tablero; // Representación del tablero (0: vacío, 1: jugador1, 2: jugador2)

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = null;
        this.estado = "En juego";
        this.tablero = new int[3][3]; // Tablero vacío al comenzar
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void marcarPosicion(int fila, int columna, int jugador) {
        if (tablero[fila][columna] == 0) {
            tablero[fila][columna] = jugador;
        }
    }

    public boolean hayGanador() {
        // Lógica para verificar si hay un ganador (completa filas, columnas o diagonales)
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != 0) {
                return true;
            }
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != 0) {
                return true;
            }
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != 0) {
            return true;
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != 0) {
            return true;
        }
        return false;
    }

    public boolean estaCompleto() {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                if (celda == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
