import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Haiku 
{
	public static void checkLines(String[] lines)
	{	
		for(int i = 0; i < lines.length - 2; i++)
		{
			boolean firstLine = false;
			boolean secondLine = false;
			boolean thirdLine = false;
			
			firstLine = fiveSyllables(lines[i]);
			
			if(firstLine == true)
			{
				secondLine = sevenSyllables(lines[i+1]);
				
				if(secondLine == true)
				{
					thirdLine = fiveSyllables(lines[i+2]);
				}
			}
			
			if(firstLine == true && secondLine == true && thirdLine == true)
			{
				System.out.println(lines[i]);
				System.out.println(lines[i+1]);
				System.out.println(lines[i+2]);
			}
		}
	}
	
	public static boolean fiveSyllables(String line)
	{
		boolean numSyl = false;
		Scanner scan = new Scanner(line);
		int count = 0;
		String word;
		char[] vowels = {'a','e','i','o','u'};
		
		while(scan.hasNext())
		{
			word = scan.next();
			
			for(int i = 0; i < word.length(); i++)
			{
				if(word.charAt(i) =='a' || word.charAt(i) =='e' || word.charAt(i) =='i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' )
				{
					count++;
				}
				if(word.charAt(i) == 'e' && i == word.length()-1)
				{
					count--;
					if(word.equals("the") || word.equals("be") || word.equals("me"))
					{
						count++;
					}
				}
				if(word.charAt(i) == 'y' && i != 0)
				{
					count++;
					for(int j = 0; j < vowels.length; j++)
					{
						if(word.charAt(i) == 'y' && word.charAt(i-1) == vowels[j])
						{
							count--;
						}
					}
				}
			}
		}
		if(count == 5)
		{
			numSyl = true;
		}
		
		return numSyl;
		
	}
	
	public static boolean sevenSyllables(String line)
	{
		boolean numSyl = false;
		Scanner scan = new Scanner(line);
		int count = 0;
		String word;
		char[] vowels = {'a','e','i','o','u'};
		
		while(scan.hasNext())
		{
			word = scan.next();
			
			for(int i = 0; i < word.length(); i++)
			{
				if(word.charAt(i) == 'a' || word.charAt(i) =='e' || word.charAt(i) =='i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' )
				{
					count++;
				}
				if(word.charAt(i) == 'e' && i == word.length()-1)
				{
					count--;
				}
				if(word.equals("the") || word.equals("be") || word.equals("me"))
				{
					count++;
				}
				if(word.charAt(i) == 'y' && i != 0)
				{
					count++;
					for(int j = 0; j < vowels.length; j++)
					{
						if(word.charAt(i) == 'y' && word.charAt(i-1) == vowels[j])
						{
							count--;
						}
					}
				}
			}
		}
		
		if(count == 7)
		{
			numSyl = true;
		}
		
		return numSyl;
		
	}

	public static void main(String[] args) 
	{
		String[] lines;
		File file = new File("C:\\Users\\Tyler\\Desktop\\Assignments\\Software Engineering\\Book.txt");
		Scanner scanFile;
		String fileString = "";

		try
		{
			scanFile = new Scanner(file);
			while(scanFile.hasNextLine())
			{
				fileString = fileString + scanFile.nextLine();
		
			}
			lines = fileString.split("[!?.,;:]");
		
			checkLines(lines);
		} 
		catch (FileNotFoundException e) 
		{
			
			System.out.println("File not found");
		}
	}

}
