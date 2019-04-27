package fintech.tests;

import org.junit.After;
import org.junit.Before;

import androidx.test.uiautomator.UiObjectNotFoundException;

public class BaseRunner {

    public TestApplication testApp;

    @Before
    public void setUp() throws UiObjectNotFoundException {
        testApp = new TestApplication();
    }

    @After
    public void tearDown() {
        testApp.close();
    }
}
