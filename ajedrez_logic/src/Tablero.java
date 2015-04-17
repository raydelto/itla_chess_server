import java.util.*;

public class Tablero {
	
	int x=0;
	int[][] tablero= {	{0, 1,  2,  3,  4,  5,  6,  7,  8},
						{1, 86, 83, 84, 88, 87, 84, 83, 86},
						{2, 81, 81, 81, 81, 81, 81, 81, 81},
						{3,  0,  0,  0,  0,  0,  0,  0,  0 },
						{4,  0,  0,  0,  0,  0,  0,  0,  0 },
						{5,  0,  0,  0,  0,  0,  0,  0,  0 },
						{6,  0,  0,  0,  0,  0,  0,  0,  0 },
						{7, 91, 91, 91, 91, 91, 91, 91, 91 },
						{8, 96, 93, 94, 98, 97, 94, 93, 96 }
					
					};
	public Tablero(){
		
		
		
		for(int i=0; i<9; i++){
			System.out.println();
			for(int j=0; j<9; j++){
				System.out.print(tablero[i][j]);
				System.out.print("    ");
			
			}
		}
		
	}
	
	public void dibujarTablero(){
		for(int i=0; i<9; i++){
			System.out.println();
			for(int j=0; j<9; j++){
				System.out.print(tablero[i][j]);
				System.out.print("    ");
			
			}
		}
	}
	
	public void imprimirPosicion(){
		System.out.print(tablero[5][1]);
	}
	
	public int borrarFicha(int x, int y){
		return tablero[x][y]=0;
	}
	
	public int obtenerPiezaPorCoordenada(int x, int y ){
		return tablero[x][y];
	}
	
	public int moverFicha(int x, int y, int ficha){
		
		return tablero[x][y]= ficha;
	}
	
	

}
