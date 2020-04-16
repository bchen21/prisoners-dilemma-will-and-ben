
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
			x.findMyNeighbors();
			x.interact();
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

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
	
}
