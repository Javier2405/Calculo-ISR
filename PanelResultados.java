import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelResultados extends JPanel{
	private String nombre;
	private String rfc;
	private int sueldoMes;
	private int ingresoAnual;
	private int Aguinaldo;
	private int AguinaldoExento;
	private int AguinaldoGravado;
	private int PrimaV;
	private int PrimaVE;
	private int PrimaVG;
	private int TotalIngresosG;
	private int SGMM;
	private int GastosF;
	private int MyH;
	private int Hipotecarios;
	private int Donativos;
	private int SubRetiro;
	private int TransporteE;
	private String NivelE;
	private int MaxDedColeg;
	private int ColegPag;
	private int DedPermit;
	private int TotalDeduc;
	private int MontoISR;
	private int CuotaF;
	private int PorcentEx;
	private int PagoEx;
	private int Total;
	public PanelResultados() {
		super();
		this.sueldoMes=0;
		this.nombre="uknown";
		this.rfc="uknown rfc";
		this.ingresoAnual=0;
		this.Aguinaldo=0;
		this.AguinaldoExento=0;
		this.AguinaldoGravado=0;
		this.PrimaV=0;
		this.PrimaVE=0;
		this.PrimaVG=0;
		this.TotalIngresosG=0;
		this.SGMM=0;
		this.GastosF=0;
		this.MyH=0;
		this.Hipotecarios=0;
		this.Donativos=0;
		this.SubRetiro=0;
		this.TransporteE=0;
		this.NivelE="Primaria";
		this.MaxDedColeg=0;
		this.ColegPag=0;
		this.DedPermit=0;
		this.TotalDeduc=0;
		this.MontoISR=0;
		this.CuotaF=0;
		this.PorcentEx=0;
		this.PagoEx=0;
		this.Total=0;
		this.setPreferredSize(new Dimension(800,670));
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect(30, 60, 250, 30);
		g.fillRect(300, 60, 150, 30);
		g.fillRect(30, 130, 115, 30);
		g.fillRect(180, 130, 115, 30);
		g.fillRect(330, 130, 115, 30);
		g.fillRect(30, 200, 115, 30);
		g.fillRect(180, 200, 115, 30);
		g.fillRect(330, 200, 115, 30);
		g.fillRect(30, 270, 115, 30);
		g.fillRect(180, 270, 115, 30);
		g.fillRect(330, 270, 115, 30);
		g.fillRect(30, 340, 115, 30);
		g.fillRect(180, 340, 115, 30);
		g.fillRect(330, 340, 115, 30);
		g.fillRect(30, 410, 115, 30);
		g.fillRect(180, 410, 115, 30);
		g.fillRect(330, 410, 115, 30);
		g.fillRect(30, 480, 115, 30);
		g.fillRect(180, 480, 115, 30);
		g.fillRect(330, 480, 115, 30);
		g.fillRect(30, 550, 115, 30);
		g.fillRect(180, 550, 115, 30);
		g.fillRect(330, 550, 115, 30);
		g.fillRect(30, 620, 115, 30);
		g.fillRect(180, 620, 115, 30);
		g.fillRect(330, 620, 115, 30);
		g.fillRect(480, 620, 115, 30);
		g.fillRect(630, 620, 115, 30);
		
		g.setColor(Color.black);
		g.drawString("NOMBRE:", 30, 50);
		g.drawString("RFC:", 300, 50);
		g.drawString("SUELDO MENSUAL:", 30, 120);
		g.drawString("INGRESO ANUAL:", 180, 120);
		g.drawString("AGUINALDO:", 330,120);
		g.drawString("AGUINALDO EXCENTO:", 30, 190);
		g.drawString("AGUINALDO GRAVADO:", 180, 190);
		g.drawString("PRIMA VACACIONAL:", 330, 190);
		
		g.drawString("PRIMA VAC. EXCENTA:", 30, 260);
		g.drawString("PRIMA VAC. GRAVADA:", 180, 260);
		g.drawString("TOTAL INGRESOS GRAVAN:", 330, 260);
		
		g.drawString("SGMM:", 30, 330);
		g.drawString("GASTOS FUNERARIOS:", 175, 330);
		g.drawString("MEDICOS Y HOSPITALES:", 325, 330);
		
		g.drawString("HIPOTECARIOS:", 30, 400);
		g.drawString("DONATIVOS:", 175, 400);
		g.drawString("SUBCUENTA DE RETIRO:", 325, 400);
		
		g.drawString("TRANS ESCOLAR:", 30, 470);
		g.drawString("NIVEL EDUCATIVO:", 175, 470);
		g.drawString("MÁX A DEDUCIR COLEGIATURA:", 325, 470);
		
		g.drawString("COLEGIATURA PAGADA:", 25, 540);
		g.drawString("DEDUC PERMITIDA 10%:", 175, 540);
		g.drawString("TOTAL DEDUCCIONES (SIN RETIRO):", 325, 540);
		
		g.drawString("MONTO ISR:", 30, 610);
		g.drawString("CUOTA FIJA:", 180, 610);
		g.drawString("PORCENT EXCEDENTE:", 325, 610);
		g.drawString("PAGO EXCEDENTE:", 480, 610);
		g.drawString("TOTAL A PAGAR:", 630, 610);
		g.drawString(this.nombre, 35, 80);
		g.drawString(this.rfc, 305, 80);
		g.drawString("$ "+this.sueldoMes, 35, 150);
		g.drawString("$ "+this.ingresoAnual, 185, 150);
		g.drawString("$ "+this.Aguinaldo, 335, 150);
		
		g.drawString("$ "+this.AguinaldoExento, 35, 220);
		g.drawString("$ "+this.AguinaldoGravado, 185, 220);
		g.drawString("$ "+this.PrimaV, 335, 220);
		
		g.drawString("$ "+this.PrimaVE, 35, 290);
		g.drawString("$ "+this.PrimaVG, 185, 290);
		g.drawString("$ "+this.TotalIngresosG, 335, 290);
		
		g.drawString("$ "+this.SGMM, 35, 360);
		g.drawString("$ "+this.GastosF, 185, 360); 
		g.drawString("$ "+this.MyH, 335, 360);
		
		g.drawString("$ "+this.Hipotecarios, 35, 430);
		g.drawString("$ "+this.Donativos, 185, 430);
		g.drawString("$ "+this.SubRetiro, 335, 430);
		
		g.drawString("$ "+this.TransporteE, 35, 500);
		g.drawString(this.NivelE, 185, 500);
		g.drawString("$ "+this.MaxDedColeg, 335, 500);
		
		g.drawString("$ "+this.ColegPag, 35, 570);
		g.drawString("$ "+this.DedPermit, 185, 570);
		g.drawString("$ "+this.TotalDeduc, 335, 570);
		
		g.drawString("$ "+this.MontoISR, 35, 640);
		g.drawString("$ "+this.CuotaF, 185, 640);
		g.drawString("$ "+this.PorcentEx, 335, 640);
		
		g.drawString("$ "+this.PagoEx, 490, 640);
		g.drawString("$ "+this.Total, 640, 640);
		g.drawImage(new ImageIcon("profile-icon-63199.png").getImage(), 520, 50, 256, 256, this);
	}


	public void Imprimir(String nombre2, String rfc2, int sueldoM, int ingresoA, int aguinaldo2, int primaV2, int myH2,
			int gastosFun, int sgmm2, int hipotecarios2, int donativos2, int subRetiro2, int transporteE2,
			String nivelE2, int colegiatura, int aguinaldoE, int aguinaldoG, int primaVE2, int primaVG2,
			int totalIngresosG2, int maxDedColeg2, int totalDedNoRetiro, int dedPerm, int montoISR2, int cuotaFija,
			int porcExced, int pagoEx2, int total2) {
		this.nombre=nombre2;
		this.rfc=rfc2;
		this.sueldoMes=sueldoM;
		this.ingresoAnual=ingresoA;
		this.Aguinaldo=aguinaldo2;
		this.AguinaldoExento=aguinaldoE;
		this.AguinaldoGravado=aguinaldoG;
		this.PrimaV=primaV2;
		this.PrimaVE=primaVE2;
		this.PrimaVG=primaVG2;
		this.TotalIngresosG=totalIngresosG2;
		this.SGMM=sgmm2;
		this.GastosF=gastosFun;
		this.MyH=myH2;
		this.Hipotecarios=hipotecarios2;
		this.Donativos=donativos2;
		this.SubRetiro=subRetiro2;
		this.TransporteE=transporteE2;
		this.NivelE=nivelE2;
		this.MaxDedColeg=maxDedColeg2;
		this.ColegPag=colegiatura;
		this.DedPermit=dedPerm;
		this.TotalDeduc=totalDedNoRetiro;
		this.MontoISR=montoISR2;
		this.CuotaF=cuotaFija;
		this.PorcentEx=porcExced;
		this.PagoEx=pagoEx2;
		this.Total=total2;
		repaint();
	}
}
