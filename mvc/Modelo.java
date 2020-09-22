package mvc;

import java.io.*;

public class Modelo{

	private String campoText;
	private String nombreArch;
	final char su = (char) 3;
	final char sd = (char) 1;

	public void setContenido(String texto) {campoText = texto;}

	public String getContenido(){return campoText;}

	public void setFileName(String nombre) {nombreArch = nombre;}

	public String encriptar(){
		String ctext = "";
		for (String linea : campoText.split("\n")) {
			StringBuilder cadena = new StringBuilder();
			for (char w : linea.toCharArray()) {
				if (Character.isLetter(w))
					w += su;
				cadena.append(w);
			}
			
			StringBuilder shift_cadena = new StringBuilder();
			String shifttext = cadena.reverse().toString();
			int h = shifttext.length()/2;
			for (char c : shifttext.substring(h, shifttext.length()).toCharArray()) {
				if (Character.isLetter(c))
					c -= sd;
				shift_cadena.append(c);
			}
			ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + "\n";
		}
		campoText = ctext;
		return ctext;
	}

	public String desencriptar(){
	String texto = "";
	for ( String ctext : campoText.split ("\n")){
	int h = ctext.length()/2;
	StringBuilder shift_cadena = new StringBuilder(ctext.substring(0 ,h));
	for ( char ce : ctext.substring(h, ctext.length()).toCharArray()){
			if ( Character.isLetter(ce))
			ce += sd ;
			shift_cadena.append(ce);
			}
	
			String shifttext = shift_cadena.reverse().toString();
			StringBuilder cadena = new StringBuilder();
			for ( char x : shifttext.toCharArray()){
			if ( Character.isLetter(x -3))
			x -= su;
			cadena . append(x);
			}
			texto = texto + cadena . toString () + "\n";
			}
	
			campoText = texto;
			return texto;
			}

	public String read(){
		String cad;
		String contenido = "";
		File archivo = new File(nombreArch);
		try {
			if (archivo.exists()) {
				BufferedReader b = new BufferedReader(new FileReader(archivo));
				while ((cad = b.readLine()) != null)
					contenido = contenido + cad + "\n";
				b.close();
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println(" Error opening file .");
		} catch (IOException ioException) {
			System.err.println(" Error reading file .");
		}
		campoText = contenido;
		return contenido;
	}

	public void write(){
		try {
			File archivo = new File(nombreArch);
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));;
			bw.write(campoText);
			bw.close();
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println(" Error opening file .");
		} catch (IOException ioException) {
			System.err.println(" Error reading file .");
		}
	}

}
