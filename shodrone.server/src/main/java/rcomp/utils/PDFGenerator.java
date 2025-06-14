package rcomp.utils;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PDFGenerator {
    public static byte[] createPdfFromText(String content) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDFont font = PDType1Font.HELVETICA;
            float fontSize = 12;
            contentStream.setFont(font, fontSize);
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 750);

            float maxWidth = PDRectangle.A4.getWidth() - 2 * 50;

            String cleanedContent = content.replaceAll("[\\r\\u0000-\\u001F&&[^\\n\\t]]", "");

            for (String line : cleanedContent.split("\n")) {
                if (line.trim().isEmpty()) {
                    contentStream.newLine();
                    continue;
                }
                List<String> wrappedLines = wrapText(line, font, fontSize, maxWidth);
                for (String wrappedLine : wrappedLines) {
                    contentStream.showText(wrappedLine);
                    contentStream.newLine();
                }
            }

            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            return baos.toByteArray();
        }
    }

    private static List<String> wrapText(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
        List<String> lines = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();
        for (String word : text.split(" ")) {
            String testLine = lineBuilder.length() == 0 ? word : lineBuilder + " " + word;
            float width = font.getStringWidth(testLine) / 1000 * fontSize;
            if (width > maxWidth) {
                lines.add(lineBuilder.toString());
                lineBuilder = new StringBuilder(word);
            } else {
                if (lineBuilder.length() > 0) lineBuilder.append(" ");
                lineBuilder.append(word);
            }
        }
        if (lineBuilder.length() > 0) {
            lines.add(lineBuilder.toString());
        }
        return lines;
    }
}
