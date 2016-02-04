package ad.service;

/**
 * 
 * @author chouh006
 * This is a Simple factory class which helps in abstraction
 * and returns the specific type of ad asked for.
 */

public class AdCreatorFactory {
	
	public Ad createAd(String type) {
		Ad ad = null;
		
		if(type.equals("musicInstrument")) {
			ad = new MusicInstrumentAd();
		} else if(type.equals("gaming")) {
			ad = new GamingAd();
		} else if(type.equals("commercial")) {
			ad = new CommercialAd();
		}
		
		return ad;
	}
}
