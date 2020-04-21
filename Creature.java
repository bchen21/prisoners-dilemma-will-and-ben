import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.ArrayList;

public abstract class Creature {
	
	protected Color myColor;
	protected ArrayList<Creature> myNeighbors;
	protected World myWorld;
	protected Location myLocation;
	protected boolean willChange;
	protected int myScore;
	
	public Creature(Location myLocation, World myWorld) {
		this.myLocation = myLocation;
		this.myWorld = myWorld;
		willChange = false;
		myScore = 0;
		myNeighbors = new ArrayList<Creature>();
	}

	public boolean willIChange() {
		return willChange;
	}
	
	public Color getMyColor() {
		return myColor;
	}
	
	public World getMyWorld() {
		return myWorld;
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	
	public int getMyScore() {
		return myScore;
	}
	
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public void findMyNeighbors(Location myLocation) {
//		Address edge cases
		int creatureNum = 0;
		for(Creature x : myWorld.getCreatureList()) {
			creatureNum++;
		}
		System.out.print(creatureNum);
		int x = myLocation.getX();
		int y = myLocation.getY();
		for(Creature z : myWorld.getCreatureList()) {
			if(z.getMyLocation().getX() == x && z.getMyLocation().getY() == y - 1)
				myNeighbors.add(z);
			else if(z.getMyLocation().getX() == x && z.getMyLocation().getY() == y + 1)
				myNeighbors.add(z);
			else if(z.getMyLocation().getX() == x+1 && z.getMyLocation().getY() == y)
				myNeighbors.add(z);
			else if(z.getMyLocation().getX() == x-1 && z.getMyLocation().getY() == y)
				myNeighbors.add(z);
		}
	}
	
	public abstract void interact();
	
	public abstract void seeWhoIsBest();
	
	
}
