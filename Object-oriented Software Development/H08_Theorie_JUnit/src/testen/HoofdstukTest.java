package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Hoofdstuk;

class HoofdstukTest
{
//	ALTIJD enkel declareren, niet creëeren
	private Hoofdstuk hs;
	@BeforeEach
	void before() {
		hs = new Hoofdstuk();
	}

//	null, "", "   "
//	"a", "A"
	
	@ParameterizedTest
	@NullAndEmptySource  // null EN ""
//	@NullSource
//	@EmptySource
	@ValueSource(strings = {"   ", "a", "A"})
	void setTitel_ongeldigeTitel_WerptException(String titel) {
//		Hoofdstuk hs = new Hoofdstuk();
		assertThrows(IllegalArgumentException.class,
				() -> hs.setTitel(titel));
	}
	

}
