import java.io.File;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CalculosISR {                      // => Quedan Igual
	private PanelResultados pr;
	
	private String nombre,//
					RFC,//
					NivelE;//
	
	private double SueldoM,//
					IngresoA,
					Aguinaldo,//
					AguinaldoE,
					AguinaldoG,
					PrimaV,//
					PrimaVE,
					PrimaVG,
					TotalIngresosG,
					MyH,//
					GatsosFun,//
					SGMM,//
					Hipotecarios,//
					Donativos,//
					SubRetiro,//
					TransporteE,//
					MaxDedColeg,
					Colegiatura,//
					TotalDedNoRetiro,
					DedPermSinRetiro,
					DedPerm,
					MontoISR,
					CuotaFija,
					LimiteInf,
					PorcExced,
					PagoEx,
					Total;
	
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
		this.LimiteInf=0;
		this.PorcExced=0;
		this.PagoEx=0;
		this.Total=0;
		fileChooser=new JFileChooser();
		
	}
	public void Actualizar(String name, String rfc, double sueldoM, double Aguinaldo, double PrimaV, double DMyH,
			double GastosFun, double SGMM, double Hipotecarios, double Donativos, double AportacionRet, double Transporte, String NivelE,
			double Colegiatura) {
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
		
		
		//CALCULOS
		this.AguinaldoE=this.SueldoM/2;
		this.AguinaldoG=this.Aguinaldo-this.AguinaldoE;
		this.PrimaVE=80.04*15;
		this.PrimaVG=this.PrimaV-this.PrimaVE;
		this.TotalIngresosG=this.IngresoA+this.AguinaldoG+this.PrimaVG;
		this.MaxDedColeg= DedColegiatura(this.NivelE);
		this.TotalDedNoRetiro=this.MyH+this.GatsosFun+this.SGMM+this.Hipotecarios+this.Donativos+this.TransporteE+this.MaxDedColeg;
		this.DedPermSinRetiro=(this.IngresoA+this.Aguinaldo+this.PrimaV)*.1;
		if(this.SubRetiro < this.DedPermSinRetiro) {
			this.DedPerm=this.DedPermSinRetiro+this.SubRetiro;
		}else {
			this.DedPerm=2*this.DedPermSinRetiro;
		}
		this.MontoISR=this.TotalIngresosG-this.DedPerm;
		TarifaISR(this.MontoISR);
		this.PagoEx=(this.MontoISR-this.LimiteInf)*(this.PorcExced/100);
		this.Total=this.CuotaFija+this.PagoEx;
		pr.Imprimir(this.nombre, this.RFC, this.SueldoM,this.IngresoA,this.Aguinaldo,this.PrimaV,this.MyH,this.GatsosFun,this.SGMM,this.Hipotecarios,this.Donativos,this.SubRetiro,this.TransporteE,this.NivelE,this.Colegiatura,this.AguinaldoE,this.AguinaldoG,this.PrimaVE,this.PrimaVG,this.TotalIngresosG,this.MaxDedColeg,this.TotalDedNoRetiro,this.DedPerm,this.MontoISR,this.CuotaFija,this.PorcExced,this.PagoEx,this.Total);
		
		
	}
	public void abrir(String name, String rfc, Double sueldo, Double aguinaldo2,// Ya esta hecho es el vizualizador
			Double primav2, Double myH2, Double gF, Double sGMM2, Double hip, Double donat, Double subR,
			Double transp, String NivelE, Double colegiatura2) {
		this.nombre=name;//
		this.RFC=rfc;//
		this.SueldoM=sueldo;//
		this.Aguinaldo=aguinaldo2;//
		this.PrimaV=primav2;//
		this.MyH=myH2;//
		this.GatsosFun=gF;//
		this.SGMM=sGMM2;//
		this.Hipotecarios=hip;//
		this.Donativos=donat;//
		this.SubRetiro=subR;//
		this.TransporteE=transp;//
		this.NivelE=NivelE;//
		this.Colegiatura=colegiatura2;//
		
		this.calculo(this.nombre, this.RFC, this.SueldoM, this.Aguinaldo, this.PrimaV,this.MyH,this.GatsosFun,
				this.SGMM,this.Hipotecarios,this.Donativos,this.SubRetiro,this.TransporteE,this.NivelE,this.Colegiatura);
		
		/*
		this.IngresoA=this.SueldoM*12;//DONE 
		this.AguinaldoE=aguinaldoE2;
		this.AguinaldoG=aguinaldoG2;
		this.PrimaVE=primavE2;
		this.PrimaVG=primavG2;
		this.TotalIngresosG=totalIG;
		this.MaxDedColeg=maxDedColeg2;
		this.TotalDedNoRetiro=totald;
		this.DedPerm=deducP;
		this.MontoISR=montoISR2;
		this.CuotaFija=cuotaF;
		this.PorcExced=porcE;
		this.PagoEx=pagoE;
		this.Total=totalP;*/
		
		
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
	
	public void calculo(String name, String rfc2, double sueldoM2, double aguinaldo2, double primaV2, double myH2, double gatsosFun2,
			double sGMM2, double hipotecarios2, double donativos2, double subRetiro2, double transporteE2, String nivelE2, double colegiatura2) {
		this.nombre=name;//
		this.RFC=rfc2;//
		this.SueldoM=sueldoM2;//
		this.IngresoA=this.SueldoM*12;//DONE
		this.Aguinaldo=aguinaldo2;//
		this.PrimaV=primaV2;//
		this.MyH=myH2;//
		this.GatsosFun=gatsosFun2;//
		this.SGMM=sGMM2;//
		this.Hipotecarios=hipotecarios2;//
		this.Donativos=donativos2;//
		this.SubRetiro=subRetiro2;//
		this.TransporteE=transporteE2;//
		this.NivelE=nivelE2;//
		this.Colegiatura=colegiatura2;//
		
		
		//CALCULOS
		this.AguinaldoE=this.SueldoM/2;
		this.AguinaldoG=this.Aguinaldo-this.AguinaldoE;
		this.PrimaVE=80.04*15;
		this.PrimaVG=this.PrimaV-this.PrimaVE;
		this.TotalIngresosG=this.IngresoA+this.AguinaldoG+this.PrimaVG;
		this.MaxDedColeg= DedColegiatura(this.NivelE);
		this.TotalDedNoRetiro=this.MyH+this.GatsosFun+this.SGMM+this.Hipotecarios+this.Donativos+this.TransporteE+this.MaxDedColeg;
		this.DedPermSinRetiro=(this.IngresoA+this.Aguinaldo+this.PrimaV)*.1;
		if(this.SubRetiro < this.DedPermSinRetiro) {
			this.DedPerm=this.DedPermSinRetiro+this.SubRetiro;
		}else {
			this.DedPerm=2*this.DedPermSinRetiro;
		}
		this.MontoISR=this.TotalIngresosG-this.DedPerm;
		TarifaISR(this.MontoISR);
		this.PagoEx=(this.MontoISR-this.LimiteInf)*(this.PorcExced/100);
		this.Total=this.CuotaFija+this.PagoEx;
		
		
	}
	
	public double DedColegiatura(String NivelE) {
		if(NivelE == "Preescolar" ) {
			return 14200;
		}else if(NivelE == "Primaria" ) {
			return 12900;
		}else if(NivelE == "Secundaria") {
			return 19900;
		}else if(NivelE == "Profesional Tecnico") {
			return 17100;
		}else{
			return 24500;	
		}
	}
	
	public void TarifaISR(double MontoISR) {
		if(0.01<MontoISR && MontoISR<5952.84) {
			this.CuotaFija=0;
			this.PorcExced=1.92;
			this.LimiteInf=0.01;
		}else if(5952.85<MontoISR && MontoISR<50524.92) {
			this.CuotaFija=114.29;
			this.PorcExced=6.40;
			this.LimiteInf=5952.85;
		}else if(50524.93<MontoISR && MontoISR<88793.04) {
			this.CuotaFija=2966.91;
			this.PorcExced=10.88;
			this.LimiteInf=50524.93;
		}else if(88793.05<MontoISR && MontoISR<103218) {
			this.CuotaFija=7130.48;
			this.PorcExced=16;
			this.LimiteInf=88793.05;
		}else if(103218.01<MontoISR && MontoISR<123580.20){
			this.CuotaFija=9438.47;
			this.PorcExced=17.92;
			this.LimiteInf=103218.01;
		}else if(123580.21<MontoISR && MontoISR<249243.48){
			this.CuotaFija=13087.37;
			this.PorcExced=21.36;
			this.LimiteInf=123580.21;
		}else if(249243.49<MontoISR && MontoISR<392841.96){
			this.CuotaFija=39929.05;
			this.PorcExced=23.52;
			this.LimiteInf=249243.49;
		}else if(392841.97<MontoISR && MontoISR<750000){
			this.CuotaFija=73703.41;
			this.PorcExced=30;
			this.LimiteInf=392841.97;
		}else if(750000.01<MontoISR && MontoISR<1000000){
			this.CuotaFija=180850.82;
			this.PorcExced=32;
			this.LimiteInf=750000.01;
		}else if(1000000.01<MontoISR && MontoISR<3000000){
			this.CuotaFija=260850.81;
			this.PorcExced=34;
			this.LimiteInf=1000000.01;
		}else if(3000000.01<MontoISR){
			this.CuotaFija=940850.81;
			this.PorcExced=35;
			this.LimiteInf=3000000.01;
		}
	}
	
	public void EntradaySalida(String NombreDoc) {
		returnVal=fileChooser.showOpenDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			file=fileChooser.getSelectedFile();
			StringTokenizer st;
			try{
				JOptionPane.showMessageDialog(this.pr, "Ahora escogeras donde lo quieres guardar");
				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				f.showSaveDialog(null);
				PrintWriter pw=new PrintWriter(f.getSelectedFile()+"\\" + NombreDoc+".csv");
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
					JOptionPane.showMessageDialog(null, "El ISR ha sido calculado con exito. El archivo ha sido guardado en la carpeta seleccionada");
				}
			    pw.close();  
				
			    
				this.sb.setMessage("Archivo guardado Exitosamente");
			}catch(Exception error) {
				JOptionPane.showMessageDialog(this.pr,"Error, Archivo no valido");
			}
		}
		
		
		
	}
	
	
	
	
	
	
}
 
 
