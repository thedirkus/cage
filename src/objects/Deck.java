package objects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Deck {
	
	LinkedList<Card> _cards;
	
	public Deck(){
		
		_cards = new LinkedList<Card>();
	}
	
	
	/**
	 * The size of the deck
	 * @return
	 */
	public int size() { return _cards.size(); }
	
	
	/**
	 * draw a card from the top of the deck
	 * @return
	 */
	public Card draw() {
		
		return _cards.pop();
	}
	
	
	/**
	 * Draw a card from the bottom of the deck
	 * @return
	 */
	public Card drawBottom(){
		
		return _cards.removeLast();
	}
	
	
	/**
	 * Peek at the top card
	 * @return
	 */
	public Card peek() {
		
		return _cards.peek();
	}
	
	
	/**
	 * Draw a card using a specified index
	 * Removed the card from the deck.
	 * @param i
	 * @return
	 */
	public Card get(int i){
		
		Card toreturn = _cards.get(i);
		_cards.remove(i);
		return toreturn;
	}
	
	
	/**
	 * Removes and returns the first instance of a particular Card
	 * in the deck.  If the card is not in the deck, returns null.
	 * @param c
	 * @return
	 */
	public Card get(Card c){
		
		Card toreturn = null;
		for (int i = 0; i < _cards.size(); i++){
			
			Card e = _cards.get(i);
			
			if(c.equals(e)) {
				toreturn = e;
				_cards.remove(i);
			}
		}
		
		return toreturn;
	}
	
	
	/**
	 * Shuffle the deck
	 */
	public void shuffle(){
		
		Collections.shuffle(_cards);
	}
	
	
	/**
	 * returns a random card from the deck
	 * @return
	 */
	public Card getRandom(){
		
		int i = (int) Math.floor(Math.random()*_cards.size());
		return _cards.get(i);
	}
	
	
	/**
	 * Put a card on the top of the deck
	 * @param c
	 */
	public void putOnTop(Card c){
		
		_cards.push(c);
	}
	
	
	/**
	 * Put a card on the bottom of the deck
	 * @param c
	 */
	public void putOnBottom(Card c){
		
		_cards.addLast(c);
	}
	
	
	/**
	 * Returns the entire list of cards in the deck
	 * @return
	 */
	public LinkedList<Card> getCards(){
		
		return _cards;
	}
	
	
	/**
	 * Adds a List of Cards to the top of the Deck
	 * @param cards
	 */
	public void addAll(List<Card> cards){
		
		_cards.addAll(0, _cards);
	}
	
}
