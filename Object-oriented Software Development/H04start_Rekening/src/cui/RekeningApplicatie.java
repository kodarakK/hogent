package cui;

import domein.Rekening;

public class RekeningApplicatie
{
	public static void main(String[] args)
	{
		new RekeningApplicatie().start();
	}
	
	private Rekening[] rekeningArray;
	private double[] saldos = {100, 777.77, 287.15, -350, 399.99, 123.45, 987.65, -68.18, 413.26};
	
	
	private void start()
	{
		double gem = 0;
		double saldoTot = 0;
		String uitvoer = "";
		rekeningArray = new Rekening[saldos.length];
		
		for (int index = 0; index < saldos.length; index++) {
			rekeningArray[index] = new Rekening(index,String.format("%c", 'A' + index));
			rekeningArray[index].stort(saldos[index]);
		}
		
		for (Rekening rek : rekeningArray) {
			saldoTot += rek.getSaldo();
			uitvoer += String.format("Rekening %d van %s bevat %.2f Euro%n", rek.getRekeningNummer(), rek.getNaamHouder(), rek.getSaldo());
		}
		
		gem = saldoTot / saldos.length;
		
		System.out.printf("%s%nHet gemiddelde saldo van deze %d rekeningen bedraagt %.2f Euro", uitvoer, saldos.length, gem);
	}
}
