import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class VentanaProgramaDoc extends JFrame{
	public VentanaProgramaDoc() {
		super();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

	    this.setLocation(
	            (pantalla.width-600) / 2,
	            (pantalla.height-200) / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelDocumento pdoc=new PanelDocumento();
		this.add(pdoc);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowDeactivated(WindowEvent e) {
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		VentanaProgramaDoc a=new VentanaProgramaDoc();
	}
}
