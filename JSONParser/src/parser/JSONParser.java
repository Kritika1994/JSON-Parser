package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tokenizer.Token;
import tokenizer.Tokenizer;

public class JSONParser 
{
	private ArrayList<JSONObject> lis;
	private Tokenizer t;
	
	public JSONParser(String text)
	{
		lis = new ArrayList<JSONObject>();
		t = new Tokenizer(text);
		if(t.getNextToken().getType() == 2)
			lis.add(parseJSON());
	}
	
	public List<JSONObject> getObjectList()
	{
		return lis;
	}
	
	public JSONObject parseJSON()
	{
		Token tok;
		//Token tok = t.getNextToken();
			
		//if(tok.getType() != 2){
			//System.out.println("Expected {");
			//System.exit(1);
		//}
			
		
			JSONObject json = getJSONObject();
			tok = t.getNextToken();
			
			if(tok == null || tok.getType() != 3){
				System.out.println("expected }");
				System.exit(1);
			}
		
		return json;
	}
	
	public JSONObject getJSONObject()
	{
		Map<String,JSONValue> mp = new HashMap<String,JSONValue>();
		computeF(mp);
		return new JSONObject(mp);
		
	}
	
	private void computeF(Map<String, JSONValue> mp)
	{
		Token k = t.getNextToken();
		
		if(k == null || k.getType() != 6){
			System.out.println("Expected \""+" at "+t.getPos());
			System.exit(1);
		}
		
		k = t.getNextToken();
		
		if(k == null || k.getType() != 1){
			System.out.println("Key expected");
			System.exit(1);
		}
		
		String key = k.getLexeme();
		
		k = t.getNextToken();
		
		if(k == null || k.getType() != 6){
			System.out.println("Expected \""+" at "+t.getPos());
			System.exit(1);
		}
		
		k = t.getNextToken();
		
		if(k == null || k.getType() != 7){
			System.out.println("Expected :");
			System.exit(1);
		}
		
		k = t.getNextToken();
		
		if(k == null){
			System.out.println("Unexpected EOF");
			System.exit(1);
		}
		
		else if(k.getType() == 6){//string
			
			k = t.getNextToken();
			if(k == null || k.getType() != 1){
				System.out.println("Expected Value");
				System.exit(1);
			}
			
			JSONValue val = new JSONValue();
			val.value = k.getLexeme();
			val.type = 1;
			mp.put(key, val);
			
			k = t.getNextToken();
			if(k == null || k.getType() != 6){
				System.out.println("Expected \""+" at "+t.getPos());
				
				System.exit(1);
			}
		} 
		
		else if(k.getType() == 2){	//JSON Object
			JSONObject temp = parseJSON();
			JSONValue val = new JSONValue();
			val.ob = temp;
			val.type = 3;
			mp.put(key,val);
		}
		if(t.hasNextToken() && t.getLookAhead() == ','){
			t.getNextToken();
			computeF(mp);
		}
	}
}
