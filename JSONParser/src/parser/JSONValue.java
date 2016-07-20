package parser;

import java.util.ArrayList;

public class JSONValue 
{
	String value;
	ArrayList<JSONValue> array;
	JSONObject ob;
	int type; //1 string 2 array 3 object
	
	public String toString()
	{
		if(type == 1)
			return value;
		else if(type == 3)
			return ob.toString();
		else
			return "null";
	}
}
