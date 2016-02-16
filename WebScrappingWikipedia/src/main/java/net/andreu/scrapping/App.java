package net.andreu.scrapping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Document doc=Jsoup.connect("https://ca.wikipedia.org/wiki/Llista_de_colors").get();
        Elements taula = doc.select("tbody");
        Elements files = taula.select("tr");
        
        for(int i=1; i<files.size(); i++){
        	Elements capsalera = files.get(i).select("th");
        	Elements celes = files.get(i).select("td");
        	
        	System.out.println("INSERT INTO colors (nom, colorhex, red, green, blue) VALUES (“"+capsalera.text()+"”, “"+celes.get(1).text()+"”, "+celes.get(2).text()+","+celes.get(3).text()+","+celes.get(4).text()+");");
        }
    }
}
