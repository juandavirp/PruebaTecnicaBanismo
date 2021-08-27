package com.sophos.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class OpenSection implements Task {

    private Target btnShowLegales;

    public OpenSection(Target btnShowLegales) {
        this.btnShowLegales = btnShowLegales;
    }

    public static Performable legales(Target btnLegales) {
        return Tasks.instrumented(OpenSection.class, btnLegales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnShowLegales));
    }
}
