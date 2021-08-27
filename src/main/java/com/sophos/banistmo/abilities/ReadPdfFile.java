package com.sophos.banistmo.abilities;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.IOException;

public class ReadPdfFile implements Ability {

    private final String filePath;
    PdfReader pdfReader;
    private String pdfText;

    public ReadPdfFile(String filePath) throws IOException {
        this.filePath = filePath;
        this.pdfReader = new PdfReader(filePath);
    }

    public static ReadPdfFile downloadedInPath(String filePath) throws IOException {
        return new ReadPdfFile(filePath);
    }

    public static ReadPdfFile as(Actor actor) {
        return actor.abilityTo(ReadPdfFile.class);
    }

    public String getText() throws IOException {

        int pagesNumber = pdfReader.getNumberOfPages();

        StringBuilder pdfText = new StringBuilder();

        for (int i = 1; i <= pagesNumber; i++) {

            pdfText.append(PdfTextExtractor.getTextFromPage(pdfReader, i));

        }
        return pdfText.toString();
    }

}
