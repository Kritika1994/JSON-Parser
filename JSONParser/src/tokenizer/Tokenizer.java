package tokenizer;

public class Tokenizer 
{
	private String text;
	private int pos;
	
	public Tokenizer(String text)
	{
		this.text = text;
		pos = 0;
	}
	
	public Token getNextToken()
	{
		StringBuilder b = new StringBuilder("");
		boolean alphaNumeric = false;
		
		if(!hasNextToken())
			return null;
		
		while(hasNextToken()&&(Character.isLetter(text.charAt(pos))
				|| Character.isDigit(text.charAt(pos)))){
			alphaNumeric = true;
			b.append(text.charAt(pos));
			pos++;
		}
		
		if(alphaNumeric)
			return new Token(b.toString(),(byte)1);
		
		switch(text.charAt(pos)){
			case '{':
				pos++;
				return new Token("{", (byte)2);
			case '}':
				pos++;
				return new Token("}",(byte)3);
			case '[':
				pos++;
				return new Token("[",(byte)4);
			case ']':
				pos++;
				return new Token("]",(byte)5);
			case '\"':
				pos++;
				return new Token("\"", (byte)6);
			case ':':
				pos++;
				return new Token(":", (byte) 7);
			case ',':
				pos++;
				return new Token(",", (byte) 8);
			default:
				pos++;
				return new Token("",(byte)-1);
		}
	}
	
	public boolean hasNextToken()
	{
		if(pos < text.length())
			return true;
		else
			return false;
	}
	public char getLookAhead()
	{
		return text.charAt(pos);
	}
	
	public int getPos(){return pos;}
	
}
