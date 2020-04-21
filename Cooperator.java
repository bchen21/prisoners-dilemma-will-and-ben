import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.ArrayList;

public class Cooperator extends Creature{
	
	public Cooperator(Location l, World w) {
		super(l,w);
		myColor = Color.GREEN;
	}
	
	public void interact() {
		for(Creature x : myNeighbors) {
			if(x.getMyColor() == Color.GREEN)
				myScore+=3;
		}
	}
	
	public void seeWhoIsBest() {
		int highScore = 0;
		int bestNeighborIndex = -1;
		for(int i = 0; i < 4; i++) {
			if(myNeighbors.get(i).getMyScore() > myScore) {
				
			}
		}
	}
}
