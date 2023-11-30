package cui;

import domein.Card;

import domein.DeckOfCards;

public class DeckOfCardsApplication {

	public static void main(String[] args) {
		
		DeckOfCards myDeckOfCards = new DeckOfCards(); 
        myDeckOfCards.shuffle(); 
        int teller = 1; 
        Card kaart = myDeckOfCards.dealCard(); 
        
        do
        {            
            System.out.printf("%-19s", kaart); 
            kaart = myDeckOfCards.dealCard(); 
         
            if (teller++ % 4 == 0) 
            {
                System.out.println();
            }
            
        } while (kaart != null); 

	}

}
