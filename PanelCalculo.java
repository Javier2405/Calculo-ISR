import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PanelCalculo extends JPanel implements ActionListener{
	
	private CalculosISR Cal;
	
	private StatusBar sb;
	
	private JTextField nombre,
						RFC,
						SueldoM,
						Aguinaldo,
						PrimaV,
						DMyHosp,
						GastosFun,
						SGMM,
						Hipotecarios,
						Donativos,
						AportacionRet,
						TransporteE,
						ColegiaturaTot;
	
	private JRadioButton Preescolar,
							Primaria,
							Secundaria,
							ProfesionalTec,
							Bachillerato;
	private JButton Submit,
					Abrir,
					Guardar,
					Regresar,
					Limpiar;
	
	private String NivelE,
					currentLine;
	
	private JFileChooser fileChooser;
	
	private BufferedReader br;
	
	int returnVal;
	
	private File file;
	
	
	public PanelCalculo(CalculosISR Cal, StatusBar sb) {
		super();
		this.setPreferredSize(new Dimension(250,500));
		this.setBackground(Color.LIGHT_GRAY);
		
		this.Cal=Cal;
		this.sb=sb;
		
		this.nombre=new JTextField(15);
		this.RFC=new JTextField(15);
		this.SueldoM=new JTextField(7);
		this.Aguinaldo=new JTextField(5);
		this.PrimaV=new JTextField(6);
		this.DMyHosp=new JTextField(7);
		this.GastosFun=new JTextField(5);
		this.SGMM=new JTextField(13);
		this.Hipotecarios=new JTextField(9);
		this.Donativos=new JTextField(10);
		this.AportacionRet=new JTextField(6);
		this.TransporteE=new JTextField(5);
		this.ColegiaturaTot=new JTextField(5);
		
		
		this.Preescolar=new JRadioButton("Preescolar");
		this.Primaria=new JRadioButton("Primaria");
		this.Secundaria=new JRadioButton("Secundaria");
		this.ProfesionalTec=new JRadioButton("Profesional Tecnico");
		this.Bachillerato=new JRadioButton("Bachillerato o equivalente");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(this.Preescolar);
		bg.add(this.Primaria);
		bg.add(this.Secundaria);
		bg.add(this.ProfesionalTec);
		bg.add(this.Bachillerato);
		this.Primaria.setSelected(true);
		//JBUTTON
		this.Abrir=new JButton("ABRIR DOCUMENTO .CSV");
		this.Guardar=new JButton("GUARDAR");
		this.Submit=new JButton("CALCULAR ISR");
		this.Regresar=new JButton("Home");
		this.Limpiar=new JButton("Limpiar");
		
		//LABELS
		this.add(new JLabel("CALCULADORA ISR"));
		this.add(new JLabel("                  ------------------------------------------------------------                 "));
		this.add(new JLabel("                  LLENA LOS DATOS A CALCULAR                        "));
		this.add(new JLabel("NOMBRE: "));
		this.add(this.nombre);
		this.add(new JLabel("RFC: "));
		this.add(this.RFC);
		this.add(new JLabel("SUELDO MENSUAL  $"));
		this.add(this.SueldoM);
		this.add(new JLabel("AGUINALDO RECIBIDO  $"));
		this.add(this.Aguinaldo);
		this.add(new JLabel("PRIMA VACACIONAL $"));
		this.add(this.PrimaV);
		this.add(new JLabel("D MEDICOS Y HOSP $"));
		this.add(this.DMyHosp);
		this.add(new JLabel("D GASTOS FUNERARIOS $"));
		this.add(this.GastosFun);
		this.add(new JLabel("SGMM $"));
		this.add(this.SGMM);
		this.add(new JLabel("HIPOTECARIOS $"));
		this.add(this.Hipotecarios);
		this.add(new JLabel("DONATIVOS $"));
		this.add(this.Donativos);
		this.add(new JLabel("APORTACIÓN RETIRO $"));
		this.add(this.AportacionRet);
		this.add(new JLabel("TRANSPORTE ESCOLAR $"));
		this.add(this.TransporteE);
		this.add(new JLabel("NIVEL EDUCATIVO:                      "));
		this.add(this.Primaria);
		this.add(this.Secundaria);
		this.add(this.ProfesionalTec);
		this.add(this.Bachillerato);
		this.add(new JLabel("    "));
		this.add(new JLabel("COLEGIATURA TOTAL $"));
		this.add(this.ColegiaturaTot);
		this.add(this.Submit);
		this.add(this.Limpiar);
		this.add(new JLabel("                  ------------------------------------------------------------                 "));
		this.add(new JLabel("                    ARCHIVOS                             "));
		this.add(this.Abrir);
		this.add(this.Guardar);
		this.Primaria.setSelected(true);
		this.Submit.addActionListener(this);
		this.Abrir.addActionListener(this);
		this.Guardar.addActionListener(this);
		this.add(this.Regresar);
		this.Regresar.addActionListener(this);
		this.Limpiar.addActionListener(this);
		this.nombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RFC.isFocusable();
				
			}
			
		});
		
		fileChooser=new JFileChooser();
	}
	
	public void actionPerformed(ActionEvent e){
		try {
			if(e.getSource()==this.Submit) {
				this.previoCal();
			}else if(e.getSource()==this.Abrir) {
				System.out.println("abrir");
				this.abrirDatos();
				
			}else if(e.getSource() == this.Regresar) {
				JFrame frame = (JFrame)SwingUtilities.getRoot(this);
				frame.dispose();
				VentanaInicio vi = new VentanaInicio();
			}else if(e.getSource()==this.Limpiar) {
				this.Limpia();
			}
			else {
				this.saveFile();
			}
		}
		catch(NumberFormatException es){
			JOptionPane.showMessageDialog(this,"Recuerda rellenar todos los campos, de manera correcta");
			this.sb.setMessage("Recuarda no incluir letras en campos de gastos");
		}catch(IndexOutOfBoundsException error){
			JOptionPane.showMessageDialog(this,"Aqui esta el error");
		}catch(Exception es) {
			JOptionPane.showMessageDialog(this,"Rellena todos los campos, error");
		}
		
		
	}

	private void previoCal() {
		if(this.Primaria.isSelected()) {
			this.NivelE="Primaria";
		}else if(this.Preescolar.isSelected()) {
			this.NivelE="Preescolar";
		}else if(this.Secundaria.isSelected()) {
			this.NivelE="Secundaria";
		}else if(this.Bachillerato.isSelected()){
			this.NivelE="Bachillerato";
		}else {
			this.NivelE="Profesional";
		}
		
		if(this.nombre.getText().equals("")){
			this.nombre.setText("No name");
		}
		
		if(this.RFC.getText().equals("")){
			this.RFC.setText("No RFC dado");
		}
		if(this.SueldoM.getText().equals("")){
			this.SueldoM.setText("0");
		}
		if(this.Aguinaldo.getText().equals("")){
			this.Aguinaldo.setText("0");
		}
		if(this.PrimaV.getText().equals("")){
			this.PrimaV.setText("0");
		}
		if(this.DMyHosp.getText().equals("")){
			this.DMyHosp.setText("0");
		}
		if(this.GastosFun.getText().equals("")){
			this.GastosFun.setText("0");
		}
		if(this.SGMM.getText().equals("")){
			this.SGMM.setText("0");
		}
		if(this.Hipotecarios.getText().equals("")){
			this.Hipotecarios.setText("0");
		}
		if(this.Donativos.getText().equals("")){
			this.Donativos.setText("0");
		}
		if(this.AportacionRet.getText().equals("")){
			this.AportacionRet.setText("0");
		}
		if(this.TransporteE.getText().equals("")){
			this.TransporteE.setText("0");
		}
		if(this.ColegiaturaTot.getText().equals("")){
			this.ColegiaturaTot.setText("0");
		}
		Cal.Actualizar(this.nombre.getText(),this.RFC.getText(),Integer.parseInt(this.SueldoM.getText()), Integer.parseInt(this.Aguinaldo.getText()),Integer.parseInt(this.PrimaV.getText()),Integer.parseInt(this.DMyHosp.getText()),Integer.parseInt(this.GastosFun.getText()),Integer.parseInt(this.SGMM.getText()),Integer.parseInt(this.Hipotecarios.getText()),Integer.parseInt(this.Donativos.getText()),Integer.parseInt(this.AportacionRet.getText()),Integer.parseInt(this.TransporteE.getText()),this.NivelE,Integer.parseInt(this.ColegiaturaTot.getText()));
		
	}


	private void Limpia() {
		this.nombre.setText("");
		this.RFC.setText("");
		this.SueldoM.setText("");
		this.Aguinaldo.setText("");
		this.PrimaV.setText("");
		this.DMyHosp.setText("");
		this.GastosFun.setText("");
		this.SGMM.setText("");
		this.Hipotecarios.setText("");
		this.Donativos.setText("");
		this.AportacionRet.setText("");
		this.TransporteE.setText("");
		this.ColegiaturaTot.setText("");
		
	}
	
	private void saveFile() {
		Cal.saveData();
		this.sb.setMessage("Guardado exitosamente");
		
	}

	private void abrirDatos() {
		returnVal=fileChooser.showOpenDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			file=fileChooser.getSelectedFile();
			StringTokenizer st;
			try{
				br=new BufferedReader(new FileReader(file));
				br.readLine();
				currentLine=br.readLine();
				st=new StringTokenizer(currentLine);
				
				String name=st.nextToken(",");//
				
				String rfc=st.nextToken(",");//
				
				Double sueldo=(Double.parseDouble(st.nextToken(",")));
				
				Double Aguinaldo=(Double.parseDouble(st.nextToken(",")));
				
				Double Primav=(Double.parseDouble(st.nextToken(",")));

				Double MyH=(Double.parseDouble(st.nextToken(",")));

				Double GF=(Double.parseDouble(st.nextToken(",")));

				Double SGMM=(Double.parseDouble(st.nextToken(",")));

				Double Hip=(Double.parseDouble(st.nextToken(",")));

				Double Donat=(Double.parseDouble(st.nextToken(",")));

				Double SubR=(Double.parseDouble(st.nextToken(",")));

				Double Transp=(Double.parseDouble(st.nextToken(",")));
				
				String NivelE=st.nextToken(",");
				
				Double Colegiatura=(Double.parseDouble(st.nextToken(",")));
				
				Cal.abrir(name, rfc, sueldo, Aguinaldo, Primav, MyH, GF,
						SGMM, Hip, Donat, SubR, Transp, NivelE, Colegiatura);
				this.sb.setMessage("Cargado Exitosamente perfil de "+name);
			}catch(IOException error) {
				JOptionPane.showMessageDialog(this,"No se pudo leer el archivo");
			}catch(IndexOutOfBoundsException error){
				JOptionPane.showMessageDialog(this,"Aqui esta el error");
			}
		}
		
	}
}
