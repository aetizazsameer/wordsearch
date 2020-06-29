//Aetizaz Sameer
//Github: aetizazsameer/wordsearch/src/Main.java
//Converted to .exe using Launch4j 3.12

import java.util.*;
import java.util.concurrent.*;

public class Main
{
	public static void main(String[] args) throws InterruptedException
    {
		int x=0,y=0;
		String str, word;
		String wordQuery, wordsearchQuery; //renamed from anotherWord and anotherWordsearch in v1.1
		Scanner scanner = new Scanner(System.in);
		WordSearch wordsearch;
   	
   		System.out.println("Aetizaz Sameer\nGithub: aetizazsameer/wordsearch\n"); //credits implemented in v1.1
   	
   		do{
   			System.out.println("How many letters wide is the word search? (Format: positive integer)"); //formats implemented in v1.1
			try
			{
				x=scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error: The width received was not a positive integer. Restarting program..."); //"Restarting program..." notice implemented in v1.1
				end(scanner);
			}
			if(x<1)
			{
				System.out.println("Error: The width received was not a positive integer. Restarting program...");
				end(scanner);
			}
			System.out.println("How many letters tall is the word search? (Format: positive integer)");
			try
			{
				y=scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error: The height received was not a positive integer. Restarting program...");
				end(scanner);
			}
			if(y<1)
			{
				System.out.println("Error: The height received was not a positive integer. Restarting program...");
				end(scanner);
			}
			System.out.println("Enter every character in the word search exactly, reading from left to right and top to bottom, without spaces. (Format: "+(x*y)+" standard characters, unspaced)");
			str=scanner.next().toUpperCase();	//toUpperCase moved from wordsearch initialization in v1.1
			if(str.length()<x*y)
			{
				System.out.println("Error: Too few letters were entered. Restarting program...");
				end(scanner);
			}
			if(str.length()>x*y)
			{
				System.out.println("Error: Too many letters were entered. Restarting program...");
				end(scanner);
			}
			if(str.length()==1) //fixed handling of one-letter word searches in v1.2
			{
				System.out.println("Error: This is a one-letter word search! Restarting program...");
				end(scanner);
			}
			wordsearch = new WordSearch(x, y, str);
			
			do{
				System.out.println("What word would you like to find in the word search? (Format: single word)");
				word=scanner.next();
				if(word.length()==1)				//if-else block and call to findLocation implemented in v1.2
					wordsearch.findLocation(word);
				else wordsearch.find(word);
				System.out.println("Would you like to find another word in this word search? (Format: Y/N)");
				wordQuery=scanner.next();
				if(!(stringNo(wordQuery)||stringYes(wordQuery)))
				{
					System.out.println("Error: The response received was not a variation of yes or no. Restarting program...");
					end(scanner);
				}
			}while(stringYes(wordQuery));
			
			System.out.println("Would you like to solve another word search? (Format: Y/N)");
			wordsearchQuery=scanner.next();
			if(stringNo(wordsearchQuery))
			{
				System.out.println("Exiting program...");
				scanner.close();
				TimeUnit.SECONDS.sleep(2);
				System.exit(0);
			}
			else if(!stringYes(wordsearchQuery)) //fixed handling of unexpected response in v1.2
			{
				System.out.println("Error: The response received was not a variation of yes or no. Restarting program...");
				end(scanner);
			}
		}while(stringYes(wordsearchQuery));
	}
    
	private static boolean stringYes(String str)
	{
		return str.equalsIgnoreCase("YES")||str.equalsIgnoreCase("Y");
	}
	private static boolean stringNo(String str)
	{
		return str.equalsIgnoreCase("NO")||str.equalsIgnoreCase("N");
	}
	private static void end(Scanner scanner) throws InterruptedException //end method implemented with parameter scanner in v1.2
	{
		scanner.close();
		TimeUnit.SECONDS.sleep(2); //fixed immediate closing of console window and not displaying error messages on per-method basis in v1.1
		System.exit(1);
	}
}
