//Aetizaz Sameer
//Github: aetizazsameer/wordsearch/Main.java
//Converted to .exe using Launch4j 3.12

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
    	int x=0,y=0;
		String str, word;
		String anotherWord, anotherWordsearch;
		Scanner scanner = new Scanner(System.in);
		WordSearch wordsearch;
   	
   		do{
   			System.out.println("How many letters wide is the word search?");
			try
			{
				x=scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error: The width received was not a positive integer.");
				scanner.close();
				System.exit(1);
			}
			if(x<1)
			{
				System.out.println("Error: The width received was not a positive integer.");
				scanner.close();
				System.exit(1);
			}
			System.out.println("How many letters tall is the word search?");
			try
			{
				y=scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error: The height received was not a positive integer.");
				scanner.close();
				System.exit(1);
			}
			if(y<1)
			{
				System.out.println("Error: The height received was not a positive integer.");
				scanner.close();
				System.exit(1);
			}
			System.out.println("Enter every character in the word search exactly, reading from left to right and top to bottom, without spaces.");
			str=scanner.next();
			if(str.length()<x*y)
			{
				System.out.println("Error: Too few letters were entered.");
				scanner.close();
				System.exit(1);
			}
			if(str.length()>x*y)
			{
				System.out.println("Error: Too many letters were entered.");
				scanner.close();
				System.exit(1);
			}
			wordsearch = new WordSearch(x, y, str.toUpperCase());
			
			do{
				System.out.println("What word would you like to find in the word search?");
				word=scanner.next();
				wordsearch.find(word);
				System.out.println("Would you like to find another word in this word search?");
				anotherWord=scanner.next();
				if(!(stringNo(anotherWord)||stringYes(anotherWord)))
				{
					System.out.println("Error: The response received was not a variation of yes or no.");
					scanner.close();
					System.exit(1);
				}
			}while(stringYes(anotherWord));
			
			System.out.println("Would you like to solve another word search?");
			anotherWordsearch=scanner.next();
			if(stringNo(anotherWordsearch))
			{
				System.out.println("Exiting program...");
				scanner.close();
				System.exit(0);
			}
		}while(stringYes(anotherWordsearch));
	}
    
	private static boolean stringYes(String str)
	{
		return str.equalsIgnoreCase("YES")||str.equalsIgnoreCase("Y");
	}
	private static boolean stringNo( String str)
	{
		return str.equalsIgnoreCase("NO")||str.equalsIgnoreCase("N");
	}
}