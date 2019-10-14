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
import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    
    private final ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<Card>();
        //create deck with cards placed inside 
        for (Suit suit : Suit.values()){
            for (Face face : Face.values()){
                cards.add(new Card(face, suit));
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }
    
    public Card draw(){
        return cards.remove(0);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< cards.size(); i++){
            sb.append(i + 1);
            sb.append('/');
            sb.append(cards.size());
            sb.append(' ');
            sb.append(cards.get(i));
            sb.append('\n');
        }
        return sb.toString();
    }
}
