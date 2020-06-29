//Aetizaz Sameer
//Github: aetizazsameer/wordsearch/src/WordSearch.java
//Converted to .exe using Launch4j 3.12

public class WordSearch
{
	private String[][] m;
	private int x, y;
	private boolean isFound;
	
	public WordSearch(int x, int y, String str)
	{
		m = new String[x][y];
		this.x = x;
		this.y = y;
		int i=0;
		
		for(int r=0; r<y; r++)
			for(int c=0; c<x; c++)
				m[r][c]=str.charAt(i++)+"";
	}
	
	public void find(String w)
	{
		w=w.toUpperCase();
		isFound=false;
		for(int r=0; r<m.length; r++)
			for(int c=0; c<m[0].length; c++)
				if(m[r][c].charAt(0)==w.charAt(0))
					checkAll(w, r, c);
		if(!isFound)
			System.out.print("Word "+w.toLowerCase()+" was not found in the word search. ");
	}
	
	public void findLocation(String w) //fixed handling of 1-letter words via findLocation in v1.2
	{
		w=w.toUpperCase();
		isFound=false;
		for(int r=0; r<m.length; r++)
			for(int c=0; c<m[0].length; c++)
				if(m[r][c].charAt(0)==w.charAt(0))
				{
					isFound=true;
					System.out.print("Character "+w.toLowerCase()+" was found at ("+(c+1)+", "+(x-r)+"). ");
				}
		if(!isFound)
			System.out.print("Character "+w.toLowerCase()+" was not found in the word search. ");
	}
	
	public void checkAll(String w, int r, int c)
	{
		if(checkLeft(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found to the left of ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkRight(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found to the right of ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkUp(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found up from ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkDown(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found down from ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkDiagUpLeft(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found up and to the left of ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkDiagUpRight(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found up and to the right of ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkDiagDownLeft(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found down and to the left of ("+(c+1)+", "+(x-r)+"). ");
		}
		if(checkDiagDownRight(w, r, c))
		{
			isFound=true;
			System.out.print("Word "+w.toLowerCase()+" was found down and to the right of ("+(c+1)+", "+(x-r)+"). ");
		}
	}
	
	public boolean checkLeft(String w, int r, int c)
	{
		if(c-(w.length()-1)<0)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkLeft(w.substring(1), r, c-1);
		}
		return false;
	}
	
	public boolean checkRight(String w, int r, int c)
	{
		if(c+(w.length()-1)>=x)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkRight(w.substring(1), r, c+1);
		}
		return false;
	}

	public boolean checkUp(String w, int r, int c)
	{
		if(r-(w.length()-1)<0)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkUp(w.substring(1), r-1, c);
		}
		return false;
	}

	public boolean checkDown(String w, int r, int c)
  	{
  		if(r+(w.length()-1)>=y)
  			return false;
  		
  		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkDown(w.substring(1), r+1, c);
		}
  		return false;
	}
	
	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		if(c-(w.length()-1)<0 || r-(w.length()-1)<0)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkDiagUpLeft(w.substring(1), r-1, c-1);
		}
		return false;
	}
	
	public boolean checkDiagUpRight(String w, int r, int c)
	{
		if(c+(w.length()-1)>=x || r-(w.length()-1)<0)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkDiagUpRight(w.substring(1), r-1, c+1);
		}
		return false;
	}
	
	public boolean checkDiagDownLeft(String w, int r, int c)
	{
		if(c-(w.length()-1)<0 || r+(w.length()-1)>=y)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkDiagDownLeft(w.substring(1), r+1, c-1);
		}
		return false;
	}
	
	public boolean checkDiagDownRight(String w, int r, int c)
	{
		if(c+(w.length()-1)>=x || r+(w.length()-1)>=y)
			return false;
		
		if(w.charAt(0)==m[r][c].charAt(0))
		{
			if(w.length()==1)
				return true;
			return checkDiagDownRight(w.substring(1), r+1, c+1);
		}
		return false;
	}
}
