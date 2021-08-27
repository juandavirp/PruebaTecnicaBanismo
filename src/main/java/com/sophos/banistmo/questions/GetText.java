package com.sophos.banistmo.questions;

import com.sophos.banistmo.abilities.ReadPdfFile;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;

import static com.sophos.banistmo.utils.Constant.PDF_TEXT_TITLE;

public class GetText implements Question<String> {

    private String title;

    public GetText(String title) {
        this.title = title;
    }

    public static GetText title(String title) {
        return new GetText(title);
    }

    @SneakyThrows
    @Override
    public String answeredBy(Actor actor) {
        Boolean title = null;
        try {
            title = ReadPdfFile.as(actor).getText().contains(PDF_TEXT_TITLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (title) {
            return PDF_TEXT_TITLE;
        } else {
            return "No equal";
        }

    }

}
