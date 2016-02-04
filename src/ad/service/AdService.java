package ad.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  

import ad.click.Click;
import ad.impression.Impression; 

@Path("SimpleAdServereBay")
public class AdService {	
	private AdCreatorFactory adCreatorFactory = new AdCreatorFactory();
	private AdStore adStore = AdStore.getInstance();
	private Impression impression = Impression.getInstance();
	private Click click = Click.getInstance();
	private int adID = 0;
	
	@PUT
	@Path("/CreateAd/")
	@Produces("text/plain")
	public Ad createAd(String type) {
		Ad ad = adCreatorFactory.createAd(type);
		adStore.addAd(adID++, ad);
		impression.increaseImpression(adID);
		click.increaseCount(adID);
		
		return ad;
	}
	
	@GET
	@Path("/GetAd/")
	@Produces("text/plain")
	public Ad getAd() {
		// yet to implement
		/**
		 * The idea is to get the top 10 ads that have the maximum click.
		 * In case of ads less than 10, I will get all the ads that are
		 * present in the database.
		 * Then, out of these ads, I will select the add that has the
		 * maximum count of impression and finally I will return the
		 * ad obtained in the above process.
		 * 
		 * Note: In practical scenario, it will be easy to get the top 10
		 * ads from the database with just a simple SQL query. But, here, since
		 * I am using a hash map, I will have to iterate over the hash map and
		 * get the top 10 values.
		 * Once I have these ads, it is easy to get the ad with maximum impression
		 * with a simple SQL query.
		 * Over here, I need to iterate the hash map and return the ad that has the
		 * maximum count of impression.
		 */
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	@DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        Ad ad = adStore.getAd(id);
        if(ad != null) {
        	adStore.removeAd(ad);
        	System.out.println(ad + " is deletd");
        } else {
        	System.out.println("This ad is not present");
        }
    }
}
