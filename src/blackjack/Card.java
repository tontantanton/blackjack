package blackjack;


import java.util.ArrayList;
import java.util.List;

public class Card {

    private String point;
    private String suit;

    public Card (String cardPoint, String cardSuit){
        this.point = cardPoint;
        this.suit = cardSuit;
    }

    public String getPoint(){
        return point;
    }

    public String getSuit(){
        return suit;
    }

//    public String toString(){
//        return point +  suit;
//    }


    @Override
    public String toString() {
        return "Card{" +
                "point='" + point + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}