package Daniel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ScholarMap extends HashMap<String, Scholar>{
	private static final long serialVersionUID = 1L;
	
	public String toString()
	{
		String toReturn="";
		ArrayList<Scholar> hope = new ArrayList<Scholar>(this.values());
		for(Scholar s: hope)
		{
			toReturn+=s.toString();
			toReturn+="/n";
		}
		
		return toReturn;
	}
}
