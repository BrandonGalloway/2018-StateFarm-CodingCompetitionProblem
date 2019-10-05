import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.codingcompetition.statefarm.StreetMapDataInterpreter;
import com.codingcompetition.statefarm.utility.PointOfInterestParser;

public class runner {

	public static void main(String[] args)
	{
		StreetMapDataInterpreter di = new StreetMapDataInterpreter("/test-metro.xml");

	}

}
