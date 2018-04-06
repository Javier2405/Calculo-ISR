import java.io.File;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CalculosISR {                      // => Quedan Igual
	private PanelResultados pr;
	
	private String nombre;//
	private String RFC;//
	private int SueldoM;//
	private int IngresoA;
	private int Aguinaldo;//
	private int AguinaldoE;
	private int AguinaldoG;
	private int PrimaV;//
	private int PrimaVE;
	private int PrimaVG;
	private int TotalIngresosG;
	private int MyH;//
	private int GatsosFun;//
	private int SGMM;//
	private int Hipotecarios;//
	private int Donativos;//
	private int SubRetiro;//
	private int TransporteE;//
	private String NivelE;//
	private int MaxDedColeg;
	private int Colegiatura;//
	private int TotalDedNoRetiro;
	private int DedPerm;
	private int MontoISR;
	private int CuotaFija;
	private int PorcExced;
	private int PagoEx;
	private int Total;
	private StatusBar sb;
	
	private JFileChooser fileChooser;
	private BufferedReader br;
	int returnVal;
	private File file;
	String currentLine;
	
	
	
	public CalculosISR(PanelResultados pr, StatusBar sb) {
		this.pr=pr;
		this.sb=sb;
		this.nombre="No Name";
		this.RFC="No RFC";
		this.SueldoM=0;
		this.IngresoA=0;
		this.Aguinaldo=0;
		this.AguinaldoE=0;
		this.AguinaldoG=0;
		this.PrimaV=0;
		this.PrimaVE=0;
		this.PrimaVG=0;
		this.TotalIngresosG=0;
		this.MyH=0;
		this.GatsosFun=0;
		this.SGMM=0;
		this.Hipotecarios=0;
		this.Donativos=0;
		this.SubRetiro=0;
		this.TransporteE=0;
		this.NivelE="Primaria";
		this.MaxDedColeg=0;
		this.Colegiatura=0;
		this.TotalDedNoRetiro=0;
		this.DedPerm=0;
		this.MontoISR=0;
		this.CuotaFija=0;
		this.PorcExced=0;
		this.PagoEx=0;
		this.Total=0;
		fileChooser=new JFileChooser();
		
	}
	public void Actualizar(String name, String rfc, int sueldoM, int Aguinaldo, int PrimaV, int DMyH,
			int GastosFun, int SGMM, int Hipotecarios, int Donativos, int AportacionRet, int Transporte, String NivelE,
			int Colegiatura) {
		this.nombre=name;//
		this.RFC=rfc;//
		this.SueldoM=sueldoM;//
		this.IngresoA=this.SueldoM*12;//DONE
		this.Aguinaldo=Aguinaldo;//
		this.PrimaV=PrimaV;//
		this.MyH=DMyH;//
		this.GatsosFun=GastosFun;//
		this.SGMM=SGMM;//
		this.Hipotecarios=Hipotecarios;//
		this.Donativos=Donativos;//
		this.SubRetiro=AportacionRet;//
		this.TransporteE=Transporte;//
		this.NivelE=NivelE;//
		this.Colegiatura=Colegiatura;//
		
		
		
		this.AguinaldoE=0;//Calcular desde aqui =>
		this.AguinaldoG=0;
		this.PrimaVE=0;
		this.PrimaVG=0;
		this.TotalIngresosG=0;
		this.MaxDedColeg=0;
		this.TotalDedNoRetiro=0;
		this.DedPerm=0;
		this.MontoISR=0;
		this.CuotaFija=0;
		this.PorcExced=0;
		this.PagoEx=0;
		this.Total=0;// Hata aqui <=
		
		
		pr.Imprimir(this.nombre, this.RFC, this.SueldoM,this.IngresoA,this.Aguinaldo,this.PrimaV,this.MyH,this.GatsosFun,this.SGMM,this.Hipotecarios,this.Donativos,this.SubRetiro,this.TransporteE,this.NivelE,this.Colegiatura,this.AguinaldoE,this.AguinaldoG,this.PrimaVE,this.PrimaVG,this.TotalIngresosG,this.MaxDedColeg,this.TotalDedNoRetiro,this.DedPerm,this.MontoISR,this.CuotaFija,this.PorcExced,this.PagoEx,this.Total);
		
		
	}
	public void abrir(String name, String rfc, int sueldoM, int IngresoA, int Aguinaldo, int AguinaldoE,// Ya esta hecho es el vizualizador
			int AguInaldoG, int PrimaV, int PrimaVE, int PrimaVG, int totalIngresosG, int MyH, int Funerarios,
			int SGMM, int Hipotecarios, int Donativos, int AportacionRet, int Transporte, String NivelE,
			int MaxDedColeg, int Colegiatura, int TotalDedNoRetiro, int DedPerm, int MontoISR, int Cuotafija,
			int PorcentE, int PagoEx, int Total) {
		this.nombre=name;//
		this.RFC=rfc;//
		this.SueldoM=sueldoM;//
		this.IngresoA=this.SueldoM*12;//DONE
		this.Aguinaldo=Aguinaldo;//
		this.PrimaV=PrimaV;//
		this.MyH=MyH;//
		this.GatsosFun=Funerarios;//
		this.SGMM=SGMM;//
		this.Hipotecarios=Hipotecarios;//
		this.Donativos=Donativos;//
		this.SubRetiro=AportacionRet;//
		this.TransporteE=Transporte;//
		this.NivelE=NivelE;//
		this.Colegiatura=Colegiatura;//
		
		
		
		this.AguinaldoE=AguinaldoE;
		this.AguinaldoG=AguInaldoG;
		this.PrimaVE=PrimaVE;
		this.PrimaVG=PrimaVG;
		this.TotalIngresosG=totalIngresosG;
		this.MaxDedColeg=MaxDedColeg;
		this.TotalDedNoRetiro=TotalDedNoRetiro;
		this.DedPerm=DedPerm;
		this.MontoISR=MontoISR;
		this.CuotaFija=Cuotafija;
		this.PorcExced=PorcentE;
		this.PagoEx=PagoEx;
		this.Total=Total;
		
		
		pr.Imprimir(this.nombre, this.RFC, this.SueldoM,this.IngresoA,this.Aguinaldo,this.PrimaV,this.MyH,this.GatsosFun,this.SGMM,this.Hipotecarios,this.Donativos,this.SubRetiro,this.TransporteE,this.NivelE,this.Colegiatura,this.AguinaldoE,this.AguinaldoG,this.PrimaVE,this.PrimaVG,this.TotalIngresosG,this.MaxDedColeg,this.TotalDedNoRetiro,this.DedPerm,this.MontoISR,this.CuotaFija,this.PorcExced,this.PagoEx,this.Total);
		
		
		
	}
	public void saveData() {
		System.out.println("data save");
		
		
			
		
		
		try {
			JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        PrintWriter pw=new PrintWriter(f.getSelectedFile()+"\\Resultados_de_"+this.nombre+".csv");
		        System.out.println(f.getCurrentDirectory());
		        System.out.println(f.getSelectedFile());
		        pw.println("Nombre,RFC,Sueldo mensual,Ingreso anual,Aguinaldo,Aguinaldo exento,Aguinaldo gravado,Prima vacacional,Prima vacacional excenta,Prima vacacional gravada,Total ingresos gravan,Medicos y hospitales,Gastos funerarios,SGMM,Hipotecarios,Donativos,Subcuenta retiro,Transporte escolar,Nivel educativo,Maximo a deducir colegiatura,Colegiatura pagada,Total deducciones (sin retiro),Deduccion permitida 10%,Monto ISR,Cuota fija,Porcentaje excedente,Pago excedente,Total a pagar");
		        pw.println(this.nombre+","+this.RFC+","+this.SueldoM+","+this.IngresoA+","+this.Aguinaldo+","+this.AguinaldoE+","+this.AguinaldoG+","+this.PrimaV+","+this.PrimaVE+","+this.PrimaVG+","+this.TotalIngresosG+","+this.MyH+","+this.GatsosFun+","+this.SGMM+","+this.Hipotecarios+","+this.Donativos+","+this.SubRetiro+","+this.TransporteE+","+this.NivelE+","+this.MaxDedColeg+","+this.Colegiatura+","+this.TotalDedNoRetiro+","+this.DedPerm+","+this.MontoISR+","+this.CuotaFija+","+this.PorcExced+","+this.PagoEx+","+this.Total);

		        pw.close();
			
			 
			
		
		}catch(Exception e) {
			System.out.println("error");
		}
		
		
	}
	
	public void calculo(String name, String rfc2, int sueldoM2, int aguinaldo2, int primaV2, int myh2, int funerarios,
			int sgmm2, int hipotecarios2, int donativos2, int subR, int transpE, String nivelE2, int colegiaturaP) {
		this.nombre=name;//
		this.RFC=rfc2;//
		this.SueldoM=sueldoM2;//
		this.IngresoA=this.SueldoM*12;//DONE
		this.Aguinaldo=aguinaldo2;//
		this.PrimaV=primaV2;//
		this.MyH=myh2;//
		this.GatsosFun=funerarios;//
		this.SGMM=sgmm2;//
		this.Hipotecarios=hipotecarios2;//
		this.Donativos=donativos2;//
		this.SubRetiro=subR;//
		this.TransporteE=transpE;//
		this.NivelE=nivelE2;//
		this.Colegiatura=colegiaturaP;//
		
		
		
		this.AguinaldoE=0;//Calcular desde aqui =>
		this.AguinaldoG=0;
		this.PrimaVE=0;
		this.PrimaVG=0;
		this.TotalIngresosG=0;
		this.MaxDedColeg=0;
		this.TotalDedNoRetiro=0;
		this.DedPerm=0;
		this.MontoISR=0;
		this.CuotaFija=0;
		this.PorcExced=0;
		this.PagoEx=0;
		this.Total=0;// Hata aqui <=
		
		
	}
	
	
	public void EntradaySalida() {
		returnVal=fileChooser.showOpenDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			file=fileChooser.getSelectedFile();
			StringTokenizer st;
			try{
				JOptionPane.showMessageDialog(this.pr, "Ahora escogeras donde lo quieres guardar");
				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				f.showSaveDialog(null);
			    PrintWriter pw=new PrintWriter(f.getSelectedFile()+"\\Resultados_de_"+this.nombre+".csv");
			    System.out.println(f.getCurrentDirectory());
			    System.out.println(f.getSelectedFile());
			    
			    
			    
			    
			    
			    
				br=new BufferedReader(new FileReader(file));
				pw.println("Nombre,RFC,Sueldo mensual,Ingreso anual,Aguinaldo,Aguinaldo exento,Aguinaldo gravado,Prima vacacional,Prima vacacional excenta,Prima vacacional gravada,Total ingresos gravan,Medicos y hospitales,Gastos funerarios,SGMM,Hipotecarios,Donativos,Subcuenta retiro,Transporte escolar,Nivel educativo,Maximo a deducir colegiatura,Colegiatura pagada,Total deducciones (sin retiro),Deduccion permitida 10%,Monto ISR,Cuota fija,Porcentaje excedente,Pago excedente,Total a pagar");
				
				while((currentLine=br.readLine())!=null) {
					st=new StringTokenizer(currentLine);
					
					String name=st.nextToken(",");//
					
					String rfc=st.nextToken(",");//
					
					Double sueldo=(Double.parseDouble(st.nextToken(",")));
					int sueldoM= sueldo.intValue();//
					
					
					
					Double Aguinaldo=(Double.parseDouble(st.nextToken(",")));
					int aguinaldo=Aguinaldo.intValue();
					
					
					
					Double Primav=(Double.parseDouble(st.nextToken(",")));
					int PrimaV=Primav.intValue();
					
					
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
					
					Double Colegiatura=(Double.parseDouble(st.nextToken(",")));
					int ColegiaturaP=Colegiatura.intValue();
					
					this.calculo(name, rfc, sueldoM, aguinaldo, PrimaV,myh,Funerarios, sgmm,hipotecarios,Donativos,subR,transpE,NivelE,ColegiaturaP);
					
				   
				    pw.println(this.nombre+","+this.RFC+","+this.SueldoM+","+this.IngresoA+","+this.Aguinaldo+","+this.AguinaldoE+","+this.AguinaldoG+","+this.PrimaV+","+this.PrimaVE+","+this.PrimaVG+","+this.TotalIngresosG+","+this.MyH+","+this.GatsosFun+","+this.SGMM+","+this.Hipotecarios+","+this.Donativos+","+this.SubRetiro+","+this.TransporteE+","+this.NivelE+","+this.MaxDedColeg+","+this.Colegiatura+","+this.TotalDedNoRetiro+","+this.DedPerm+","+this.MontoISR+","+this.CuotaFija+","+this.PorcExced+","+this.PagoEx+","+this.Total);
					
				}
			    pw.close();  
				
			    
				this.sb.setMessage("Archivo guardado Exitosamente");
			}catch(Exception error) {
				JOptionPane.showMessageDialog(this.pr,"Error, Archivo no valido");
			}
		}
		
		
		
	}
	
	
	
	
	
	
}
 
