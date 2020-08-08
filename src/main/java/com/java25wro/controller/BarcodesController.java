package com.java25wro.controller;


import com.java25wro.service.order.OrderService;
import com.java25wro.utilities.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
public class BarcodesController {

    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/generate/{barcode}", produces= MediaType.IMAGE_PNG_VALUE)
    public BufferedImage QRBarcode(@PathVariable("barcode") String barcode) throws  Exception {
        return QRCodeGenerator.generateQRCodeBufferedImage(barcode);
    }

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/save/{orderID}")
    public void savePdfOrder(@PathVariable Long orderID) throws Exception {
        orderService.createPDF();
    }*/
}
