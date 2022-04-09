import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class ImageUtils {
    private static String getOriginalPrntscUrl(String prntscURL) throws IOException {
        URLConnection getOriginalURL = null;
        try {
            //get host Image URL
            Document document = Jsoup.connect(prntscURL).get();
            Elements images = document.select("img#screenshot-image");
            String originalURL = images.attr("src");

            //If the link is an Igmur link, it may be that the link was shortened
            if (originalURL.toLowerCase().contains("imgur.com")){
                URL inputURL = new URL(originalURL);
                getOriginalURL = inputURL.openConnection();
                getOriginalURL.getHeaderFields();
                originalURL = getOriginalURL.getURL().toString();
            }

            return originalURL;

        } catch(MalformedURLException e) {
            return null;
        } catch(IOException ioe) {
            return null;
        }
    }
    //https://stackoverflow.com/questions/26535320/check-if-image-url-exists
    private static Boolean testImageURL(String url) {
        if (url == null) {
            return false;
        }
        if (url.contains("removed.png")) {
            return false;
        }
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            if (image != null) {
                return true;
            } else {
                return false;
            }
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
    private static String getURL() {
        Random rnd = new Random();
        String[] abc = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String url = "https://prnt.sc/";
        for(int i = 0; i < 6;  ++i) {
            url = url + abc[rnd.nextInt(abc.length)];
        }
        return url;
    }
    public static String[] getValidURL()  {
        String validURL = "";
        String originalURL = "";
        int loops = 0;
        int maxLoops = 3;
        boolean looping = true;
        try {
            do {
                loops += 1;
                if (loops > maxLoops){
                    validURL = "something went wrong";
                    originalURL = "https://avatars.githubusercontent.com/u/102855037?v=4";
                    looping = false;
                }
                else {
                    validURL = getURL();
                    originalURL = getOriginalPrntscUrl(validURL);
                }
            } while (!testImageURL(originalURL) || !looping);
        } catch (IOException e) {
            validURL = "something went wrong";
            originalURL = "https://avatars.githubusercontent.com/u/102855037?v=4";
        }
        return new String[]{validURL, originalURL};
    }
}
