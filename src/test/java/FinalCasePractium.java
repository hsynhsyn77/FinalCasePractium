import Utility.GenelWebdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;


public class FinalCasePractium extends GenelWebdriver {
    String email = "hepsibuka@gmail.com";
    String password = "Hb123456";
    String Product = "fritözler";

    @Test(priority = 1)
    void userLogin() {

        FinalCasePractiumPOM elements = new FinalCasePractiumPOM(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elements.cookie.click();
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(elements.input).build().perform();
        elements.login.click();

        wait.until(ExpectedConditions.visibilityOf(elements.google));
        elements.google.click();

        elements.googleAccount.sendKeys(email);
        Log4j.info("Email :" + email);
        elements.go1.click();

        wait.until(ExpectedConditions.visibilityOf(elements.password));
        elements.password.sendKeys(password);
        Log4j.info("password :" + password);

        elements.go2.click();
        wait.until(ExpectedConditions.visibilityOf(elements.accountTxt));
        Assert.assertEquals(elements.accountTxt.getText(), "Hesabım", "Karşılaştırma Sonucu : ");

        elements.search.sendKeys(Product);
        elements.SearchButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.productTik));
        elements.productTik.click();

        String newtab = driver.getWindowHandle();
        Set<String> openTab = driver.getWindowHandles();
        for (String tab : openTab) {
            if (tab.equals(newtab)) continue;
            driver.switchTo().window(tab);
        }

        js.executeScript("arguments[0].scrollIntoView()", elements.addCart);
        js.executeScript("arguments[0].click()", elements.addCart);

        wait.until(ExpectedConditions.visibilityOf(elements.close));
        elements.close.click();

        js.executeScript("arguments[0].scrollIntoView()", elements.product1AddCart);
        js.executeScript("arguments[0].click()", elements.product1AddCart);

        wait.until(ExpectedConditions.visibilityOf(elements.noRepair));
        elements.noRepair.click();
        wait.until(ExpectedConditions.visibilityOf(elements.close));
        elements.close.click();
        js.executeScript("window.scrollBy(0,-1000)");
        elements.myBasket.click();

        List<WebElement> addCardList = driver.findElements(By.cssSelector("[class='product_name_3Lh3t']>a"));
        for (WebElement e : addCardList) {
            Assert.assertTrue(e.getText().toLowerCase().contains("fritöz"));
            System.out.println("Product in cart = " + e.getText());
        }

        List<WebElement> removeCard = driver.findElements(By.xpath("//a[@class='product_delete_1zR-0']"));
        for (WebElement e : removeCard) {
            js.executeScript("arguments[0].scrollIntoView()", e);
            js.executeScript("arguments[0].click()", e);
        }

        String newtab1 = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String tab1 : windows) {
            if (tab1.equals(newtab1)) continue;
            driver.switchTo().window(tab1);
        }

        Actions actions2 = new Actions(driver);
        actions2.moveToElement(elements.myAccount).build().perform();
        wait.until(ExpectedConditions.visibilityOf(elements.exit));
        elements.exit.click();
    }

    @Test(priority = 2)
    void userlessLogin() {

        FinalCasePractiumPOM elements = new FinalCasePractiumPOM(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elements = new FinalCasePractiumPOM(driver);
        elements.searchBoxDelete.click();
        wait.until(ExpectedConditions.visibilityOf(elements.search));
        elements.search.sendKeys(Product);
        Log4j.info("Product :" + Product);
        elements.SearchButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.productTik));
        elements.productTik.click();

        String anaSayfaWindows = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String id : windows) {
            if (id.equals(anaSayfaWindows)) continue;
            driver.switchTo().window(id);
        }

        js.executeScript("arguments[0].scrollIntoView()", elements.product1AddCart);
        js.executeScript("arguments[0].click()", elements.product1AddCart);

        wait.until(ExpectedConditions.visibilityOf(elements.noRepair));
        elements.noRepair.click();
        wait.until(ExpectedConditions.visibilityOf(elements.close));
        elements.close.click();
        elements.satici2SepeteEkle.click();

        wait.until(ExpectedConditions.visibilityOf(elements.noRepair));
        elements.noRepair.click();
        wait.until(ExpectedConditions.visibilityOf(elements.close));
        elements.close.click();

        js.executeScript("window.scrollBy(0,-1000)");
        elements.myBasket.click();

        List<WebElement> sepet = driver.findElements(By.cssSelector("[class='product_name_3Lh3t']>a"));
        for (WebElement e : sepet) {
            Assert.assertTrue(e.getText().toLowerCase().contains("fritöz"));
            System.out.println("Product in cart = " + e.getText());
        }

        List<WebElement> removeCard = driver.findElements(By.xpath("//a[@class='product_delete_1zR-0']"));
        for (WebElement e : removeCard) {
            js.executeScript("arguments[0].scrollIntoView()", e);
            js.executeScript("arguments[0].click()", e);
        }

    }
}

