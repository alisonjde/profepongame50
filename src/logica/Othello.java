package logica;

import java.util.ArrayList;

public class Othello {
	
	private int matriz[][]= {
			{0, 0, 0, 0, 0, 0, 0, 0},
			
			{0, 0, 0, 0, 0, 0, 0, 0},
			
			{0, 0, 0, 0, 0, 0, 0, 0},
			
			{0, 0, 0, 2, 1, 0, 0, 0},
			
			{0, 0, 0, 1, 2, 0, 0, 0},
			
			{0, 0, 0, 0, 0, 0, 0, 0},
			
			{0, 0, 0, 0, 0, 0, 0, 0},
			
			{0, 0, 0, 0, 0, 0, 0, 0}
			};
	
	public ArrayList<String> posiblesNegras;
	public ArrayList<String> posiblesBlancos;
	private int contadorBlancas=0;
	private int contadorNegras=0;
	
	
	public Othello() {
		
		this.posiblesBlancos = new ArrayList<String>();
		this.posiblesNegras = new ArrayList<String>();
		this.actualizarMovimientosCorrectos(1, posiblesNegras);
		this.actualizarMovimientosCorrectos(2, posiblesBlancos);
	}
	
		
	
	public int contadorNegras() {
		contadorNegras=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(matriz[i][j]==1) {
					contadorNegras++;
				}
			}
		}
		return contadorNegras;
	}

	
	public int[][] getMatriz() {
		return matriz;
	}

	
	public void setMatriz(int matriz[][]) {
		this.matriz = matriz;
	}
	
	
	public void mostrarMatriz() {
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            System.out.print(matriz[i][j] + " ");
	        }
	        System.out.println();
	    }
	}

	
	public boolean movimientoCorrectoNegras(int fila, int columna) {
		String coordenadaSeleccionada = fila + "," + columna;
		for(String posibleFNegra: posiblesNegras) {
			if(posibleFNegra.equals(coordenadaSeleccionada)) {
				return true;
			}	
		}
		return false;	
	}
	
	
	public void ejecutarMovimientoNegras(int fila, int columna) {
		matriz[fila][columna] = 1;
		voltiarepa(fila, columna, 1);
		this.actualizarMovimientosCorrectos(1, posiblesNegras);
		this.actualizarMovimientosCorrectos(1, posiblesBlancos);


	}
	
	public boolean movimientoCorrectoBlancas(int fila, int columna) {
		String coordenadaSeleccionada = fila + "," + columna;
		for(String posibleFBlanca: posiblesBlancos) {
			if(posibleFBlanca.equals(coordenadaSeleccionada)) {
				posiblesBlancos.removeAll(posiblesBlancos);
				return true;				
			}			
		}
		return false;		
	}
	
	
	public int contadorBlancas() {
		
		contadorBlancas=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(matriz[i][j]==2) {
					contadorBlancas++;		
				}
			}
		}
		return contadorBlancas;	
	}
	
	

	public void ejecutarMovimientoBlancas(int fila, int columna) {
	    matriz[fila][columna] = 2;
		voltiarepa(fila, columna, 2);

	    this.actualizarMovimientosCorrectos(1, posiblesNegras);
		this.actualizarMovimientosCorrectos(1, posiblesBlancos);
	}

	
	public void voltiarepa(int fila, int columna, int jugador) {
	    int oponente = 3 - jugador;

	    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int dir = 0; dir < 8; dir++) {
	        int i = fila + dx[dir];
	        int j = columna + dy[dir];

	        if (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == oponente) {
	            do {
	                i += dx[dir];
	                j += dy[dir];
	            } while (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == oponente);
	            
	            if (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == jugador) {
	                int xi = fila + dx[dir];
	                int yj = columna + dy[dir];
	                while (xi != i || yj != j) {
	                    matriz[xi][yj] = jugador;
	                    xi += dx[dir];
	                    yj += dy[dir];
	                }
	            }
	        }
	    }
	}


	
	
	public void actualizarMovimientosCorrectos(int jugadorActual, ArrayList<String> movimientosLegales) {
	    int oponente = 3 - jugadorActual;
	    movimientosLegales.clear();

	    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if (matriz[i][j] == jugadorActual) {
	                for (int dir = 0; dir < 8; dir++) {
	                    int x = i + dx[dir];
	                    int y = j + dy[dir];
	                    if (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == oponente) {
	                        do {
	                            x += dx[dir];
	                            y += dy[dir];
	                        } while (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == oponente);
	                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == 0) {
	                            movimientosLegales.add(x + "," + y);
	                        }
	                    }
	                }
	            }
	        }
	    }
	}

	public int getContadorFichasBlancas() {
		return contadorBlancas;
	}

	public void setContadorFichasBlancas(int contadorFichasBlancas) {
		this.contadorBlancas = contadorFichasBlancas;
	}
}

