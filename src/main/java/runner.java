import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingcompetition.statefarm.Category;
import com.codingcompetition.statefarm.SearchCriteria;
import com.codingcompetition.statefarm.StreetMapDataInterpreter;

public class runner {

	public static void main(String[] args)
	{
		StreetMapDataInterpreter di = new StreetMapDataInterpreter("/test-metro.xml");
		
		
		SearchCriteria sc1 = new SearchCriteria(Category.NAME, "Made Up Name ");
		SearchCriteria sc2 = new SearchCriteria(Category.AMENITY, "restaurant");
		//System.out.println(di.interpret(sc2).toString());
		List<SearchCriteria> scl = new ArrayList<>();
		scl.add(sc1);
		scl.add(sc2);
		//System.out.println(di.findByCriterias(scl).toString());
		
		
		Map<Integer,SearchCriteria> f = new HashMap<>();
		f.put(1, sc1);
		f.put(2, sc2);
		System.out.println(di.interpret(f).toString());
		
		
	}

}
