package com.webtrendtracker.webscraping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class AmazonScraperService {
    public String getProductPrice(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements priceElements = doc.select("#priceblock_ourprice"); // Adjust the selector according to Amazon's page structure
        if (priceElements.size() > 0) {
            Element priceElement = priceElements.get(0);
            return priceElement.text();
        }
//        return "Price not found";
        return doc.toString();
    }
}