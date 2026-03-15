package demo.bdd.actions;

import demo.bdd.locators.PopupWindowsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PopupWindowsActionsUI extends PageObject {

    public String navigateToPopupWindowsPage() {
        openAt(PopupWindowsPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(PopupWindowsPage.OPEN_WINDOW_1));
        return getDriver().getWindowHandle();
    }

    public String openWindow(String windowName, String originalWindowHandle) {
        if ("New Window 1".equals(windowName)) {
            $(PopupWindowsPage.OPEN_WINDOW_1).click();
        } else {
            $(PopupWindowsPage.OPEN_WINDOW_2).click();
        }
        return waitForNewWindowAndStore(originalWindowHandle);
    }

    public void switchToNewWindow(String newWindowHandle) {
        getDriver().switchTo().window(newWindowHandle);
    }

    public void switchBackToOriginalWindow(String originalWindowHandle) {
        getDriver().switchTo().window(originalWindowHandle);
    }

    public void clickButtonInNewWindow() {
        String currentUrl = getDriver().getCurrentUrl();
        assert currentUrl != null;
        if (currentUrl.contains("frame2.html")) {
            $(PopupWindowsPage.WINDOW_1_BUTTON).click();
        } else {
            $(PopupWindowsPage.WINDOW_2_BUTTON).click();
        }
    }

    private String waitForNewWindowAndStore(String originalWindowHandle) {
        Wait.forNumberOfWindowsToBe(getDriver(), 2);
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(originalWindowHandle)) {
                return handle;
            }
        }
        throw new RuntimeException("New window did not open as expected");
    }
}
