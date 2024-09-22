package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funcionalidad implements ActionListener {

	private String valorBoton; //almacena el valor del botón presionado
	private static double numeroViejo = 0; //acumulador de las operaciones
	private static double numeroNuevo; //numero actual introducido
	private static boolean borrar = true; //indica si debe borrarse la pantalla
	private static boolean primerNumero = true; //indica si es el primer número en la operación
	private static String ultimoSimbolo = ""; //última operación realizada (+, -, *, /)

	public Funcionalidad (String valorBoton) {

		this.valorBoton = valorBoton;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			Double.parseDouble(valorBoton); //verifica que el botón presionado sea un número

			addNumeroPantalla(); //añade el número a la pantalla

		} catch (Exception ex) {

			if (valorBoton.equals(".")) {
				
				addNumeroPantalla(); //manejo del punto decimal
				
			} else {
				
				calcularOperacion(); //ejecuta una operación
				
			}

		}

	}

	private void addNumeroPantalla() {

		String numeroPantalla = Interfaz.getTextoPantalla();
		
		if (valorBoton.equals(".") && numeroPantalla.contains(".")) {
			
            return; //no permite múltiples puntos decimales
            
        }

		if (numeroPantalla.equals("0") || borrar) {

			numeroPantalla = ""; //limpia la pantalla si es necesario
			borrar = false;

		}

		numeroPantalla += valorBoton;

		Interfaz.setTextoPantalla(numeroPantalla);

	}

	private void calcularOperacion() {

		switch(valorBoton) {

		case "+": sumar(); break;

		case "-": restar(); break;

		case "*": multiplicar(); break;

		case "/": dividir(); break;
		
		case "=": realizarOperacion(); break;

		}

	}
	
	private void realizarOperacion() {
		
		if (ultimoSimbolo.equals("+")) sumar();
		if (ultimoSimbolo.equals("-")) restar();
		if (ultimoSimbolo.equals("*")) multiplicar();
		if (ultimoSimbolo.equals("/")) dividir();
		
		Interfaz.setTextoPantalla(String.valueOf(numeroViejo)); //muestra el resultado
		borrar = true; 
		numeroViejo = 0; 
		primerNumero = true;
		
	}

	private void sumar() {

		numeroNuevo = Double.parseDouble(Interfaz.getTextoPantalla());
		numeroViejo += numeroNuevo;
		ultimoSimbolo = "+";
		borrar = true;

	}

	private void restar() {

		numeroNuevo = Double.parseDouble(Interfaz.getTextoPantalla());

		if (primerNumero) {

			numeroViejo = numeroNuevo;
			primerNumero = false;

		} else {

			numeroViejo -= numeroNuevo;

		}

		ultimoSimbolo = "-";
		borrar = true;

	}

	private void multiplicar() {

		numeroNuevo = Double.parseDouble(Interfaz.getTextoPantalla());

		if (primerNumero) {

			numeroViejo = numeroNuevo;
			primerNumero = false;

		} else {

			numeroViejo *= numeroNuevo;

		}

		ultimoSimbolo = "*";
		borrar = true;

	}
	
	private void dividir() {
		
		numeroNuevo = Double.parseDouble(Interfaz.getTextoPantalla());

		if (primerNumero) {

			numeroViejo = numeroNuevo;
			primerNumero = false;

		} else {

			if (numeroNuevo == 0) {
				
				Interfaz.setTextoPantalla("Error");
				borrar = true;
				primerNumero = true; //restablece la calculadora
				numeroViejo = 0; //resetea el acumulador
				ultimoSimbolo = ""; //limpia el último símbolo
				return; //sale del método para no realizar la divisón
				
			} else {
				
				numeroViejo /= numeroNuevo;
				
			}

		}

		ultimoSimbolo = "/";
		borrar = true;
			
	}

}
