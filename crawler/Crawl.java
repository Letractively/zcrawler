package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class Crawl
{


	public static void main(String[] args) throws InvalidAttributeValueException, IOException
	{
		List<String> urls = new ArrayList<String>();
		Crawler crawl = new Crawler("http://www.edline.net/pages/ParkwayCentralHS");
		int connections = 0;

		for (String s : crawl.scrape())
		{
			crawl.setSeed(s);
			try
			{
				for (String ss : crawl.scrape())
				{
					if (!urls.contains(ss))
						urls.add(ss);
				}
				connections++;
				System.out.println(connections + ":\t" + urls.size() + " \t" + s);
			}
			catch (Exception e)
			{
				System.out.println("ERROR");
			}
		}
	}


}
