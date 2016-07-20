package test;

import java.util.List;

import parser.JSONObject;
import parser.JSONParser;

public class WithoutArrayTester 
{
	public static void main(String args[])
	{
		JSONParser ob = new JSONParser("{\"name\":\"prachi\",\"age\":\"25\","
				+ "\"bfriend\":{\"name\":\"nishant\",\"age\":\"26\"}}");
		List<JSONObject> l = ob.getObjectList();
		for(JSONObject i:l)
			System.out.println(i);
	}
}
