package com.mycompany.projectmanager.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.projectmanager.entities.Activity;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityPdf {
    List<Activity> listActivitys;

    public ActivityPdf() {
    }

    public ActivityPdf(List<Activity> listActivitys) {
        this.listActivitys = listActivitys;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("N°", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Désignation", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Déscription", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table){
        for (Activity activity : listActivitys){
            table.addCell(String.valueOf(activity.getIdActivity()));
            table.addCell(activity.getNameActivity());
            table.addCell(activity.getDescriptionActivity());
            table.addCell(activity.getDayActivity()+"/"+activity.getMonthActivity());
            table.addCell(String.valueOf(activity.isFinish()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(18);


        Paragraph title = new Paragraph("Liste des Actitées annuel", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{0.4f, 3f, 5f, 0.7f, 0.7f});

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);




        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
        String currentDateTime = dateFormat.format(new Date());
        Paragraph dateEdit = new Paragraph ("Editer le : "+currentDateTime);
        dateEdit.setAlignment(Paragraph.ALIGN_BOTTOM);
        dateEdit.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(dateEdit);

        document.close();
    }
}
