package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FOthello extends JFrame {
	private PTablero pTablero;
	
	public FOthello() {
		this.setTitle("Othello POO 2023");
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JButton bIniciar = new JButton("Iniciar");
		this.add(bIniciar, BorderLayout.NORTH);
		bIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.pTablero = new PTablero();
		this.add(this.pTablero, BorderLayout.CENTER);
		
	//	JOptionPane.showMessageDialog(this, "sfkjasfkjas");
	}

	public static void main(String[] args) {
		FOthello fOthello = new FOthello();
		fOthello.setVisible(true);
	}
	
}
