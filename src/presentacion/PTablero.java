package presentacion;
import logica.Othello;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PTablero extends JPanel implements MouseListener {
	
    private Othello othello;
    private int[][] tMatriz;

    private int turno=2;
    private FOthello fOthello;
    public PTablero(Othello othello, FOthello fOthello) {
        this.othello = othello;
        this.fOthello = fOthello;
		this.addMouseListener(this);
	  }
	
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(250, 250, 250));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        for(int i=this.getWidth()/8; i<this.getWidth(); i+=this.getWidth()/8) {
            g2d.drawLine(i, 0, i, this.getHeight());
        }
        for(int i=this.getHeight()/8; i<this.getHeight(); i+=this.getHeight()/8) {
            g2d.drawLine(0, i, this.getWidth(), i);
        }

        if (this.tMatriz != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.tMatriz[i][j] == 1) {
                        Image img = new ImageIcon("img/fichaFNegra.png").getImage();
                        g2d.drawImage(img, j * this.getWidth() / 8, i * this.getHeight() / 8, this.getWidth() / 8, this.getHeight() / 8, this);
                    } else if (this.tMatriz[i][j] == 2) {
                        Image img = new ImageIcon("img/fichaFBlanca.png").getImage();
                        g2d.drawImage(img, j * this.getWidth() / 8, i * this.getHeight() / 8, this.getWidth() / 8, this.getHeight() / 8, this);
                    }
                }
            }
        }
    }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int fila = e.getX();
		int columna = e.getY();
		int primeraCoordenada = fila / (this.getWidth() / 8);
		int segundaCoordenada = columna / (this.getHeight() / 8);

		if (getTurno()% 2 == 0) {
			if (othello.movimientoCorrectoNegras(segundaCoordenada, primeraCoordenada)) {
				
				othello.ejecutarMovimientoNegras(segundaCoordenada, primeraCoordenada);
				actualizarTablero();				
				setTurno(getTurno() + 1);
		        othello.actualizarMovimientosCorrectos(1, othello.posiblesNegras);
		        othello.actualizarMovimientosCorrectos(2, othello.posiblesBlancos);
		        fOthello.actualizarContador();				
				}
			
		} else {
			if (othello.movimientoCorrectoBlancas(segundaCoordenada, primeraCoordenada)) {
				
				othello.ejecutarMovimientoBlancas(segundaCoordenada, primeraCoordenada);
				actualizarTablero();
				setTurno(getTurno() + 1);
		        othello.actualizarMovimientosCorrectos(1, othello.posiblesNegras);
		        othello.actualizarMovimientosCorrectos(2, othello.posiblesBlancos);
		        fOthello.actualizarContador();
			}
			}

		}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
		      
	public void actualizarTablero() {
	    this.tMatriz = this.othello.getMatriz();
	    this.repaint();
	}
	
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}	
}
