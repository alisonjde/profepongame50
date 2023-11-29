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

	public void actualizarMovimientosCorrectos(int jugadorActual, ArrayList<String> movimientosLegales) {
	    int otroJugador = 3 - jugadorActual;
	    movimientosLegales.clear();

	    int[] nuevaFila = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] nuevaColumna = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int i = 0; i < 8; i++) {
	    	
	        for (int j = 0; j < 8; j++) {
	        	
	            if (matriz[i][j] == jugadorActual) {
	        
	            	for (int cambio = 0; cambio < 8; cambio++) {
	            		int fila = i + nuevaFila[cambio];
	            		int columna = j + nuevaColumna[cambio];
	            		if ((fila >= 0) && (fila < 8) && (columna >= 0) && (columna < 8) && (matriz[fila][columna] == otroJugador)) {
	                    
	            			do {                        
	            				fila += nuevaFila[cambio];
	                            columna += nuevaColumna[cambio];
	                        } while ((fila >= 0) && (fila < 8) && (columna >= 0) && (columna < 8) && (matriz[fila][columna] == otroJugador));
	                        
	            			if ((fila >= 0) && (fila < 8) && (columna >= 0) && (columna < 8) && (matriz[fila][columna] == 0)) {
	                            movimientosLegales.add(fila + "," + columna);
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
		
	public void voltiarepa(int fila, int columna, int jugador) {
	    int oponente = 3 - jugador;

	    int[] nuevaFila = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] nuevaColumna = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int cambio = 0; cambio < 8; cambio++) {
	    	
	        int i = fila + nuevaFila[cambio];
	        int j = columna + nuevaColumna[cambio];

	        if ((i >= 0) && (i < 8) && (j >= 0) && (j < 8) && (matriz[i][j] == oponente)) {
	        	
	            do {
	                i += nuevaFila[cambio];
	                j += nuevaColumna[cambio];
	            } while ((i >= 0) && (i < 8) && (j >= 0) && (j < 8) && (matriz[i][j] == oponente));
	            
	            if ((i >= 0) && (i < 8) && (j >= 0) && (j < 8) && (matriz[i][j] == jugador)) {
	            	
	                int filapi = fila + nuevaFila[cambio];
	                int columnaj = columna + nuevaColumna[cambio];
	                while (filapi != i || columnaj != j) {
	                    matriz[filapi][columnaj] = jugador;
	                    filapi += nuevaFila[cambio];
	                    columnaj += nuevaColumna[cambio];
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

