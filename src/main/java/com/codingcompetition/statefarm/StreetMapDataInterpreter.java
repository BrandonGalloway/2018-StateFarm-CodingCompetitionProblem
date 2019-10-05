package com.codingcompetition.statefarm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.codingcompetition.statefarm.model.PointOfInterest;
import com.codingcompetition.statefarm.utility.PointOfInterestParser;

public class StreetMapDataInterpreter implements Interpreter {

	private PointOfInterestParser parser = new PointOfInterestParser();
	private List<PointOfInterest> parsedPoi;
	private static Logger log = Logger.getLogger(StreetMapDataInterpreter.class.getName());
	
	public StreetMapDataInterpreter(String s)
    {
		try {
			this.parsedPoi = parser.parse(s);
		} catch (IOException | SAXException | ParserConfigurationException e) {
			log.severe("A error occured parsing the specified file");
			e.printStackTrace();
		}
    }

    @Override
    public List<PointOfInterest> interpret() {
        return parsedPoi;
    }

    @Override
    public List<PointOfInterest> interpret(SearchCriteria criteria) {
    	
    	List<PointOfInterest> matchedPoi = new ArrayList<>();
    	if(criteria == null)
    	{
    		return matchedPoi;
    	}
    	
    	
    	for(PointOfInterest p : parsedPoi)
    	{
    		if(p.getDescriptors().containsKey(criteria.getCategory().toString().toLowerCase()))
    		{
    			if(p.getDescriptors().get(criteria.getCategory().toString().toLowerCase()).equals(criteria.getValue()))
    			{
    				matchedPoi.add(p);
    			}
    		}
    	}
    	
        return matchedPoi;
    }

    @Override
    public List<PointOfInterest> interpret(Map<Integer, SearchCriteria> prioritizedCriteria) {
    	List<PointOfInterest> matchedPoi = new ArrayList<>();
    	for(PointOfInterest p : parsedPoi)
    	{
    		boolean meetsCriteria = true;
    		for(Integer i : prioritizedCriteria.keySet())
    		{
    			SearchCriteria criteria = prioritizedCriteria.get(i);
    			if(p.getDescriptors().containsKey(criteria.getCategory().toString().toLowerCase()))
    			{
    				if(p.getDescriptors().get(criteria.getCategory().toString().toLowerCase()).equals(criteria.getValue()))
    				{
    					continue;
    				}
    			}
    			meetsCriteria = false;
    			break;
    		}
    		if(meetsCriteria)
    			matchedPoi.add(p);
    	}
    	
        return matchedPoi;
    }

    @Override
    public List<PointOfInterest> findByCriterias(List<SearchCriteria> criterias)
    {
    	List<PointOfInterest> matchedPoi = new ArrayList<>();
    	for(PointOfInterest p : parsedPoi)
    	{
    		//boolean meetsCriteria = true;
    		for(SearchCriteria criteria : criterias)
    		{
    			
    			if(p.getDescriptors().containsKey(criteria.getCategory().toString().toLowerCase()))
    			{
    				if(p.getDescriptors().get(criteria.getCategory().toString().toLowerCase()).equals(criteria.getValue()))
    				{
    					matchedPoi.add(p);
    					break;
    				}
    			}
    		}
    	}
    	
        return matchedPoi;
    }
}
