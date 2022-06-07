package sections;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.commons.TopMenuPage;
import pages.sections.MainPage;
import pages.sections.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductTest extends TestBase {
    TopMenuPage topMenuPage;
    MainPage mainPage;

    ProductPage productPage;

    @BeforeMethod
    public void testSetup() {
        topMenuPage = new TopMenuPage(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }


    @Test
    public void shouldAddAndDeleteProductFromCart() {
        mainPage.clickFirstProductOnMainPage();
        productPage.setQuantity("3")
                .clickAddToCartButton()
                .clickproceedToCheckoutButton();

        assertThat(productPage.getProductLabel()).isEqualTo("HUMMINGBIRD T-SHIRT");
        assertThat(productPage.getProductQuantity()).isEqualTo("3");
        assertThat(productPage.getProductPrice()).isEqualTo("$19.12");
        assertThat(productPage.getCartPrice()).isEqualTo("$57.36");

        productPage.clickRemoveFromCartButton();

        assertThat(mainPage.getCartOverview()).isEqualTo("There are no more items in your cart");



    }
}
