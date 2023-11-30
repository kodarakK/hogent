package domein;
/*
Card stelt een speelkaart voor. 
Een kaart heeft een "waarde" (Eng: face) en een "kleur" (Eng: suit). 
Vb. Klaverenvier heeft als waarde vier en als kleur klaveren en 
hartenheer heeft als waarde heer en als kleur harten.
*/

public class Card 
{
    private final String face; //waarde
    private final String suit; //kleur
    
    public Card(String face, String suit)
    {
        this.face = face;
        this.suit = suit;
    }
    
    //methode toString bestaat reeds in klasse Object
    //we gaan de methode toString overschrijven
    @Override
    public String toString()
    {
        return String.format("%s of %s", face, suit);
    }
}