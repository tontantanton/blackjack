package blackjack;



public class Player extends Human{

    
    Boolean loseGame = false;
    Boolean winGame = false;
    Boolean drawGame = false;

    int bet = 0;
    double Money = 1000000;
    int standUp = 0;

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    Player(String name){
        this.Name = name;
    }

    public void printInformationThisPerson(){
        System.out.println("----------- detail of "+getName()+" -----------");
        System.out.println("Money Now is : "+getMoney());
        for(Card card : CardInHand){
            System.out.println("Having Card : "+card.toString());
        }
        System.out.println("All Point is : "+getPoint());
    }

   

    public Boolean getLoseGame() {
        return loseGame;
    }

    public void setLoseGame(Boolean loseGame) {
        this.loseGame = loseGame;
    }

    public Boolean getWinGame() {
        return winGame;
    }

    public void setWinGame(Boolean winGame) {
        this.winGame = winGame;
    }

    public Boolean getDrawGame() {
        return drawGame;
    }

    public void setDrawGame(Boolean drawGame) {
        this.drawGame = drawGame;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }


    public int getStandUp() {
        return standUp;
    }

    public void setStandUp(int standUp) {
        this.standUp = standUp;
    }
    
    public void resetPlayer() {
    	this.resetCard();
    
    	this.setWinGame(false);
    	this.setLoseGame(false);
    	this.setDrawGame(false);
    	
    }
    
}
