import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelCalculo extends JPanel implements ActionListener{
	private CalculosISR Cal;
	private StatusBar sb;
	private JTextField nombre;
	private JTextField RFC;
	private JTextField SueldoM;
	private JTextField Aguinaldo;
	private JTextField PrimaV;
	private JTextField DMyHosp;
	private JTextField GastosFun;
	private JTextField SGMM;
	private JTextField Hipotecarios;
	private JTextField Donativos;
	private JTextField AportacionRet;
	private JTextField TransporteE;
	private JRadioButton Preescolar;
	private JRadioButton Primaria;
	private JRadioButton Secundaria;
	private JRadioButton ProfesionalTec;
	private JRadioButton Bachillerato;
	private JTextField ColegiaturaTot;
	private JButton Submit;
	private JButton Abrir;
	private JButton Guardar;
	private JButton Regresar;
	private String NivelE;
	private JButton Limpiar;
	

	private JFileChooser fileChooser;
	private BufferedReader br;
	int returnVal;
	private File file;
	String currentLine;
	
	
	
	
	public PanelCalculo(CalculosISR Cal, StatusBar sb) {
		super();
		this.Cal=Cal;
		this.sb=sb;
		this.setPreferredSize(new Dimension(250,500));
		this.setBackground(Color.LIGHT_GRAY);
		this.NivelE="Primaria";
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
		this.ColegiaturaTot=new JTextField(5);
		this.Abrir=new JButton("VIZUALIZAR RESULTADOS");
		this.Guardar=new JButton("GUARDAR");
		this.Submit=new JButton("CALCULAR ISR");
		this.Regresar=new JButton("Home");
		this.Limpiar=new JButton("Limpiar");
		
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
		
		fileChooser=new JFileChooser();
	}
	
	 

	
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		
		
		try {
			if(e.getSource()==this.Submit) {
				this.previoCal();
			}else if(e.getSource()==this.Abrir) {
				System.out.println("abrir");
				this.abrirDatos();
				
				
			}else if(e.getSource() == this.Regresar) {
				VentanaInicio vi = new VentanaInicio();

			}else {
				this.saveFile();
			}
		}
		catch(NumberFormatException es){
			JOptionPane.showMessageDialog(this,"Recuerda rellenar todos los campos, de manera correcta");
			this.sb.setMessage("Recuarda no incluir letras en campos de gastos");
		}catch(Exception es) {
			JOptionPane.showMessageDialog(this,"Rellena todos los campos, error");
		}
		
		
	}


	private void previoCal() {
		if(this.Primaria.isSelected()) {
			this.NivelE="Primaria";
		}else if(this.Secundaria.isSelected()) {
			this.NivelE="Secundaria";
		}else {
			this.NivelE="Preparatoria";
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
				int sueldoM= sueldo.intValue();//
				
				Double ingreso=(Double.parseDouble(st.nextToken(",")));
				int ingresoA=ingreso.intValue();//
				
				Double Aguinaldo=(Double.parseDouble(st.nextToken(",")));
				int aguinaldo=Aguinaldo.intValue();
				
				Double AguinaldoE=(Double.parseDouble(st.nextToken(",")));
				int aguinaldoE=AguinaldoE.intValue();
				
				Double AguinaldoG=(Double.parseDouble(st.nextToken(",")));
				int aguinaldoG=AguinaldoG.intValue();
				
				Double Primav=(Double.parseDouble(st.nextToken(",")));
				int PrimaV=Primav.intValue();
				
				Double PrimavE=(Double.parseDouble(st.nextToken(",")));
				int PrimaVE=PrimavE.intValue();
				
				Double PrimavG=(Double.parseDouble(st.nextToken(",")));
				int PrimaVG=PrimavG.intValue();
				
				Double TotalIG=(Double.parseDouble(st.nextToken(",")));
				int totalIG=TotalIG.intValue();
				
				Double MyH=(Double.parseDouble(st.nextToken(",")));
				int myh=MyH.intValue();
				
				Double GF=(Double.parseDouble(st.nextToken(",")));
				int Funerarios=GF.intValue();
				
				Double SGMM=(Double.parseDouble(st.nextToken(",")));
				int sgmm=SGMM.intValue();
				
				Double Hip=(Double.parseDouble(st.nextToken(",")));
				int hipotecarios=Hip.intValue();
				
				Double Donat=(Double.parseDouble(st.nextToken(",")));
				int Donativos=Donat.intValue();
				
				Double SubR=(Double.parseDouble(st.nextToken(",")));
				int subR=SubR.intValue();
				
				Double Transp=(Double.parseDouble(st.nextToken(",")));
				int transpE=Transp.intValue();
				
				String NivelE=st.nextToken(",");
				
				Double MaxDedColeg=(Double.parseDouble(st.nextToken(",")));
				int maxdedcoleg=MaxDedColeg.intValue();
				
				Double Colegiatura=(Double.parseDouble(st.nextToken(",")));
				int ColegiaturaP=Colegiatura.intValue();
				
				Double Totald=(Double.parseDouble(st.nextToken(",")));
				int totalD=Totald.intValue();
				
				Double DeducP=(Double.parseDouble(st.nextToken(",")));
				int deducP=DeducP.intValue();
				
				Double MontoISR=(Double.parseDouble(st.nextToken(",")));
				int montoISR=MontoISR.intValue();
				
				Double CuotaF=(Double.parseDouble(st.nextToken(",")));
				int CuotaFija=CuotaF.intValue();
				
				Double PorcE=(Double.parseDouble(st.nextToken(",")));
				int PorcentE=PorcE.intValue();
				
				Double pagoE=(Double.parseDouble(st.nextToken(",")));
				int PagoE=pagoE.intValue();
				
				Double TotalP=(Double.parseDouble(st.nextToken(",")));
				int TotalPa=TotalP.intValue();
				
				Cal.abrir(name, rfc, sueldoM, ingresoA, aguinaldo, aguinaldoE, aguinaldoG, PrimaV, PrimaVE, PrimaVG, totalIG, myh, Funerarios, sgmm, hipotecarios, Donativos, subR, transpE, NivelE, maxdedcoleg, ColegiaturaP, totalD, deducP, montoISR, CuotaFija, PorcentE, PagoE, TotalPa);
				this.sb.setMessage("Cargado Exitosamente perfil de "+name);
			}catch(Exception error) {
				JOptionPane.showMessageDialog(this,"Archivo no valido");
			}
		}
		
	}
}
