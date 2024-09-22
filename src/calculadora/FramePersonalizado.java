package calculadora;

import javax.swing.JFrame;

public class FramePersonalizado  extends JFrame {

	public FramePersonalizado(int ancho, int alto, String tituloVentana, boolean esVentanaPrincipal) {

		setSize(ancho, alto);
		setTitle(tituloVentana);
		setLocationRelativeTo(null); 
		
		if (esVentanaPrincipal) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
