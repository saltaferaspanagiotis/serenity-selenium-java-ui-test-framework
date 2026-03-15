package demo.bdd.stepdefinitions;

import demo.bdd.actions.*;
import demo.bdd.configuration.SpringConfig;
import demo.bdd.configuration.TestConfig;
import demo.bdd.questions.*;
import demo.bdd.utils.ScenarioContext;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SpringConfig.class)
public class ConfigStepDefinitions extends ScenarioSteps {

    @Autowired
    protected TestConfig testConfig;

    @Autowired
    protected ScenarioContext scenarioContext;

    @Autowired
    protected AdvancedUIActionsUI advancedUIActionsUI;

    @Autowired
    protected AdvancedUIQuestionsUI advancedUIQuestionsUI;

    @Autowired
    protected FramesActionsUI framesActionsUI;

    @Autowired
    protected FramesQuestionsUI framesQuestionsUI;

    @Autowired
    protected FormsActionsUI formsActionsUI;

    @Autowired
    protected FormsQuestionsUI formsQuestionsUI;

    @Autowired
    protected PopupWindowsActionsUI popupWindowsActionsUI;

    @Autowired
    protected PopupWindowsQuestionsUI popupWindowsQuestionsUI;

    @Autowired
    protected SamplePagesActionsUI samplePagesActionsUI;

    @Autowired
    protected SamplePagesQuestionsUI samplePagesQuestionsUI;

    @Autowired
    protected WaitConditionsActionsUI waitConditionsActionsUI;

    @Autowired
    protected WaitConditionsQuestionsUI waitConditionsQuestionsUI;

    @Autowired
    protected MouseActionsUI mouseActionsUI;

    @Autowired
    protected MouseActionsQuestionsUI mouseActionsQuestionsUI;

    @Autowired
    protected KeyboardActionsUI keyboardActionsUI;

    @Autowired
    protected KeyboardActionsQuestionsUI keyboardActionsQuestionsUI;
}
