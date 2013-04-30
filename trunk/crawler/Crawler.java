package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler
{
	private List<String> urls;
	
	private String seed;
	
	public Crawler(String seed)
	{
		urls = new ArrayList<String>();
		
		this.seed = seed;
	}
	
	/**
	 * Searches a web page for all "href" attributes and returns their contents.
	 * 
	 * @param url The url to search (must be http:// or https://)
	 * @return A list of urls found on the page
	 * @throws IOException if there was a problem connecting to the specified web page
	 * @throws InvalidAttributeValueException if {@link url} is empty or null
	 */
	public final List<String> scrape() throws InvalidAttributeValueException, IOException
	{
		if (seed == "" || seed == null) {	throw new InvalidAttributeValueException();	}
		List<String> urls = new ArrayList<String>();
		Document doc = Jsoup.connect(seed).get();
		Elements elems = doc.getElementsByAttribute("href");

		for(Element e : elems)
		{
			if (e.attr("abs:href") != "")
				urls.add(e.attr("abs:href"));
		}
		
		return urls;
	}
}
	
