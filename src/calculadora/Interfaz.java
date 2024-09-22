package calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz {

	private FramePersonalizado marco; //ventana principal
	private JPanel panel; //panel que contiene la pantalla y botones
	private static JTextField pantalla;  //pantalla donde se muestran los resultados
	private JPanel panelBotones; //panel donde se colocan los botones

	//constructor que inicializa la ventana y la interfaz de usuario
	public Interfaz () {

		marco = new FramePersonalizado(300, 400, "Calculadora", true); //crea la ventana personalizada
		panel = new JPanel(new BorderLayout()); //crea el panel con layout de bordes
		crearPantalla();
		crearBotones();

		marco.add(panel);
		marco.setVisible(true);

	}

	private void crearPantalla() {

		pantalla = new JTextField("0"); //inicializa con 0
		pantalla.setEditable(false); //No permite escribir en la pantalla
		pantalla.setFont(new Font("Arial", Font.BOLD, 35)); //fuente de la pantalla

		panel.add(pantalla, BorderLayout.NORTH); //añade la pantala al panel en la parte superior

	}

	private void crearBotones() {

		panelBotones = new JPanel(new GridLayout(4, 4, 1, 1)); //4 filas, 4 columnas, 1px de separación horizontal, 1px de separacion vertical

		crearBoton("7", "8", "9", "-",
				"4", "5", "6", "+",
				"1", "2", "3", "*",
				".", "0", "/", "=");

		panel.add(panelBotones, BorderLayout.CENTER); //añade los botones al panel central

	}

	private void crearBoton(String... nombre) {

		for (String nom : nombre) {

			JButton boton = new JButton(nom); //crea un botón con el texto correspondiente

			boton.addActionListener(new Funcionalidad(boton.getText())); //da funcionalidad al botón

			boton.setFont(new Font("Arial", Font.BOLD, 20));
			panelBotones.add(boton);

		}

	}

	//obtiene el texto alcual de la pantalla
	public static String getTextoPantalla() {

		return pantalla.getText();

	}

	//edita el texto de la pantalla
	public static void setTextoPantalla(String cantidad) {

		pantalla.setText(cantidad);

	}

}
