package com.sophos.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class GoTo implements Task {

    private Target btnAprenderEsFacil;

    public GoTo(Target btnAprenderEsFacil) {
        this.btnAprenderEsFacil = btnAprenderEsFacil;
    }

    public static Performable aprenderEsfacil(Target btnAprenderEsFacil) {
        return Tasks.instrumented(GoTo.class, btnAprenderEsFacil);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnAprenderEsFacil));
    }
}
