package hw8;


public class Driver 
{

	public static void main(String[] args)
	{ 
		CardParser cp = new CardParser("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		cp.sortLowestCostToHighestCost();
	}
}