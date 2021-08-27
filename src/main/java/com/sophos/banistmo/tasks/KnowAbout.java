package com.sophos.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class KnowAbout implements Task {

    private Target btnShowFatcaAndCrs;

    public KnowAbout(Target btnShowFatcaAndCrs) {
        this.btnShowFatcaAndCrs = btnShowFatcaAndCrs;
    }

    public static Performable fatcaAndCrs(Target btnFatcaCrs) {
        return Tasks.instrumented(KnowAbout.class, btnFatcaCrs);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnShowFatcaAndCrs));
    }
}
