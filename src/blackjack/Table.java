package blackjack;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Table {

    List<Player> ListOfPlayer = new ArrayList<>();
    Dealer dealer = new Dealer("Dealer");
    Deck deck = new Deck();

    public void startBlackjack() {
    	
    	for(int i =0; i <2;i++) {
    		GiveCard(dealer);
    		  for (Player player : ListOfPlayer) {
    			  GiveCard(player);
    	           
    	        }
    	}
      
       
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void AddPlayer(Player player) {
        this.ListOfPlayer.add(player);
    }

    public void RemovePlayer(Player player) {
        this.ListOfPlayer.remove(player);
    }

    public void GiveCard(Human human) {
         human.reciveCard(this.deck.drawCard()); 
    }

    public List<Player> getListOfPlayer() {
        return ListOfPlayer;
    }

    public void setListOfPlayer(List<Player> listOfPlayer) {
        ListOfPlayer = listOfPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void comparePoint(){
        int KingPoint = dealer.getPoint();
         for (Player player : ListOfPlayer) {
            int playerNumber = player.getPoint();
            if(playerNumber>KingPoint){
                player.setWinGame(true);
            }else if(playerNumber<KingPoint){
                player.setLoseGame(true);
            }else {
                player.setDrawGame(true);
            }

            if(playerNumber<21&&player.getWinGame()){
                System.out.println("This Player "+player.getName());
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" + "+(player.getBet()*1.5)+" = "+(player.getMoney()+player.getBet()*1.5));
                player.setMoney((player.getMoney()+(player.getBet()*1.5)));
            }else if((playerNumber == 21)){
                System.out.println("This Player "+player.getName());
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" + "+(player.getBet()*2)+" = "+(player.getMoney()+player.getBet()*2));
                player.setMoney((player.getMoney()+(player.getBet()*2)));
            }else{
                System.out.println("This Player "+player.getName());
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" - "+(player.getBet())+" = "+(player.getMoney()-player.getBet()));
                player.setMoney((player.getMoney()-(player.getBet())));
            }
        }
    }
    
    public void tableCheckPlayerPoint(Player player) {
    	if(player.getPoint()>21) {
    		player.setLoseGame(true);
    	}else if((player.getPoint()==21)||player.getCardInHand().size()==5) {
    		player.setWinGame(true);
    	}
    }

    public void tablePrintAllStatus() {
        for (int i = 0; i < this.ListOfPlayer.size(); i++) {
            String name = this.ListOfPlayer.get(i).getName();
            double moneyNow = this.ListOfPlayer.get(i).getMoney();
            List<Card> CardInHand = this.ListOfPlayer.get(i).getCardInHand();
            int allPoint = this.ListOfPlayer.get(i).getPoint();
            

            System.out.println("---------- Detail of "+name+" ----------");
            System.out.println("Money current : "+moneyNow);
            for(Card card : CardInHand){
                System.out.println(name+"'Card : "+card.toString());
            }
            System.out.println("All Point is : "+allPoint);

        }
    }
    
    public void tableReset() {
    	deck.resetDeck();
    	dealer.resetCard();
    	
    	for(int i = 0; i < this.ListOfPlayer.size(); i++){
    		ListOfPlayer.get(i).resetPlayer();
    		
    	}
    }
    
}

