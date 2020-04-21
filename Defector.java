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
	
		
}
