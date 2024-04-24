package com.webtrendtracker.webscraping.controller;

import com.webtrendtracker.webscraping.service.AmazonScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class ProductPriceController {
    @Autowired
    private AmazonScraperService amazonScraperService;

    //http://localhost:8080/product-price/{productId}
    @GetMapping("/product-price/{productId}")
    public String getProductPrice(@PathVariable String productId) {
        //https://www.amazon.in/Bhairav-Store-Furniture-Cushion-Outdoor/dp/B0BRCPK9WL?th
//        String url = "https://www.amazon.com/dp/" + productId;
        String url = "https://www.amazon.in/Bhairav-Store-Furniture-Cushion-Outdoor/dp/" + productId;
        try {
            return amazonScraperService.getProductPrice(url);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while fetching price";
        }
    }
}