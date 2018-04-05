
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class VentanaInicio extends JFrame {
	public VentanaInicio() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelInicio pi=new PanelInicio();
		this.add(pi);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowDeactivated(WindowEvent e) {
				dispose();
			}
		});
	
	
	}
	public static void main(String[] args) {
		VentanaInicio a=new VentanaInicio();
	}

}

