package com.sophos.banistmo.stepdefinitions;

import com.sophos.banistmo.abilities.ReadPdfFile;
import com.sophos.banistmo.enums.MsgError;
import com.sophos.banistmo.exceptions.ExceptionError;
import com.sophos.banistmo.questions.GetText;
import com.sophos.banistmo.tasks.Download;
import com.sophos.banistmo.tasks.GoTo;
import com.sophos.banistmo.tasks.KnowAbout;
import com.sophos.banistmo.tasks.OpenSection;
import com.sophos.banistmo.utils.Open;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

import static com.sophos.banistmo.accions.Action.waitForSecond;
import static com.sophos.banistmo.userinterface.AprenderEsFacilPage.BTN_LEGALES;
import static com.sophos.banistmo.userinterface.BanistmoHomePage.BTN_APRENDER_ES_FACIL;
import static com.sophos.banistmo.userinterface.FatcaAndCrs.BTN_PDF_FILE;
import static com.sophos.banistmo.userinterface.LegalesPage.BTN_FATCA_CRS;
import static com.sophos.banistmo.utils.Constant.FILE_PATH;
import static com.sophos.banistmo.utils.Constant.PDF_TEXT_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class BanistmoStepDefinition {

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("{string} desea ir a la página de banistmo")
    public void deseaIrALaPáginaDeBanistmo(String actorName) {
        theActorCalled(actorName).whoCan(BrowseTheWeb.with(Open.url()));
    }

    @When("Va a la seccion FATCA & CRS y descarga el archivo pdf de autocertificación unificado")
    public void vaALaSeccionFATCACRSYDescargaElArchivoPdfDeAutocertificaciónUnificado() throws IOException {
        theActorInTheSpotlight().attemptsTo(GoTo.aprenderEsfacil(BTN_APRENDER_ES_FACIL));
        theActorInTheSpotlight().attemptsTo(OpenSection.legales(BTN_LEGALES));
        theActorInTheSpotlight().attemptsTo(KnowAbout.fatcaAndCrs(BTN_FATCA_CRS));
        theActorInTheSpotlight().attemptsTo(Download.pdfFile(BTN_PDF_FILE));
        theActorInTheSpotlight().whoCan(ReadPdfFile.downloadedInPath(FILE_PATH));
        waitForSecond(5);
    }

    @Then("Valida que el titulo del archivo sea {string}")
    public void validaQueElTituloDelArchivoSea(String mensaje) {
        theActorInTheSpotlight().should(seeThat(GetText.title(PDF_TEXT_TITLE), equalTo(mensaje))
                .orComplainWith(ExceptionError.class, String.format(MsgError.MSG_ERROR_TEXT.getMsg(), mensaje,
                        GetText.title(PDF_TEXT_TITLE).answeredBy(theActorInTheSpotlight()))));
    }
}
