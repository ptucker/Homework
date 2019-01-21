 import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.IIOException;
import java.io.IOException;

public class FileReader {}
   //  https://stats.nba.com/teams/traditional/?sort=W_PCT&dir=-1
/*
   private static String regex = "[0-9]";
    public static void main(String[] args) {

        try {
            Document  doc = Jsoup.connect("https://stats.nba.com/teams/traditional/?sort=W_PCT&dir=-1").get();

            Elements stats = doc.select(regex);

            for(Element stat : stats) {
                System.out.println(stat.id());
            }
        } catch(IOException e) {
           System.out.println(e.getCause());
        }
    }
}
*/