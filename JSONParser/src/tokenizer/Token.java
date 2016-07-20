package tokenizer;

public class Token 
{
	private String lexeme;
	private byte type;
	
	public Token(String lexeme, byte type)
	{
		this.lexeme = lexeme;
		this.type = type;
	}

	public String getLexeme() 
	{
		return lexeme;
	}

	public void setLexeme(String lexeme) 
	{
		this.lexeme = lexeme;
	}

	public byte getType() 
	{
		return type;
	}

	public void setType(byte type) 
	{
		this.type = type;
	}
	
	public String toString()
	{
		return lexeme+" "+type;
	}
	
}
