package domein;

import java.math.BigDecimal;

public class Zichtrekening {

	private BigDecimal saldo;

	public Zichtrekening() {
		setSaldo(BigDecimal.ZERO);
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	private void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void stort(BigDecimal bedrag) {
		if (bedrag == null || bedrag.compareTo(BigDecimal.valueOf(0.05)) < 0)
			throw new IllegalArgumentException("Ongeldig bedrag");
		setSaldo(saldo.add(bedrag));
	}
}