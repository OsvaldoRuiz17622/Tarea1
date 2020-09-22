package mvc;

import java.awt.event.*;
import javax.swing.*;

public class Controlador implements ActionListener{

	private Modelo modelo;
	private Vista vista;

	public Controlador(Modelo m,Vista v){
	modelo = m;
	vista = v;
	vista.setControlador(this); // Conectamos la vista con el controlador
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case InterfazVista.ABRIR:
			modelo.setFileName(vista.getFileName());
			vista.setText(modelo.read());
			break;
		case InterfazVista.ENCRYPT:
			modelo.setContenido(vista.getText());
			vista.setText(modelo.encriptar());
			break;
		case InterfazVista.DECRYPT:
			modelo.setContenido(vista.getText());
			vista.setText(modelo.desencriptar());
			break;
		case InterfazVista.GUARDAR:
			modelo.setFileName(vista.getFileName());
			modelo.setContenido(vista.getText());
			modelo.write();
			break;
		default:
			System.err.println(" Comando no definido ");
			break;
		}
	}

	public void arrancar(){ // Comienza la visualizacion
		vista.setLocationRelativeTo(null); // centra la ventana en lapantalla
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setSize(650,300);
		vista.setVisible(true);
	}
}
