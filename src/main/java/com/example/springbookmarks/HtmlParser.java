package com.example.springbookmarks;

import com.example.springbookmarks.models.Bookmark;
import com.example.springbookmarks.repositories.BookmarkRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// TODO make it singleton
// Should really be a singleton class
public class HtmlParser {

    private static BookmarkRepository bookmarkRepository;

    static public void getDocFromHtml(){
      try{
          Document doc = Jsoup.connect("https://ebooks.webflow.com/ebook/web-design-101").get();
          doc.select("meta").forEach(System.out::println);
      } catch (IOException e){
          e.printStackTrace();
      }
    };

    static public void getHtmlNaitve(){
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL("https://ebooks.webflow.com/ebook/web-design-101");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String contentType = con.getHeaderField("Content-Type");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setInstanceFollowRedirects(false);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content);
            con.disconnect();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println(content);
        }

    }

    static public void parseHtmlFromFile(){
        File input = new File("src/main/resources/static/bookmarks.html");
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements datatables = doc.getElementsByTag("DT");
            for (Element datatable : datatables) {
                Elements link = datatable.getElementsByTag("a");
                String linkHref = link.attr("href");
                String linkText = link.text();
                try {
                    if((linkText != null && linkText != "" && linkText.length() < 80)
                            && (linkHref != null && linkHref != "" && linkHref.length() < 300)){
                        // System.out.println(linkText.length());
                        bookmarkRepository.save(new Bookmark(linkText, linkHref));
                    }
                } catch (NullPointerException ex){
                    ex.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
