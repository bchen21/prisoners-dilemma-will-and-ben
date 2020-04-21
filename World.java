
import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class World {
	
	private int width;
	private int height;
	private ArrayList<Creature> creatureList;
	
	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<Creature>();
	}
	public void letTimePass(){
		creaturesInteract();	
	}
	public void creaturesInteract() {
		for(Creature x: creatureList) {
			x.findMyNeighbors(x.getMyLocation());
			x.interact();
		}
		for(Creature x : creatureList) {
			x.seeWhoIsBest();
		}
		for(int i = 0; i < creatureList.size(); i++) {
			Creature x = creatureList.get(i);
			if(x.willIChange())
				swapPlayer(i, x.getMyColor(), x.getMyLocation(), x.getMyWorld());
				
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<Creature> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<Creature> creatureList) {
		this.creatureList = creatureList;
	}
	
	public void swapPlayer(int index, Color color, Location xy, World world) {
		creatureList.remove(index);
		if(color == Color.GREEN) {
			creatureList.add(index, new Defector(xy, world));
		} else {
			creatureList.add(index, new Cooperator(xy, world));
		}
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
	
}
