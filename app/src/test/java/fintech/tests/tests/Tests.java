package fintech.tests.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.test.uiautomator.UiObjectNotFoundException;
import fintech.tests.BaseRunner;
import fintech.tests.PageObject;

@RunWith(JUnit4.class)
public class Tests extends BaseRunner {

    private PageObject page = testApp.page;

    @Test
    public void testTrending() throws UiObjectNotFoundException {

        page.clickMenuButton();
        page.selectMenuItem("Trending");
        page.checkTitleName("com.fastaccess.github.debug:id/drawer", "android.widget.TextView", "Trending");
    }

    @Test
    public void testChangingTheme() throws UiObjectNotFoundException {
        page.clickMenuButton();
        page.selectMenuItem("Settings");
        page.selectPoint("com.fastaccess.github.debug:id/iconItemTitle", "android.widget.RelativeLayout");
        page.rightSwipeScreen("com.fastaccess.github.debug:id/pager");
        page.clickElement("com.fastaccess.github.debug:id/apply");

//не удается проверить цвет экрана с помощью ui automator
    }

    @Test
    public void testRestorePurchases() throws UiObjectNotFoundException {
        page.clickMenuButton();
        page.selectMenuItem("Restore Purchases");

//не удалось поймать intent с помощью ui automator
    }

    @Test
    public void testToast() throws UiObjectNotFoundException {
        page.clickMenuButton();
        page.scrollToItem("com.fastaccess.github.debug:id/design_navigation_view", "Send feedback");
        page.selectMenuItem("Send feedback");
        page.setTextToField("hello", "android.widget.EditText");
        page.clickElement("com.fastaccess.github.debug:id/description");
        page.checkDeviceInformation("com.fastaccess.github.debug:id/editText");
        page.clickElement("com.fastaccess.github.debug:id/submit");

//здесь должна быть проверка выскочившего тоста
    }

    @Test
    public void testAbout() throws UiObjectNotFoundException {
        page.clickMenuButton();
        page.scrollToItem("com.fastaccess.github.debug:id/design_navigation_view", "About");
        page.selectMenuItem("About");
        page.scrollToItem("com.fastaccess.github.debug:id/mal_recyclerview", "About");
        page.checkText("com.fastaccess.github.debug:id/mal_item_text", "Changelog");

//проверить иконку с помощью ui automator не получается
    }
}
