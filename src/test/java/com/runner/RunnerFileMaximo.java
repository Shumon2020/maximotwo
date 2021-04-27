package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
glue = { "com.stepdef" }, 
tags = { "@regression" },

		plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports1/report.html" }, monochrome = true

)

public class RunnerFileMaximo {

}
