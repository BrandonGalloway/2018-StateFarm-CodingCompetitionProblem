package com.codingcompetition.statefarm.model;

import java.util.HashMap;
import java.util.Map;

public class PointOfInterest 
{
	
	private HashMap<String,String> poiData;
	private String latitude;
	private String longitude;
	
	
	public PointOfInterest() 
	{
		this.poiData = new HashMap<String,String>();
	}
	
	
	

    public PointOfInterest(String latitude, String longitude) {
		super();
		this.poiData = new HashMap<String,String>();
		this.latitude = latitude;
		this.longitude = longitude;
	}




	public Map<String,String> getDescriptors() 
    {
    return poiData;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    
    
    

	public void addDescriptor(String key,String data) {
		poiData.put(key, data);
	}
	
	
	
	public String addDescriptor(String key)
	{
		if(poiData.containsKey(key))
		{
			return poiData.get(key);
		}else
		{
			return null;
		}
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
    
    
    
    
    
}
