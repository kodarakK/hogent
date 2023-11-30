package utils;

public enum Kleur {
//	JAVA maakt de klasse kleur
	ROOD("(255, 0, 0)", "#ff0000"), GEEL("(255, 255, 0)", "#ffff00"), 
	BLAUW("(0, 0, 255)", "#0000ff"),
	WIT("(255, 255, 255", "#ffffff"), ZWART("(0,0,0)", "#000000"); 

	private final String hexCode; 
	private final String rgbCode;
// JAVA
	private Kleur(String rgbCode, String hexCode) { 
		this.rgbCode = rgbCode;
		this.hexCode = hexCode;
	}

	public String getRgbCode() {
		return rgbCode;
	}

	public String getHexCode() {
		return hexCode;
	}

	@Override
	public String toString() { 
		return String.format("%s - RGB%s - Hex: %s", 
				name().toLowerCase(), getRgbCode(), getHexCode());
	}
}
