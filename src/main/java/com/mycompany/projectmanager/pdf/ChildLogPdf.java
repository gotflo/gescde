package com.mycompany.projectmanager.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.projectmanager.entities.Child_Log;
import com.mycompany.projectmanager.service.Child_LogService;
import com.mycompany.projectmanager.web.controller.Child_LogController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChildLogPdf {
    List<Child_Log> listChildLogByNum;
    private Child_LogService childLogService;

    public ChildLogPdf() {
    }

    public ChildLogPdf(List<Child_Log> listChildLogByNum) {
        this.listChildLogByNum = listChildLogByNum;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(8);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("N° Bénéficiaire", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Prénoms", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date de naissance", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Genre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table){
        for (Child_Log child : listChildLogByNum){
            table.addCell(child.getNumeroBeneficiaireLog());
            table.addCell(child.getLastNameChildLog());
            table.addCell(child.getFirstNameChildLog());
            table.addCell(child.getJourNaissLog()+"/"+child.getMoisNaissLog()+"/"+child.getAnneNaissLog());
            table.addCell(String.valueOf(child.getGenderLog()));
            table.addCell(child.getStatusLog());
        } 
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(20);


        Paragraph title = new Paragraph("Liste total des enfants sortis", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);
        table.setWidths(new float[]{1.3f, 2f, 3f, 2f, 0.7f, 1.3f});

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);




        long allChildLogSize = Child_LogController.allChildLogSize;
        long childLogMSize = Child_LogController.childLogMSize;
        long childLogFSize = Child_LogController.childLogFSize;
        long childLogSponsorSize = Child_LogController.childLogSponsorSize;
        long childLogNoSponsorSize = Child_LogController.childLogNoSponsorSize;

        Paragraph size = new Paragraph ("Enfants sortis : "+allChildLogSize +
                "       Enfants au sexe Masculin : " +childLogMSize +
                "       Enfants au sexe Féminin : " +childLogFSize +
                "       Sponsorisé : " +childLogSponsorSize +
                "       Non sponsorisé : " +childLogNoSponsorSize );

        size.setAlignment(Paragraph.ALIGN_BOTTOM);
        size.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(size);



        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
        String currentDateTime = dateFormat.format(new Date());
        Paragraph dateEdit = new Paragraph ("Editer le : "+currentDateTime);
        dateEdit.setAlignment(Paragraph.ALIGN_BOTTOM);
        dateEdit.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(dateEdit);


        document.close();
    }
}
