package io.dweet;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Demonstration on using Java client for dweet.io.
 * 
 * @author Khaled Bakhit <kb@khaled-bakhit.com>
 */
public class demo 
{
    
    public static void main(String[] args) throws IOException, ParseException
    {
        String thingName= "java-client-thing";
        String lock= "my-lock";
        String key= "my-key";
        
        /**
         * Publish a Dweet.
         */
        JsonObject json= new JsonObject();
        json.addProperty("hello", "world!");
        DweetIO.publish(thingName, json);
        
        /**
         * Get latest Dweets. 
         */
        Dweet dweet= DweetIO.getLatestDweet(thingName);
        System.out.println(dweet.getThingName()+ " said : "+ dweet.getContent() +" at "+ dweet.getCreationDate());
        
        /**
         * Get all Dweets ( up to 500 in the last 24 hours )
         */
        List<Dweet> dweets= DweetIO.getAllDweets(thingName);
        for(Dweet d: dweets)
            System.out.println(d.getThingName()+ " said : "+ d.getContent() +" at "+ d.getCreationDate());
        
        /**
         * Lock the thing.
         */
        DweetIO.lock(thingName, lock, key);
  
        /**
         * Create an alert.
         */
        DweetIO.createAlert(thingName, "email1@doh-main.com,email2@doh-main.com", "if(dweet.some_data > 100) return 'something wrong';", key);

        /**
         * Delete alerts.
         */
        DweetIO.removeAlert(thingName, key);
        
        /**
         * Remove lock.
         */
        DweetIO.unlock(thingName, key);
        
    }
    
    
    
    
}
