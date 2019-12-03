/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Revenger Mini
 */
import java.util.Scanner;
public class BlackJack {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String nickname;
        String input;
        int rounds;
        //ask for nickname
        System.out.println("What nickname would you like to have?");
        input = scanner.nextLine();
        nickname = input;
        System.out.println("How many rounds do you want to play?");
        rounds = scanner.nextInt();
        
        for (int i=0; i <= rounds-1; i++) {
        //main loop
        do {
            //new game message
            System.out.println();
            System.out.println("A new game has begun.");
            System.out.println();
            //dealer
            Player player = new Player(nickname);
            Player dealer = new Player("Dealer");
            Deck deck = new Deck ();
            deck.shuffle();
            boolean gameOver = false;
            //cards given to player
            player.addCard(deck.draw());
            player.addCard(deck.draw());
            System.out.println(player.getHandAsString(false));
            //cards given to dealer
            dealer.addCard(deck.draw());
            dealer.addCard(deck.draw());
            System.out.println(dealer.getHandAsString(true));
            //player's turn
            do {
                System.out.println("Would "+player.getNickname()+" like to bust "
                        + "or stay? 'Bust/Stay'");
                do {
                    input = scanner.nextLine();
                } while (!input.equalsIgnoreCase("Bust")&& !input.equalsIgnoreCase("Stay"));
                //bust
                if (input.equalsIgnoreCase("Bust")){
                    player.addCard(deck.draw());
                    System.out.println(player.getNickname()+" drew a card.");
                    System.out.println();
                    System.out.println(player.getHandAsString(false));
                    if (player.getHandSum()> 21){
                            System.out.println("You busted and got a total of "
                                    +player.getHandSum()+". Dealer wins this time!");
                            gameOver = true;
                        }
                    }
                    //stay
                    if (input.equalsIgnoreCase("stay")){
                        System.out.println("You have chosen to stay. Your hand: "
                                +player.getHandSum());
                    }
            } while (input.equalsIgnoreCase("Bust")&& !gameOver);
            //dealer's turn
            if (!gameOver){
                System.out.println();
                System.out.println("- Dealers turn -");
                System.out.println();
                System.out.println(dealer.getHandAsString(false));
            }
            while (!gameOver){
                if (dealer.getHandSum()<= 15){
                    //draw a card
                    dealer.addCard(deck.draw());
                    System.out.println(dealer.getNickname()+" drew another card");
                    System.out.println();
                    System.out.println(dealer.getHandAsString(false));
                    if (dealer.getHandSum() == 15) {
                        System.out.println("Blackjack! Dealer won.");
                        gameOver = true; 
                    }
                    if (dealer.getHandSum() > 21){
                        System.out.println("Dealer busted and got a total of "+ 
                                dealer.getHandSum()+ ". "+ player.getNickname()+ 
                                " wins this time!");
                        gameOver = true;
                    }
                } else {
                    //stay
                    System.out.println("Dealer has chosen to stay!");
                    System.out.println();
                    int totalDealerSum = dealer.getHandSum();
                    int totalPlayerSum = player.getHandSum();
            
                    if (totalDealerSum > totalPlayerSum) {
                        System.out.println("Both players has decided to stay. The"
                                + " winner is "+ dealer.getNickname()+" with a "
                                        + "total of "+totalDealerSum+".");
                    } else {
                    System.out.println("Both players has decided to stay. The "
                            + "winner is "+ player.getNickname()+" with a total "
                                    + "of "+totalPlayerSum+".");
                    }
                    gameOver = true;
                }
            }if(rounds == i){
                break;
            
            }
        }while (rounds==i);{
            System.out.println("You have played "+rounds+" rounds");
            
            }
        
        }
    }   
}

                
        
        
            
            
        
    

