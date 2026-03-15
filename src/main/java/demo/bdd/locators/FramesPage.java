package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

/**
 * Locators for the Frame Interactions page (frames.html).
 * <p>
 * ASSUMPTION: This page embeds inner.html inside an iframe.
 * The iframe is selected by tag name (first iframe found on the page).
 * The inner_button is the only interactive element inside the iframe.
 * <p>
 * If frames.html uses a different iframe structure (e.g. a frameset, different src,
 * or a named frame), update INNER_FRAME and INNER_BUTTON accordingly.
 */
public class FramesPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/frames.html";

    // Main document heading — used to verify the user is back in the main context
    public static final By PAGE_HEADING = By.xpath("//a[text()='The Playground']");

    // iframe on the page
    public static final By INNER_FRAME_1 = By.id("frame1");
    public static final By INNER_FRAME_2 = By.id("frame2");
    public static final By INNER_FRAME_3 = By.id("frame3");
    public static final By INNER_FRAME_4 = By.id("frame4");

    // Button inside the iframe
    public static final By FRAME_1_BUTTON = By.id("click_me_1");
    public static final By FRAME_2_BUTTON = By.id("click_me_2");
    public static final By FRAME_4_BUTTON = By.id("click_me_4");

    public static By getInnerButton(int frameIndex) {
        switch (frameIndex) {
            case 1:
                return FramesPage.FRAME_1_BUTTON;
            case 2:
                return FramesPage.FRAME_2_BUTTON;
            case 4:
                return FramesPage.FRAME_4_BUTTON;
            default:
                throw new IllegalArgumentException("Invalid frame index: " + frameIndex);
        }
    }
}
