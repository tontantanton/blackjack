package blackjack;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Table table = new Table();
        int CountPlayer;

        System.out.println("Begin!!!");
        System.out.print("System Command : How many Player  : ");
        CountPlayer = scanner.nextInt();
        System.out.println();

        for (int i = 0; i < CountPlayer; i++) {
        	i++;
            System.out.print("Player Number "+i+" Insert Name : ");
            String Name = scanner.next();
            Player player = new Player(Name);
            table.AddPlayer(player);
            i--;
        }
        
//        boolean isplayagain = true;
        int con =1;

        while(con==1) {
        	
        
        System.out.println();

        table.getDeck().ShuffleCard();
        table.startBlackjack();
        table.tablePrintAllStatus();

        
        System.out.println("");
        System.out.println("----------GAME START----------");
        table.getDealer().closeCard();
        table.getDealer().printInformationThisPerson();

        for (int i = 0; i < table.getListOfPlayer().size(); i++) {
            System.out.println("This Play is  " + table.getListOfPlayer().get(i).getName());
            System.out.print  ("How Much Bet Money : ");
            int betMoney = scanner.nextInt();
            table.getListOfPlayer().get(i).setBet(betMoney);
            
            
            outerloop:
            while (table.getListOfPlayer().get(i).getCardInHand().size() < 5 ) {
                System.out.println("If Want to \"more , Stay\" Type in That Word");
                String status = scanner.next().toLowerCase();
                System.out.println("Input command is : " + status);
                switch (status) {
                    case "more":
                        table.getListOfPlayer().get(i).reciveCard(table.getDeck().drawCard());
                        table.getListOfPlayer().get(i).printInformationThisPerson();
                        table.tableCheckPlayerPoint( table.getListOfPlayer().get(i));
                        if(table.getListOfPlayer().get(i).getWinGame()||table.getListOfPlayer().get(i).getLoseGame()) {
                        	break; 
                        }
                        break;
                    case "stay":
                        System.out.println("Stop of "+table.getListOfPlayer().get(i).getName());
                        System.out.println();
                        break outerloop;
                }
            }
            System.out.println();
        }

        table.getDealer().openCard();
        while (table.getDealer().getPoint() < 16) {
            System.out.println("Dealer want more!!!");
            table.getDealer().reciveCard(table.getDeck().drawCard());
        }
        table.getDealer().printInformationThisPerson();

        System.out.println("----------CHECK TABLE----------");
        table.comparePoint();
        for (int i = 0; i < table.getListOfPlayer().size(); i++) {
            table.getListOfPlayer().get(i).printInformationThisPerson();
        }

        System.out.println("----------END GAME THIS ROUND----------");

        for (int i = 0; i < table.getListOfPlayer().size(); i++) {
        	System.out.println("This Play : " + table.getListOfPlayer().get(i).getName());	
        	System.out.println("If you want to play again press 1 if not press 0");
        	int num = scanner.nextInt();
        	if(num == 1)
        	{
        		con = con+0;
        	}else if(num == 0)
        	{
        		con--;
        	}
//        String playagain = scanner.next().toLowerCase();
//        if(!playagain.equalsIgnoreCase("yes")) {
//        	table.getListOfPlayer().remove(i);
//        	i = i -1;
//        }
//        if(table.getListOfPlayer().size()>0) {
//        	isplayagain = true;
//        }else {
//        	isplayagain = false;
//        }
//        
//        }
        
        table.tableReset();
        }
    
       }
    }
}

