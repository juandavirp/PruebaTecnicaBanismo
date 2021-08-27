package com.sophos.banistmo.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.sophos.banistmo.stepdefinitions"},
        features = "src/test/resources/banistmo/features/banistmo.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Banistmo {
}
