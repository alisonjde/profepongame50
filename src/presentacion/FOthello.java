package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logica.Othello;

public class FOthello extends JFrame {
	
	
	private PTablero pTablero;
	private Othello othello;
	private JLabel fichas;

	
	public static void main(String[] args) {
		Othello othello = new Othello();
        FOthello fOthello = new FOthello(othello);
        fOthello.setVisible(true);
        fOthello.pTablero.actualizarTablero();      
    }
	
	
	public FOthello(Othello othello) {
		this.setTitle("Juego Othello :)");
		this.setSize(800,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.fichas = new JLabel("                                    Fichas Blancas: "+ othello.contadorBlancas() + "        Fichas Negras : "+ othello.contadorNegras());
		
		fichas.setFont(new Font("Arial", Font.PLAIN, 20));
		
		this.add(fichas, BorderLayout.SOUTH);
		
		JButton bIniciar = new JButton("Volver a iniciar");
		bIniciar.setFont(new Font("Arial", Font.BOLD, 20));
		bIniciar.setBackground(new Color(250, 200, 200));
		
		this.add(bIniciar, BorderLayout.NORTH);
		
		bIniciar.addActionListener(new ActionListener() {
		
							
		    @Override
		 public void actionPerformed(ActionEvent e) {
		   Othello othello2 = new Othello();
		   FOthello fOthello = new FOthello(othello2);
		   fOthello.setVisible(true);
		   fOthello.pTablero.actualizarTablero();
		   dispose();
		    }
		});

		
		this.othello = othello;
        this.pTablero = new PTablero(this.othello, this);
        this.pTablero.setVisible(true);
        this.add(this.pTablero, BorderLayout.CENTER);	
	}
	
	
	public void actualizarContador() {
	    
		fichas.setText("                                    Fichas Blancas: "+ othello.contadorBlancas() + "        Fichas Negras : "+ othello.contadorNegras());

	}

	

	

	
}