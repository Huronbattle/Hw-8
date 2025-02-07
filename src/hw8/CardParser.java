package hw8;


import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class CardParser 
{
	private String urlString;
	private ArrayList<HearthstoneCard> theMinions;
	
	private ArrayList<HearthstoneCard> sorted;
	
	public CardParser(String urlString)
	{
		
		
		this.urlString = urlString;
		theMinions = new ArrayList<HearthstoneCard>();
		
		URLReader hearthstoneURLReader = new URLReader(this.urlString);
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		
		
		
	    if(obj instanceof JSONArray)
	    {
	    	
	    	JSONArray array = (JSONArray)obj;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			
		    			System.out.println(cardData.keySet().toString());
		    			String name = (String)cardData.get("name");
		    			int cost = Integer.parseInt(cardData.get("cost").toString());
		    			int attack = Integer.parseInt(cardData.get("attack").toString());
		    			int health = Integer.parseInt(cardData.get("health").toString());
		    			HearthstoneCard temp = new HearthstoneCard(name, cost, attack, health);
		    			theMinions.add(temp);
		    		}
		    	}
		    	
		    }
	    }
	    sorted = new ArrayList<HearthstoneCard>();
	    if(theMinions instanceof JSONArray) {
	    	
			for (int d = 1; d < 11; d++) {
			for (int i = 0; i < this.theMinions.size(); i++) {
				
				
				if(this.theMinions.get(i).getCost() == d ) {
					System.out.println(sorted.toString());
					String name = theMinions.get(i).getName();
	    			int cost = theMinions.get(i).getCost();
	    			int attack = theMinions.get(i).getAttack();
	    			int health = theMinions.get(i).getDefense();
	    			HearthstoneCard temp = new HearthstoneCard(name, cost, attack, health);
					sorted.add(temp);
						
					}}}}
				
				
	}
	
	public void showMinions()
	{
		for(int i = 0; i < this.theMinions.size(); i++)
		{
			this.theMinions.get(i).display();
		}
	}
	
	public void sortLowestCostToHighestCost()
	{
		for(int i = 0; i < this.sorted.size(); i++)
				{
				this.sorted.get(i).display();
				System.out.println(sorted);
				}}
		    
					
					
		
		
		
		//this methods job is to take our ArrayList of minions and re-arrange it so that
		//it is in the order of cards with the lowest cost first, and cards with the highest
		//cost last.
		//Note: this.theMinions.get(3).getCost() will give you the cost of card #3
		//Note: this.theMinions.remove(3) will remove the card that used to be at bucket 3
		//you will need to cobble together your own algorithm for getting this arraylist sorted
		
	}
