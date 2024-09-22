package calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz {

	private FramePersonalizado marco;
	private JPanel panel;
	private JTextField pantalla;
	private JPanel panelBotones;
	
	public Interfaz () {
		
		marco = new FramePersonalizado(300, 400, "Calculadora", true);
		panel = new JPanel(new BorderLayout());
		crearPantalla();
		crearBotones();
		
		marco.add(panel);
		marco.setVisible(true);
		
	}

	private void crearPantalla() {
		
		pantalla = new JTextField("0"); //Al inicio la pantalla tendrá un 0
		pantalla.setEditable(false); //No está habilitada la pantalla para escribir en ella
		pantalla.setFont(new Font("Arial", Font.BOLD, 35)); //Establece la tipografía
		
		panel.add(pantalla, BorderLayout.NORTH); //se agrega al panel el textfiel de la pantalla y su localización
		
	}
	
	private void crearBotones() {
		
		panelBotones = new JPanel(new GridLayout(4, 4, 1, 1)); //4 filas, 4 columnas, 1px de separación horizontal, 1px de separacion vertical
		
		crearBoton("7", "8", "9", "-",
				"4", "5", "6", "+",
				"1", "2", "3", "*",
				".", "0", "/", "=");
		
		panel.add(panelBotones, BorderLayout.CENTER);
		
	}
	
	private void crearBoton(String... nombre) {
		
		for (String nom : nombre) {
			
			JButton boton = new JButton(nom);
			
			boton.setFont(new Font("Arial", Font.BOLD, 20));
			panelBotones.add(boton);
			
		}
		
	}
	
}
