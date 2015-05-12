import java.util.*;

public class Deck {
   private ArrayList<Card> deck;
   private Random rng = new Random();

   public Deck(){
      deck = new ArrayList<Card>();
      //TODO: Add a card (2-14) of each suit (h,s,d,c)
      String suit = "h";
      for(int j = 0; j < 4; j++)
      {
        for(int i = 2; i < 15; i++)
        {
          deck.add(new Card(i, suit));
        }
        if(j == 0)
          suit = "s";
        if(j == 1)
          suit = "d";
        if(j == 2)
          suit = "c";
      }
   }

   public Card remove(){
      int rand = rng.nextInt(deck.size()-1);
      return deck.remove(rand);
   }

   public String toString(){
      return deck.toString();
   }
}
