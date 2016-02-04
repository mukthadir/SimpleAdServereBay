package ad.service;

import java.util.HashMap;

/**
 * 
 * @author chouh006
 * 
 * This is a singleton class that is responsible for
 * managing all the ads that are created. This class
 * also adds and removes ads from the database.
 */

public class AdStore {
	
	private static AdStore adStoreInstance = null;
	
	/** 
	 * Keeping the constructor private so that any other
	 * class then itself is not able to create an instance
	 * of this class. This is important because we do not
	 * want to have multiple instances of the database where
	 * our ads are kept
	 */
	private AdStore() {}
	
	public static AdStore getInstance() {
		if (adStoreInstance == null) {
			adStoreInstance = new AdStore();
		}
		return adStoreInstance;
	}
	
	private HashMap<Integer, Ad> adServer = new HashMap<Integer, Ad>();
	
	// This method adds an ad to the database
	public void addAd(int adId, Ad ad) {
		adServer.put(adId, ad);
	}
	
	// This function returns the ad if it is present in the ad server database
	public Ad getAd(int adId) {
		if(adServer.containsKey(adId)) {
			return adServer.get(adId);
		}
		
		return null;
	}

	// This function deletes the ad from the server is the ad is present else
	// raises an exception that this ad is not present in the database and hence
	// can not be deleted.
	public void removeAd(Ad adId) {
		try {
			if(adServer.containsKey(adId)) {
				adServer.remove(adId);
			}
		} catch (Exception ex) {
			System.out.println("Ad not found.");
			System.out.println(ex.getMessage());
		}
	}
}
