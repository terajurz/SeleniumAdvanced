package commons;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.commons.TopMenuPage;
import pages.sections.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TopMenuTest extends TestBase {
    TopMenuPage topMenuPage;
    MainPage mainPage;


    @BeforeMethod
    public void testSetup() {
        topMenuPage = new TopMenuPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void shouldSearchProductWithSuccess() {

        topMenuPage.typeTextInSearchWidget(mainPage.getRandomProductName())
                .clickSubmitButton();

        assertThat(mainPage.getSearchResultName()).isEqualTo(mainPage.getRandomProductName());

    }


}
