package ad.service;

/**
 *  
 * @author chouh006
 * This is a base class that is capable of creating an add.
 */

public class Ad {
	protected String name;
	
	public String getName() {
		return this.name;
	}
	
	public void create() {
		System.out.println("Creating an Ad");
	}
}
