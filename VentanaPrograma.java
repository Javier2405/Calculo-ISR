import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class VentanaPrograma extends JFrame{
	
	public VentanaPrograma() {
		super();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

	    this.setLocation(
	            (pantalla.width-1050) / 2,
	            (pantalla.height-800) / 2);
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
			public void windowsDeactivated(WindowEvent e) {
					dispose();
			}
		});*/
	}
	
	public static void main(String[] args) {
		VentanaPrograma a=new VentanaPrograma();
	}
}
