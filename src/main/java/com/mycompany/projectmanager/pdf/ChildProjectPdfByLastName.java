package com.mycompany.projectmanager.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.projectmanager.entities.Child;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChildProjectPdfByLastName {
    List<Child> listChildProjectByLastName;

    public ChildProjectPdfByLastName() {

    }

    public ChildProjectPdfByLastName(List<Child> listChildProjectByLastName) {
        this.listChildProjectByLastName = listChildProjectByLastName;
    }


//    private void writeTableHeader(PdfPTable table){
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(Color.gray);
//        cell.setPadding(8);
//
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        font.setColor(Color.WHITE);
//
//        cell.setPhrase(new Phrase("Nom", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet1", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet2", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet3", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet4", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet5", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet6", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet7", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet8", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet9", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet10", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet11", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Projet12", font));
//        table.addCell(cell);
//
//    }
//
//    private void writeTableData(PdfPTable table){
//        for (Child child : listChildProjectByLastName){
//            table.addCell(child.getLastNameChild()+" " +child.getFirstNameChild());
//            table.addCell(child.getProject1());
//            table.addCell(child.getProject2());
//            table.addCell(child.getProject3());
//            table.addCell(child.getProject4());
//            table.addCell(child.getProject5());
//            table.addCell(child.getProject6());
//            table.addCell(child.getProject7());
//            table.addCell(child.getProject8());
//            table.addCell(child.getProject9());
//            table.addCell(child.getProject10());
//            table.addCell(child.getProject11());
//            table.addCell(child.getProject12());
//        }
//    }
//
//    public void export(HttpServletResponse response) throws DocumentException, IOException {
//        Document document = new Document(PageSize.A3);
//
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//
//        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        font.setColor(Color.BLACK);
//        font.setSize(20);
//
//
//        Paragraph title = new Paragraph("Liste des projets des enfants", font);
//        title.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(title);
//
//        PdfPTable table = new PdfPTable(13);
//        table.setWidthPercentage(100);
//        table.setSpacingBefore(20);
////        table.setWidths(new float[]{1.3f, 2f, 3f, 2f, 0.7f, 1.3f});
//
//        writeTableHeader(table);
//        writeTableData(table);
//
//        document.add(table);
//        document.close();
//    }
    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(8);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nom", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 1", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Proje t2", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 3", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 4", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 5", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 6", font));
        table.addCell(cell);


    }

    private void writeTableHeader2(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(8);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nom", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 7", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 8", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 9", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 10", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 11", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Projet 12", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table){
        for (Child child : listChildProjectByLastName){
            table.addCell(child.getLastNameChild()+" " +child.getFirstNameChild());
            table.addCell(child.getProject1());
            table.addCell(child.getProject2());
            table.addCell(child.getProject3());
            table.addCell(child.getProject4());
            table.addCell(child.getProject5());
            table.addCell(child.getProject6());
        } 
    }

    private void writeTableData2(PdfPTable table){
        for (Child child : listChildProjectByLastName){
            table.addCell(child.getLastNameChild()+" " +child.getFirstNameChild());
            table.addCell(child.getProject7());
            table.addCell(child.getProject8());
            table.addCell(child.getProject9());
            table.addCell(child.getProject10());
            table.addCell(child.getProject11());
            table.addCell(child.getProject12());
        }
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(20);


        Paragraph title = new Paragraph("Liste des projets des enfants", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);

        PdfPTable table2 = new PdfPTable(7);
        table2.setWidthPercentage(100);
        table2.setSpacingBefore(20);
//        table.setWidths(new float[]{1.3f, 2f, 3f, 2f, 0.7f, 1.3f});

        writeTableHeader(table);
        writeTableData(table);

        writeTableHeader2(table2);
        writeTableData2(table2);

        document.add(table);
        document.add(table2);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
        String currentDateTime = dateFormat.format(new Date());
        Paragraph dateEdit = new Paragraph ("Editer le : "+currentDateTime);
        dateEdit.setAlignment(Paragraph.ALIGN_BOTTOM);
        dateEdit.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(dateEdit);

        document.close();
    }
}
