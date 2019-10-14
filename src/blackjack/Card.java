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
public class Card {
    
    private final Face face;
    private final Suit suit;
    
    public Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;
    }
    public Face getFace(){
        return face;
    }
    public Suit getSuit(){
        return suit;
    }
    @Override
    public String toString(){
        return face +" of "+ suit;
    }
    
}
