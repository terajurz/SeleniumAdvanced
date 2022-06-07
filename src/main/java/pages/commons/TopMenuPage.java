package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#search_widget [type='text']")
    private WebElement searchWidget;

    public TopMenuPage typeTextInSearchWidget(String productName) {
        sendKeys(this.searchWidget, productName);
        return this;
    }

    @FindBy(css = "#search_widget [type='submit']")
    private WebElement submitButton;

    public TopMenuPage clickSubmitButton(){
        click(submitButton);
        return this;
    }
}
