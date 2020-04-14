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
	
	public Creature(Location myLocation, World myWorld) {
		super();
		this.myLocation = myLocation;
		this.myWorld = myWorld;
		findMyNeighbors(myLocation);
	}

	public Location getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public void findMyNeighbors(Location myLocation) {
		int x = myLocation.getX();
		int y = myLocation.getY();
		Creature north = null;
		Creature east = null;
		Creature south = null;
		Creature west = null;
		for(Creature z : myWorld.getCreatureList()) {
			if(z.getMyLocation().getX() == x && z.getMyLocation().getY() == y - 1)
				north = z;
			else if(z.getMyLocation().getX() == x && z.getMyLocation().getY() == y + 1)
				south = z;
			else if(z.getMyLocation().getX() == x+1 && z.getMyLocation().getY() == y)
				east = z;
			else if(z.getMyLocation().getX() == x-1 && z.getMyLocation().getY() == y)
				west = z;
		}
		myNeighbors.add(north);
		myNeighbors.add(east);
		myNeighbors.add(south);
		myNeighbors.add(west);
		
	}
	
	public void interact() {
		int bestScoreIndex = -1;
		int bestScore = -1;
		for(Creature neighbor : myNeighbors) {
			if(neighbor.)
		}
	}
}
