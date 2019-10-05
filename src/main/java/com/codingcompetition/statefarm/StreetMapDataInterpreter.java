package com.codingcompetition.statefarm;

import java.io.IOException;
import java.io.InputStream;
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
    	
    	
    	
    	
        return null;
    }

    @Override
    public List<PointOfInterest> interpret(Map<Integer, SearchCriteria> prioritizedCriteria) {
        return null;
    }

    @Override
    public List<PointOfInterest> findByCriterias(List<SearchCriteria> criterias) {
        return null;
    }
}
