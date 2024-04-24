package com.webtrendtracker.webscraping.controller;

// MainController.java

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public void showHtmlPage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate HTML content using Java
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Spring Boot HTML Page</title>");
        out.println("<script>");
        out.println("function validateInput(event) {");
        out.println("  var input = event.target;");
        out.println("  input.value = input.value.replace(/[^0-9]/g, '');");
        out.println("}");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to Spring Boot HTML Page</h1>");
        out.println("<form action=\"/submit\" method=\"post\">");
        out.println("<label for=\"numberInput\">Enter a Number:</label>");
        out.println("<input type=\"text\" id=\"numberInput\" name=\"numberInput\" oninput=\"validateInput(event)\">");
        out.println("<button type=\"submit\">Submit</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }



}
