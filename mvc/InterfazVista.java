package mvc;

public interface InterfazVista {
	void setControlador(Controlador c); // Conecta la interfaz con el controlador

	public String getFileName () ; // Obtener el nombre del archivo

	public String getText(); // Obtener el texto

	public void setText(String s); // Establecer el texto
	// Constantes que definen las posibles operaciones :

	static final String ABRIR = "Abrir";
	static final String ENCRYPT = "Encriptar";
	static final String DECRYPT = "Desencriptar";
	static final String GUARDAR = "Guardar";
}