import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;
   public int[][] values;
   public Hand(){
      hand = new ArrayList<Card>();
      values = new int[13][2];
      for(int i = 0; i < 13; i++)
      {
         
         values[i][0] = i;
         values[i][1] = 0;
      }
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }

   /*
   BEST
   Royal Flush
   Straight Flush
   Four of a Kind
   Full House
   Flush
   Straight
   Three of a Kind
   Two Pair
   One Pair
   High Card
   WORST
   */
   public String handValue() {
     if(royalFlush(values))
         return "Royal Flush";
      else if(straightFlush(values))
         return "Straight Flush";
      else if(fourKind(values))
         return "Four of a Kind";
      else if(fullHouse(values))
         return "Full House";
      else if(flush())
         return "Flush";
      else if(straight(values))
         return "Straight";
      else if(threeKind(values))
         return "Three of a Kind";
      else if(twoPair(values))
         return "Two Pair";
      else if(pair(values))
         return "Pair";
      return "High Card";
   }
   public int value()
   {
      
      
      for(int i = 0; i < 13; i++)
      {
         values[hand.get(i).value][1] += 1;
      }
      int highestValue = 1;
      if(royalFlush(values))
         highestValue = 10;
      else if(straightFlush(values))
         highestValue = 9;
      else if(fourKind(values))
         highestValue = 8;
      else if(fullHouse(values))
         highestValue = 7;
      else if(flush())
         highestValue = 6;
      else if(straight(values))
         highestValue = 5;
      else if(threeKind(values))
         highestValue = 4;
      else if(twoPair(values))
         highestValue = 3;
      else if(pair(values))
         highestValue = 2;
      return highestValue;
   }
   public boolean pair(int[][] values)
   {
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] == 2)
            return true;
      }
      return false;
   }
   public boolean twoPair(int[][] values)
   {
      int numPairs = 0;
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] == 2)
            numPairs++;
      }
      if(numPairs == 2)
         return true;
      return false;
   }
   public boolean threeKind(int[][] values)
   {
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] == 3)
            return true;
      }
      return false;
   }
   public boolean straight(int[][] values)
   {
      int highest = 0;
      int lowest = 14;
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] > 0)
         {
            if(values[i][0] < lowest)
               lowest = values[i][0];
            if(values[i][0] > highest)
               highest = values[i][0];
         }
      }
      if(!pair(values) && highest - lowest == 4)
         return true;
      return false;
   }
   public boolean flush()
   {
      String firstSuit = hand.get(0).suit;
      for(int i = 1; i < 13; i++)
      {
         if(!firstSuit.equals(hand.get(i).suit))
            return false;
      }
      return true;
   }
   public boolean fullHouse(int[][] values)
   {
      int shouldBe2 = 0;
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] >= 1)
            shouldBe2++;
      }
      if(shouldBe2 == 2 && twoPair(values))
         return true;
      return false;
   }
   public boolean fourKind(int[][] values)
   {
      for(int i = 0; i < 13; i++)
      {
         if(values[i][1] == 4)
            return true;
      }
      return false;
   }
   public boolean straightFlush(int[][] values)
   {
      if(straight(values) && flush())
         return true;
      return false;
   }
   public boolean royalFlush(int[][] values)
   {
      if(straight(values) && flush() && values[12][1] == 1)
         return true;
      return false;
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      if(this.value() < other.value())
         return -1;
      else if(this.value() > other.value())
         return 1;
      return 0;
   }
}
