package presentacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.Othello;
import logica.Ficha;

public class PTablero extends JPanel implements MouseListener {
	private Othello othello;
	
	public PTablero() {
		this.addMouseListener(this);
		this.repaint();
	}

	public void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(new Color(13, 149, 31));
	g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	
	g2d.setColor(Color.BLACK);
	g2d.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
	int x = this.getWidth()/2 - this.othello.getJugador1().getMano().size()*60;
	for(Ficha c : this.othello.getJugador1().getMano()) {
		Image image = Toolkit.getDefaultToolkit().getImage("img/" + c.getColor() + ".jpg");
		g2d.drawImage(image, x, this.getHeight()-180, this);
		x += 120;
	}
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}