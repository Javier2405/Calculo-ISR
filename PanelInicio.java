import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelInicio extends JPanel{
	
	private JButton btAceptar;
	private JRadioButton rbIndividual,
						 rbDocumento;
	private VentanaPrograma vp;
	private VentanaProgramaDoc vpd;
	private JLabel etiqueta;
	
	
	public PanelInicio() {
		super();
		this.setPreferredSize(new Dimension(600,200));
		
		this.btAceptar = new JButton("Aceptar");
		
		this.rbIndividual = new JRadioButton("Realizar el calculo para una sola persona");
		this.rbDocumento = new JRadioButton("Realizar el calculo para varias personas por medio de un documento .csv");
		this.rbIndividual.setSelected(true);
		this.etiqueta = new JLabel("Selecciona la opcion que desees");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.rbIndividual);
		bg.add(this.rbDocumento);
		
		this.btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbIndividual.isSelected()) {
					vp = new VentanaPrograma();
				}
				else if(rbDocumento.isSelected()) {
					vpd = new VentanaProgramaDoc();
					
				}	
			}

		});
		
		this.rbIndividual.setBounds(50,50,450,30);
		this.rbDocumento.setBounds(50,100,450,30);
		this.btAceptar.setBounds(250,150,100,30);
		this.etiqueta.setBounds(50,0,250,30);
		
		this.setLayout(null);
		
		this.add(this.rbDocumento);
		this.add(this.rbIndividual);
		this.add(this.btAceptar);
		this.add(this.etiqueta);
		
	}
}
