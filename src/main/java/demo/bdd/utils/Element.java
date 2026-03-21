package demo.bdd.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public static void simulateHtml5DragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        String js =
                "var src = arguments[0], tgt = arguments[1];" +
                        "function dispatch(el, type, transfer) {" +
                        "  var e = new DragEvent(type, {bubbles:true, cancelable:true, dataTransfer:transfer});" +
                        "  el.dispatchEvent(e);" +
                        "}" +
                        "var dt = new DataTransfer();" +
                        "dispatch(src, 'dragstart', dt);" +
                        "dispatch(tgt, 'dragenter', dt);" +
                        "dispatch(tgt, 'dragover',  dt);" +
                        "dispatch(tgt, 'drop',      dt);" +
                        "dispatch(src, 'dragend',   dt);";
        ((JavascriptExecutor) driver).executeScript(js, source, target);
    }
}
