import java.util.*;

public class TableroTest {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int coordenadaX;
		int coordenadaY;

		int coordenadafX;
		int coordenadafY;
		
		Tablero tablero = new Tablero();

		System.out.println("Ingrese coordenada inicial(x): ");
		coordenadaX = entrada.nextInt();
		System.out.println("Ingrese coordenada inicial(y): ");
		coordenadaY = entrada.nextInt();

		System.out.println(tablero.obtenerPiezaPorCoordenada(coordenadaX,
				coordenadaY));

		System.out.println("Ingrese coordenada final(x): ");
		coordenadafX = entrada.nextInt();
		System.out.println("Ingrese coordenada final(y): ");
		coordenadafY = entrada.nextInt();
		tablero.moverFicha(coordenadafX, coordenadafY,
				tablero.obtenerPiezaPorCoordenada(coordenadaX, coordenadaY));
		tablero.borrarFicha(coordenadaX, coordenadaY);
		tablero.dibujarTablero();
	}

}
