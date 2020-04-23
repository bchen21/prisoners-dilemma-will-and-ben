
import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {

	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 210;
	public static final int APPLICATION_HEIGHT = 210;
	
	RandomGenerator rgen = new RandomGenerator();
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(21,21);
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 21; j++) {
//				if(rgen.nextBoolean()) {
//					theWorld.getCreatureList().add(new Cooperator( new Location(i,j), theWorld));
//				} else {
//					theWorld.getCreatureList().add(new Defector( new Location(i,j), theWorld));
//				}
				theWorld.getCreatureList().add(new Cooperator( new Location(i,j), theWorld));
			}
		}
//		for(int i = 0; i < 21; i++) {
//			theWorld.getCreatureList().add(new Defector( new Location(10,j), theWorld));
//		}
		theWorld.getCreatureList().remove(220);
		theWorld.getCreatureList().add(new Defector( new Location(10,10), theWorld));
//		for(int i = 11; i < 21; i++) {
//			for(int j = 0; j < 21; j++) {
//				theWorld.getCreatureList().add(new Cooperator( new Location(i,j), theWorld));
//			}
//		}
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		while(true) {
			theWorld.letTimePass();
			for(Creature x: theWorld.getCreatureList()) {
				statusUpdate();
			}
			waitForClick();
			drawWorld();
		}
	}	
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(Creature x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
	public void statusUpdate() { // remove and add cooperator/defector
		for(int i = 0; i < theWorld.getCreatureList().size(); i++) {
			Creature x = theWorld.getCreatureList().get(i);
			if(x.willIChange()) {
				if(x.getMyColor() == Color.GREEN) {
					theWorld.getCreatureList().remove(x);
					Location prevLocation = x.getMyLocation();
					theWorld.getCreatureList().add(new Defector(prevLocation, theWorld ));
				} else {
					theWorld.getCreatureList().remove(x);
					Location prevLocation = x.getMyLocation();
					theWorld.getCreatureList().add(new Cooperator(prevLocation, theWorld ));
				}
			} else {
				x.getMyNeighbors().clear();
			}
		}
	}
  
}
