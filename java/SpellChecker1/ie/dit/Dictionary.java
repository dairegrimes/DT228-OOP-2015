package ie.dit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;

public class Dictionary
{
	private String fileName;

	ArrayList<String> words = new ArrayList<String>();

	public Dictionary(String fileName)
	{
		loadFile(fileName);
	}

	public void loadFile(String fileName)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String current = "";
			while ((current = reader.readLine()) != null) 
			{
				words.add(current);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String[] findClosest(String toFind, int howMany)
	{
		// IMplement this method
        return null;
	} 

	public String findClosest(String toFind)
    {
        float minEd = Float.MAX_VALUE;
        String closestWord = "";
        for(String word:words)
        {
            float ed = EditDistance.MinimumEditDistance(toFind, word);
            if (ed == 0)
            {
                return word;
            }
            else
            {
                if (ed < minEd)
                {
                    minEd = ed;
                    closestWord = word;
                }
            }
        }
        return closestWord;
    }
}