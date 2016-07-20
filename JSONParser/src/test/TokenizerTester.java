package test;

import tokenizer.Tokenizer;

public class TokenizerTester 
{
	public static void main(String args[])
	{
		Tokenizer t = new Tokenizer("{\"name\":\"prachi\",\"hobies\":"
				+ "[\"cricket\",\"sleeping\"]}");
		while(t.hasNextToken())
			System.out.println(t.getNextToken());
	}
}
