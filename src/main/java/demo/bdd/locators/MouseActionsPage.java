package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class MouseActionsPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/mouse_events.html";

    public static final By CLICK_AREA = By.id("click_area");
    public static final By CLICK_TYPE = By.id("click_type");
    public static final By CLICK_X = By.id("click_x");
    public static final By CLICK_Y = By.id("click_y");

    public static final By DROPDOWN_BTN = By.cssSelector(".dropbtn");
    public static final By DD_JAVA = By.id("dd_java");
    public static final By DD_PYTHON = By.id("dd_python");
    public static final By DD_JAVASCRIPT = By.id("dd_javascript");
    public static final By HOVER_VALIDATE = By.id("hover_validate");

    // HTML5 drag and drop elements — identified by their event handler attributes
    public static final By DRAGGABLE_ELEMENT = By.cssSelector("[draggable='true']");
    public static final By DROP_ZONE = By.cssSelector("[ondrop]");
    public static final By DROP_SUCCESS_TEXT = By.xpath("//*[contains(text(),'Drop is successful!')]");
}
