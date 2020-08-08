package com.java25wro.service.order;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.model.File;
import com.java25wro.model.Order;
import com.java25wro.utilities.GoogleDriveService;
import com.java25wro.utilities.QRCodeGenerator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private GoogleDriveService googleDriveService;



    public void saveOrderToGoogleDrive(Order order) throws Exception {
        ByteArrayInputStream pdfBytes = convertFileToStream(createPDF(order));
        saveFileToGoogleDrive(pdfBytes, order);
    }

    public void saveFileToDisk(Order order) throws Exception {
        PDDocument document = createPDF(order);
        String filename = generateFileName(order);
        document.save(filename);
        document.close();
    }

    private void saveFileToGoogleDrive(ByteArrayInputStream inputStream, Order order) throws IOException {

        File fileMetadata = new File();
        fileMetadata.setName(generateFileName(order));
        fileMetadata.setMimeType("application/pdf");

        File file = googleDriveService.getDriveService().files().create(fileMetadata, new InputStreamContent(null,inputStream))
                .setFields("id")
                .execute();
    }

    private static PDDocument createPDF(Order order) throws Exception {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 11);
        contentStream.newLineAtOffset(100,600);
        contentStream.showText("Order number: "+ order.getId());
        contentStream.endText();


        byte[] pngBytes = QRCodeGenerator.generateQRCodePNG(order.getUuid());

        PDImageXObject image =  PDImageXObject.createFromByteArray(document, pngBytes, "QRcode.png");
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        return document;

    }

    private String generateFileName(Order order) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat currentDateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
        String date = currentDateFormatter.format(today);
        return "Order "+order.getId()+ " " +date + ".pdf";
        //todo should be "date" passed to argument?
    }


    private ByteArrayInputStream convertFileToStream(PDDocument document) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        document.save(outputStream);
        document.close();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return inputStream;

    }

}
