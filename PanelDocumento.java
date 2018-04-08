import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelDocumento extends JPanel{
	private JButton btAbrirDoc,
					btHome;
	private JTextField tfNombreDoc;
	private String NombreDoc;
	private JLabel etiqueta0,
					etiqueta1;
	
	
	public PanelDocumento() {
		super();
		this.setPreferredSize(new Dimension(600,200));
		
		this.btAbrirDoc = new JButton("ABRIR DOCUMENTO .CSV");
		
		this.tfNombreDoc = new JTextField(10);
		
		this.etiqueta0 = new JLabel("Ingresa los datos que deseas analizar en un documento .csv");
		this.etiqueta1 = new JLabel("Nombre del documento a guardar:");
		
		this.btAbrirDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNombreDoc == null) {
					NombreDoc = "ResultadosISR";
				}else {
					NombreDoc = tfNombreDoc.getText();
				}
				StatusBar sb=new StatusBar();
				PanelResultados pr=new PanelResultados();
				CalculosISR Cal=new CalculosISR(pr,sb);
				Cal.EntradaySalida(NombreDoc);
			}

		});
		
		this.btAbrirDoc.setBounds(50,100,200,50);
		this.etiqueta0.setBounds(50,0,400,30);
		this.etiqueta1.setBounds(10,50,250,20);
		this.tfNombreDoc.setBounds(250,50,200,20);
		
		this.setLayout(null);
		
		this.add(this.btAbrirDoc);
		this.add(this.etiqueta0);
		this.add(this.etiqueta1);
		this.add(this.tfNombreDoc);
		
		
		
		
		
		
		
	}
}
