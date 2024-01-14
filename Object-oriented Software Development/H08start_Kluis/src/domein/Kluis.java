package domein;

public class Kluis {
	private final String code;

	private static final int AANTAL_CIJFERS = 4;
	
	public Kluis(String code) {
		controleerCode(code);
		this.code = code;
	}

	private void controleerCode(String code) {
		if (code == null || code.isBlank())
			throw new IllegalArgumentException("Je moet een code opgeven");
		
		if (code.length() != AANTAL_CIJFERS)
			throw new IllegalArgumentException(
					String.format("De code moet exact %d cijfers lang zijn", AANTAL_CIJFERS));
		
		for (int i = 0; i < AANTAL_CIJFERS; i++)
			if (code.charAt(i) < '0' || code.charAt(i) > '9')
				throw new IllegalArgumentException("De code mag enkel cijfers bevatten");
			
		if (!controleerVerschillendeCijfers(code))
			throw new IllegalArgumentException(
					String.format("De code mag niet uit %d gelijke cijfers bestaan", AANTAL_CIJFERS));
		
	}

	private boolean controleerVerschillendeCijfers(String code)
	{
		for (int i = 0; i < AANTAL_CIJFERS-1; i++)
		{
			if (code.charAt(i) != code.charAt(i+1))
				return true;
		}
		return false;
	}
	
	public boolean valideerCode(String code) {
		return this.code.equals(code);
	}

}
