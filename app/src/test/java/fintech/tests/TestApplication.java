package fintech.tests;

import android.content.Context;
import android.content.Intent;

import java.util.Objects;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

public class TestApplication {

    private UiDevice device;
    public PageObject page;

    TestApplication() throws UiObjectNotFoundException {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

        String packageName = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getPackageName();
        Context context = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext();
        Intent intent = Objects.requireNonNull(context.getPackageManager()
                .getLaunchIntentForPackage(packageName))
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        device.pressHome();
        device.findObject(new UiSelector().description("Apps")).clickAndWaitForNewWindow();
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.setAsHorizontalList();
        device.findObject(new UiSelector().packageName(packageName))
                .clickAndWaitForNewWindow();

        page = new PageObject(device, packageName);
    }

    void close() {
        device.pressHome();
    }
}
