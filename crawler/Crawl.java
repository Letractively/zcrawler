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
		Crawler crawl = new Crawler("http://www.youtube.com");

		int connections = 0;

		for (String s : crawl.scrape())
		{
			crawl.setSeed(s);
			try
			{
				urls.addAll(crawl.scrape());
				connections++;
				System.out.println(s + " (" + connections + ") : " + urls.size());
			}
			catch (Exception e)
			{
				System.out.println("ERROR");
			}
		}
	}


}
