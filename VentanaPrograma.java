import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class VentanaPrograma extends JFrame{
	public VentanaPrograma() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		StatusBar sb=new StatusBar();
		PanelResultados pr=new PanelResultados();
		
		this.add(pr);
		CalculosISR Cal=new CalculosISR(pr,sb);
		
		this.add(sb,BorderLayout.SOUTH);
		
		this.add(new PanelCalculo(Cal,sb), BorderLayout.WEST);
		
		this.pack();
		this.setVisible(true);
		
		/*this.addWindowListener(new WindowAdapter() {
			public void windowDeactivated(WindowEvent e) {
					dispose();
			}
		});*/
	
	
	
	}
	public static void main(String[] args) {
		VentanaPrograma a=new VentanaPrograma();
	}
}
