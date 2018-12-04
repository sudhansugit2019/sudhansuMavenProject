package com.orange.hrm.runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "Features" }, glue = { "com.orange.hrm.stepDef", "com.orange.hrm.hooks" })

public class runner extends AbstractTestNGCucumberTests {

}
