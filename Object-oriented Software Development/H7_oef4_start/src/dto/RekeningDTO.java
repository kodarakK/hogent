package dto;

public record RekeningDTO(long rekeningNr, double saldo, String houder, double maxKredietOnderNul, double aangroeiIntrest, char soort)
{
	public RekeningDTO(long rekeningNr, double saldo, String houder, double aangroeiIntrest) {
		this(rekeningNr, saldo, houder, 0, aangroeiIntrest, 'S');
	}
	
	public RekeningDTO(long rekeningNr, double saldo, double maxKredietOnderNul, String houder) {
		this(rekeningNr, saldo, houder, maxKredietOnderNul, 0, 'Z');
	}
}
