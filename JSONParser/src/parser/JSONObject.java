package parser;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class JSONObject 
{
	private Map<String,JSONValue> pair;
	
	public JSONObject(Map<String,JSONValue> pair)
	{
		this.pair = pair;
	}

	public Map<String, JSONValue> getPair() 
	{
		return pair;
	}

	public void setPair(Map<String, JSONValue> pair) 
	{
		this.pair = pair;
	}
	
	public String toString()
	{
		String res = "{\n";
		Iterator<Map.Entry<String, JSONValue>> it = pair.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, JSONValue> ob = it.next(); 
			res = res+ob.getKey()+":"+ob.getValue().toString()+"\n";
		}
		return res+"}\n";
	}
	
	
}
