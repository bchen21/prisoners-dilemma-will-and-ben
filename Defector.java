import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.ArrayList;

public class Defector extends Creature{
	
	public Defector(Location l, World w) {
		super(l,w);
		myColor = Color.red;
	}
	public void interact() {
		for(Creature x : myNeighbors) {
			if(x.getMyColor() == Color.GREEN)
				myScore+=5;
			else if(x.getMyColor() == Color.RED) {
				myScore+=1;
			}
		}
	}
	
	public void seeWhoIsBest() {
		int highScore = myScore;
		int bestNeighborIndex = -1;
		for(int i = 0; i < myNeighbors.size(); i++) {
			if(myNeighbors.get(i).getMyScore() > highScore) {
				bestNeighborIndex = i;
				highScore = myNeighbors.get(i).getMyScore();
			}
		}
		if(bestNeighborIndex != -1) {
			if(myNeighbors.get(bestNeighborIndex).getMyColor() == Color.GREEN) {
				willChange = true;
			}
		}
	}
		
}
