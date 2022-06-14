package com.mycompany.projectmanager.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.projectmanager.entities.Child;
import com.mycompany.projectmanager.web.controller.ChildController;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChildPdfByNum {
    List<Child> listChildByNum;

    public ChildPdfByNum() {
    }

    public ChildPdfByNum(List<Child> listChildByNum) {
        this.listChildByNum = listChildByNum;
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
        for (Child child : listChildByNum){
            table.addCell(child.getNumeroBeneficiaire());
            table.addCell(child.getLastNameChild());
            table.addCell(child.getFirstNameChild());
            table.addCell(child.getJourNaiss()+"/"+child.getMoisNaiss()+"/"+child.getAnneNaiss());
            table.addCell(String.valueOf(child.getGender()));
            table.addCell(child.getStatus());
        } 
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(20);


        Paragraph title = new Paragraph("Liste total des enfants", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);
        table.setWidths(new float[]{1.3f, 2f, 3f, 2f, 0.7f, 1.3f});

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);


        long allChildSize = ChildController.allChild2Size;
        long childMSize = ChildController.child2MSize;
        long childFSize = ChildController.child2FSize;
        long childSponsorSize = ChildController.child2SponsorSize;
        long childNoSponsorSize = ChildController.child2NoSponsorSize;

        Paragraph size = new Paragraph ("Enfants Total : "+allChildSize +
                "       Enfants au sexe Masculin : " +childMSize +
                "       Enfants au sexe Féminin : " +childFSize +
                "       Sponsorisé : " +childSponsorSize +
                "       Non sponsorisé : " +childNoSponsorSize );

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
