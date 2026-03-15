package demo.bdd.runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:target/timeline,json:target/cucumber-reports/report.json,html:target/html-reports/report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "demo.bdd,stepdefinitions")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@UI")
public class TestSuiteRunner {
}
