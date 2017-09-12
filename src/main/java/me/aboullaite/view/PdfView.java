package me.aboullaite.view;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import me.aboullaite.model.Employee;
import me.aboullaite.model.MessageHeader;

/**
 * Created by aboullaite on 2017-02-25.
 */
public class PdfView extends AbstractPdfView {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);

    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    @Override
    protected void buildPdfDocument(final Map<String, Object> model, final Document document, final PdfWriter writer, final HttpServletRequest request,
            final HttpServletResponse response)
                    throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");
        final List emp = (List) model.get("users");
        final List messages = (List) model.get("message");
        // model.get("users");
        document.add(new Paragraph("Generated Users " + LocalDate.now()));
        document.open();

        createtoc(document, 2);
        addTitlePage(document);
        addContent(document, emp);
        addmessageContent(document, messages);
        document.close();
    }

    private void createtoc(final Document document, final int num) throws DocumentException {
        for (int i = 1; i <= num; i++) {
            final Anchor anchor1 = new Anchor("chapter" + i);
            anchor1.setReference("#Chapter" + i);
            final Paragraph paragraph1 = new Paragraph();
            paragraph1.add(anchor1);
            document.add(paragraph1);
        }
        document.newPage();
    }

    private void addContent(final Document document, final List emp) throws DocumentException {
        final int nom = 1;
        final Anchor anchor = new Anchor("Chapter" + nom, catFont);
        anchor.setName("Chapter" + nom);

        // Second parameter is the number of the chapter
        final Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        // createList(subCatPart);
        final Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createEmployeeTable(subCatPart, emp);
        paragraph.add(anchor);
        // now add all this to the document
        document.add(catPart);
        // }
    }

    private void addmessageContent(final Document document, final List<MessageHeader> messages) throws DocumentException {
        final int nom = 2;
        final Anchor anchor = new Anchor("Chapter" + nom, catFont);
        anchor.setName("Chapter" + nom);

        // Second parameter is the number of the chapter
        final Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("emp"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        // createList(subCatPart);
        final Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createMessageTable(subCatPart, messages);
        paragraph.add(anchor);
        // now add all this to the document
        document.add(catPart);
        // }
    }



    private void addTitlePage(final Document document) throws DocumentException {
        final Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Title of the document", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                (), smallBold));
        addEmptyLine(preface, 3);

        addEmptyLine(preface, 8);
        document.add(preface);
        // Start a new page
        document.newPage();

        /////////////////////////////////////////////////////////////////////////////

    }

    private void addEmptyLine(final Paragraph paragraph, final int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void createEmployeeTable(final Section subCatPart, final List<Employee> users) {
        // final List<emploEmployee> users = (List<Employee>) model.get("users");
        System.out.println(users.size());

        final PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        final Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        final PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Email Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);

        for (final Employee user : users) {
            table.addCell(user.getEmployeeEmail());
            table.addCell(user.getEmployeeFirstName());

        }

        subCatPart.add(table);

    }

    private void createMessageTable(final Section subCatPart, final List<MessageHeader> users) {
        // final List<emploEmployee> users = (List<Employee>) model.get("users");
        System.out.println(users.size());

        final PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        final Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        final PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Email ", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("message", font));
        table.addCell(cell);

        for (final MessageHeader message : users) {
            table.addCell(message.getEmail());
            table.addCell(message.getMessage());

        }

        subCatPart.add(table);

    }


}
