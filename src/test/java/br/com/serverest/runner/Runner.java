package br.com.serverest.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/serverest.feature", glue = "br.com.serverest.steps", plugin = { "pretty",
		"html:target/cucumber" })
public class Runner {


}
