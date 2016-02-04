package ad.impression;

import java.util.HashMap;

import ad.service.Ad;
import ad.service.AdStore;

/**
 *  Given more time, I would have created a table column in database
 *  named as ImpressionCount and would have incremented the value there.
 *  But since I do not have a database connection right now and 
 *  I do not remember well how to connect a database with eclipse,
 *  I am using a hash map to do this. But in practical scenario,
 *  I would have done this in the database table.
 */

/**
 * 
 * @author chouh006
 *
 * This class is responsible for keeping the impression of each ad.
 * Whenever a page that contains this ad would load, we will call
 * impressionCount method of this class and will increment the
 * impression of the respective ad.
 * If a page contains more than one ad, then impressionCount will be
 * called for each and every ad.
 */
public class Impression {
	
	private static Impression impressionInstance = null;
	
	/** 
	 * Keeping the constructor private so that any other
	 * class then itself is not able to create an instance
	 * of this class. This is important because we do not
	 * want to have multiple instances of the database where
	 * our ads are kept
	 */
	private Impression() {}
	
	public static Impression getInstance() {
		if (impressionInstance == null) {
			impressionInstance = new Impression();
		}
		return impressionInstance;
	}
	
	private HashMap<Ad, Integer> impressionCount = new HashMap<Ad, Integer>();
	
	private AdStore adstore = AdStore.getInstance();
	private Ad ad;
	
	public void increaseImpression(int adID) {
		ad = adstore.getAd(adID);
		impressionCount.put(ad, impressionCount.get(ad) + 1);
	}
	
	public int getImpressionOfAd(Ad ad) {
		return impressionCount.get(ad);
	}
}
