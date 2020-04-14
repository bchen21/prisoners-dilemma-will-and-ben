import java.awt.Color;

public abstract class Creature {

	protected World myWorld;
	protected Location myLocation;
	
	public Creature(Location myLocation, World myWorld) {
		super();
		this.myLocation = myLocation;
		this.myWorld = myWorld;
	}

	public Location getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
}
