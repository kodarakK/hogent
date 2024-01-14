package domein;

import persistentie.VerplaatsingMapper;

public class VerplaatsingRepository
{
	private final VerplaatsingMapper vMapper;

	public VerplaatsingRepository()
	{
		super();
		vMapper = new VerplaatsingMapper();
	}
	
	
}
