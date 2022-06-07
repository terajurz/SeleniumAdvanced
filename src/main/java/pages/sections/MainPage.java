package pages.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h3.product-title")
    private List<WebElement> product;

    public String getRandomProductName() {
        String randomProductName =  getRandomElement(product).getText();
        return randomProductName;
    }

    @FindBy(css = ("#js-product-list .h3.product-title"))
private WebElement searchResult;

    public String getSearchResultName(){
        return searchResult.getText();
    }

  public MainPage clickFirstProductOnMainPage(){
        click(product.get(0));
        return this;
  }

    @FindBy(css = (".no-items"))
    private WebElement cartOverview;

    public String getCartOverview(){
        return cartOverview.getText();
    }
}
