package mvc;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class mvcp {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bienvenido");
		
		Modelo m = new Modelo () ;
		Vista v = new Vista () ;
		Controlador c = new Controlador (m, v) ;
		c. arrancar () ; // Arranca la interfaz vista
		
		
		
		
}
}