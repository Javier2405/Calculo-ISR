import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	
	public PanelInicio() {
		super();
		this.setPreferredSize(new Dimension(500,300));
		
		this.btAceptar = new JButton("Aceptar");
		
		this.rbIndividual = new JRadioButton("Realizar el calculo para una sola persona");
		this.rbDocumento = new JRadioButton("Realizar el calculo para varias personas por medio de un documento .csv");
		this.rbIndividual.setSelected(true);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.rbIndividual);
		bg.add(this.rbDocumento);
		
		this.btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbIndividual.isSelected()) {
					vp = new VentanaPrograma();
				}
				else if(rbDocumento.isSelected()) {
					System.out.println("ya no hay nada");
					
				}	
			}

		});
		
		this.add(new JLabel("Seleccione la opcion que desee"));
		this.add(this.rbIndividual);
		this.add(this.rbDocumento);
		this.add(this.btAceptar);
		
		
	}
}
