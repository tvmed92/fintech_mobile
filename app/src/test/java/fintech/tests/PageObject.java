package fintech.tests;

import android.os.Build;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PageObject {
    private UiDevice device;
    private String packageName;

    public PageObject(UiDevice device, String packageName) {
        this.device = device;
        this.packageName = "com.fastaccess.github.debug";
    }

    public void clickMenuButton() throws UiObjectNotFoundException {
        UiObject button = device.findObject(new UiSelector()
                .descriptionContains("Navigate up"));
        button.clickAndWaitForNewWindow();
    }

    public void selectMenuItem(String menuItemSelector) throws UiObjectNotFoundException {
        UiObject menuItem = device.findObject(new UiSelector().text(menuItemSelector));
        menuItem.clickAndWaitForNewWindow();
    }

    public void clickElement(String id) throws UiObjectNotFoundException {
        UiObject button = device.findObject(new UiSelector()
                .resourceId(id));
        button.clickAndWaitForNewWindow();
    }

    public void checkTitleName(String id, String className, String title) throws UiObjectNotFoundException {
        UiObject titleName = device.findObject(new UiSelector()
                .resourceId(id)
                .instance(0)
                .childSelector(new UiSelector().className(className)));
        assertEquals(title, titleName.getText());
    }

    public void selectPoint(String id, String className) throws UiObjectNotFoundException {
        UiObject theme = device.findObject(new UiSelector()
                .className(className)
                .instance(0)
                .childSelector(new UiSelector()
                        .resourceId(id)));
        theme.clickAndWaitForNewWindow();
    }

    public void rightSwipeScreen(String id) throws UiObjectNotFoundException {
        UiObject swipe = device.findObject(new UiSelector().resourceId(id));
        swipe.swipeRight(20);
    }

    public void setTextToField(String text, String className) throws UiObjectNotFoundException {
        UiObject field = device.findObject(new UiSelector().className(className));
        field.setText(text);
    }

    public void checkDeviceInformation(String id) throws UiObjectNotFoundException {
        UiObject deviceInf = device.findObject(new UiSelector().resourceId(id));
        String textInfo = deviceInf.getText();
        assertTrue(textInfo.contains(Build.MANUFACTURER));
        assertTrue(textInfo.contains(Build.BRAND));
    }

    public void scrollToItem(String id, String text) throws UiObjectNotFoundException {
        UiScrollable scrollToItem = new UiScrollable(new UiSelector().resourceId(id));
        scrollToItem.scrollTextIntoView(text);
    }

    public void checkText(String id, String itemText) throws UiObjectNotFoundException {
        UiObject text = device.findObject(new UiSelector()
                .resourceId(id));
        assertEquals(itemText, text.getText());
    }
}
