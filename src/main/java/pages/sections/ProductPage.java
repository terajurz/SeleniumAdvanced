package pages.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ("#quantity_wanted"))
    private WebElement quantity;

    public ProductPage setQuantity(String number) {
        sendKeysWithClear(quantity, number);
        return this;
    }

    @FindBy(css = (".add button"))
    private WebElement addToCartButton;

    public ProductPage clickAddToCartButton() {
        click(addToCartButton);
        return this;
    }

    @FindBy(css = (".cart-content-btn .btn-primary"))
    private WebElement proceedToCheckoutButton;

    public ProductPage clickproceedToCheckoutButton() {
        waitToBeVisible(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
        return this;
    }

    @FindBy(css = (".product-line-info .label"))
    private WebElement productLabel;

    public String getProductLabel(){
        waitToBeVisible(productLabel);
        return productLabel.getText();
    }

    @FindBy(css = ("[name='product-quantity-spin']"))
    private WebElement productQuantity;

    public String getProductQuantity(){
        return productQuantity.getAttribute("value");
    }

    @FindBy(css = (".current-price"))
    private WebElement productPrice;

    public String getProductPrice(){
        return productPrice.getText();
    }

    @FindBy(css = ("span.product-price"))
    private WebElement cartPrice;

    public String getCartPrice(){
        return cartPrice.getText();
    }

    @FindBy(css = (".remove-from-cart"))
    private WebElement removeFromCartButton;

    public ProductPage clickRemoveFromCartButton(){
        click(removeFromCartButton);
        waitToBeInvisible(removeFromCartButton);
        return this;
    }
}

