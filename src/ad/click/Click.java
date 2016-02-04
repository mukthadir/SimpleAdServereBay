package ad.click;

import java.util.HashMap;

import ad.service.Ad;
import ad.service.AdStore;

/**
 *  Given more time, I would have created a table column in database
 *  named as ClickCount and would have incremented the value there.
 *  But since I do not have a database connection right now and 
 *  I do not remember well how to connect a database with eclipse,
 *  I am using a hash map to do this. But in practical scenario,
 *  I would have done this in the database table.
 */

/**
 * 
 * @author chouh006
 *
 * This class is responsible for keeping the count of the clicks
 *  of each ad.Whenever a user clicks on an ad that is displayed
 *  on any page, increaseCount method of this class will be called
 *  and will increment the clickCount of the respective ad.
 */
public class Click {
	
	private static Click clickInstance = null;
	
	/** 
	 * Keeping the constructor private so that any other
	 * class then itself is not able to create an instance
	 * of this class. This is important because we do not
	 * want to have multiple instances of the database where
	 * our ads are kept
	 */
	private Click() {}
	
	public static Click getInstance() {
		if (clickInstance == null) {
			clickInstance = new Click();
		}
		return clickInstance;
	}
	
	private HashMap<Ad, Integer> clickCount = new HashMap<Ad, Integer>();
	
	private AdStore adstore = AdStore.getInstance();
	private Ad ad;
	
	public void increaseCount(int adID) {
		ad = adstore.getAd(adID);
		clickCount.put(ad, clickCount.get(ad) + 1);
	}
	
	public int getImpressionOfAd(Ad ad) {
		return clickCount.get(ad);
	}
}
