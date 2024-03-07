
public class SalarioLiquidoProf {

	public static void main(String[] args) {
		
		double valor_hora = 17.95 , perc_inss = 7.5;
		double sal_bruto, desc_inss, sal_liq;
		int horas_trab = 168;
		
		sal_bruto = valor_hora * horas_trab;
		desc_inss =	perc_inss / 100 * sal_bruto;	
		sal_liq = sal_bruto - desc_inss;
		
		System.out.println(sal_liq);
		

	}

}
