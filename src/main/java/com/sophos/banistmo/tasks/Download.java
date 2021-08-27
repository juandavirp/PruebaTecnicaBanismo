package com.sophos.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Download implements Task {

    private Target btnOPenPdf;


    public Download(Target btnOPenPdf) {
        this.btnOPenPdf = btnOPenPdf;
    }

    public static Performable pdfFile(Target btnPdf) {
        return Tasks.instrumented(Download.class, btnPdf);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnOPenPdf));
    }
}
