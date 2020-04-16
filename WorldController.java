
import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {

	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(20,20);
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				theWorld.getCreatureList().add( new Cooperator( new Location(i,j), theWorld ));
			}
		}
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		for(int i = 0; i < 3;i++){
			theWorld.letTimePass();
			for(Creature x: theWorld.creatureList) {
				statusUpdate();
			}
			pause(500);
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
		for(int i = 0; i < theWorld.creatureList.size(); i++) {
			Creature x = theWorld.creatureList.get(i);
			if(x.willIChange()) {
				if(x.getMyColor() == Color.GREEN) {
					theWorld.creatureList.remove(x);
					Location prevLocation = x.getMyLocation();
					theWorld.creatureList.add(new(Defector(prevLocation, theWorld ));
				} else {
					theWorld.creatureList.remove(x);
					Location prevLocation = x.getMyLocation();
					theWorld.creatureList.add(new(Cooperator(prevLocation, theWorld ));
				}
			}
		}
	}
  
}
