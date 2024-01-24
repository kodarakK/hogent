package utils;

public enum Gang
{
	KOUD_VOORGERECHT (new String[] {"rundertartaar met truffel en radijs", "garnalentompoes met mango", "bietencarpaccio met notencrunch"}), 
	WARM_VOORGERECHT (new String[] {"wildkroketjes met veenbessenconfituur", "dimsum met kreeft"}), 
	HOOFDGERECHT (new String[] {"wildstoofpot met appeltjes en cranberry's", "gelakte zalm met zeewier en peulvruchten", "vergeten-groentenlasagne met geitenkaas"}), 
	DESSERT (new String[] {"feestelijke chocoladecake", "dessertpannenkoekjes met mango en munt"});
	
	private String[] gerechtnamen;
	
	private Gang(String[] gerechtnamen)
	{
		this.gerechtnamen = gerechtnamen;
	}
	
	public String[] getGerechtnamen()
	{
		return gerechtnamen;
	}
	
	@Override
	public String toString()
	{
		return name().replace("_", " ").toLowerCase();
	}

	public static Gang[] geefJuisteGangen(int aantalGangen)
	{
		return aantalGangen == 4 ? Gang.values() : new Gang[] {KOUD_VOORGERECHT, HOOFDGERECHT, DESSERT};
	}

	public boolean bevatGerecht(String gerechtnaam)
	{
		for (String naam : gerechtnamen)
			if (naam.equals(gerechtnaam))
				return true;
		return false;
	}
}