package mvc;
import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame implements InterfazVista{

	private final JTextArea text; 
	private final JButton encryptJButton;
	private final JButton decryptJButton;
	private final JButton saveJButton;
	private final JButton openJButton;
	private final JTextField fileName; 
	
	public Vista(){
	super ("Prueba de Cifrado");
	JPanel fileJPanel ;
	JLabel lblFile ;
	JPanel buttonJPanel ;
	BorderLayout layout ;
	
	layout = new BorderLayout(40, 20) ;
	setLayout(layout );
	fileJPanel = new JPanel() ;
	fileJPanel.setLayout(new FlowLayout () ) ;
	lblFile = new JLabel(" Archivo de texto/cifrado: ");
	lblFile.setToolTipText("Archivo a abrir");
	fileJPanel.add(lblFile);
	fileName = new JTextField(40) ;
	fileJPanel.add(fileName);
	add(fileJPanel, BorderLayout.NORTH);
	text = new JTextArea(10,15);
	add (new JScrollPane(text), BorderLayout.CENTER);
	buttonJPanel = new JPanel();
	buttonJPanel.setLayout(new GridLayout(5, 2));
	openJButton = new JButton( ABRIR ) ;
	buttonJPanel.add(openJButton);
	encryptJButton = new JButton(ENCRYPT);
	buttonJPanel.add(encryptJButton) ;
	decryptJButton = new JButton(DECRYPT);
	buttonJPanel.add( decryptJButton );
	saveJButton = new JButton (GUARDAR);
	buttonJPanel.add(saveJButton);
	add(buttonJPanel,BorderLayout.EAST);
	}
	
	public String getFileName(){return fileName.getText();}
	public String getText(){return text.getText();}
	public void setText(String s){text.setText(s);}
	public void setControlador(Controlador c){
	openJButton.addActionListener(c);
	saveJButton.addActionListener(c);
	encryptJButton.addActionListener(c);
	decryptJButton.addActionListener(c);
	}


}
