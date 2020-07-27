package com.java25wro.service.emails;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java25wro.model.Order;
import com.java25wro.model.OrderedMeals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EmailService {

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    private final static String orderConfirmationURL = "https://javawro25.herokuapp.com/mail";

    public  void sendOrderConfirmationEmail(Order order) throws IOException, InterruptedException {
        Long orderId = order.getId();
        Set<OrderedMeals> orderedMeals = order.getOrderedMeals();
        String customerName = order.getCustomer().getName();
        String to = order.getCustomer().getEmail();

        //todo Email from restaurant maybe? It can't be different now because it is register email to herokuapp service.
        String from = "dariasupinska@wp.pl";

        final Context ctx = new Context();
        ctx.setVariable("name", customerName);
        ctx.setVariable("orderId", orderId);
        ctx.setVariable("orderedMeals", orderedMeals);
        final String htmlBody = thymeleafTemplateEngine.process("email-orders.html", ctx);
        System.out.println(htmlBody);
        //sendEmail(from, to, htmlBody);
    }

    public  void sendEmail(String from, String to, String htmlBody) throws IOException, InterruptedException {

        Map<String, Object> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);
        params.put("content", htmlBody);
        String inputJson = new ObjectMapper().writeValueAsString(params);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .uri(URI.create(orderConfirmationURL))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<Void> response =
                client.send(request, HttpResponse.BodyHandlers.discarding());

        System.out.println("response status code: "+response.statusCode());

    }
}

