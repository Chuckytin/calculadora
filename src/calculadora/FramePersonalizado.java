package calculadora;

import javax.swing.JFrame;

public class FramePersonalizado  extends JFrame {

	//constructor que recibe el ancho, alto, título y un flag que indica si es la ventana principal
	public FramePersonalizado(int ancho, int alto, String tituloVentana, boolean esVentanaPrincipal) {

		setSize(ancho, alto);
		setTitle(tituloVentana);
		setLocationRelativeTo(null); 
		
		//si la ventana es la principal la cierra al cerrar la ventana
		if (esVentanaPrincipal) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
