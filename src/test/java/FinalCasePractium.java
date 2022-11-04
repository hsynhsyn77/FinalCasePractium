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
    String Product = "fritöz";

    String Product2="fritöz";

    @Test(priority = 1)
    void userLogin() {

        FinalCasePractiumPOM elements = new FinalCasePractiumPOM(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elements.cookie.click();
        Log4j.info("cookie Kabul edildi.");
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(elements.input).build().perform();
        elements.login.click();
        Log4j.info("Login bilgileri girilir.");
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
        Log4j.info("Anasayfa da kullanıcı giriş işlemi yaptığı doğrulanır.");

        elements.search.sendKeys(Product);
        elements.SearchButton.click();
        Log4j.info("Satın alınacak ürün için arama yapılır.");

        wait.until(ExpectedConditions.visibilityOf(elements.productTik));
        elements.productTik.click();
        Log4j.info("Kullanıcı Ürüne gitti.");


        String newtab = driver.getWindowHandle();
        Set<String> openTab = driver.getWindowHandles();
        for (String tab : openTab) {
            if (tab.equals(newtab)) continue;
            driver.switchTo().window(tab);
        }
        Log4j.info("Arama yapılan ürün ile yeni sekmede işleme devam edilir");


        js.executeScript("arguments[0].scrollIntoView()", elements.addCart);
        js.executeScript("arguments[0].click()", elements.addCart);
        Log4j.info("Kullanıcı ürünü ilk satıcıdan sepete ekledi.");


        wait.until(ExpectedConditions.visibilityOf(elements.close2));
        elements.close2.click();

        js.executeScript("arguments[0].scrollIntoView()", elements.product2AddCart);
        js.executeScript("arguments[0].click()", elements.product2AddCart);
        Log4j.info("Farklı bir satıcıdan ürün tekrar dan sepete eklenir.");


        wait.until(ExpectedConditions.visibilityOf(elements.noRepair));
        elements.noRepair.click();
        wait.until(ExpectedConditions.visibilityOf(elements.ürünSepetteKapat));
        elements.ürünSepetteKapat.click();

        js.executeScript("window.scrollBy(0,-1200)");
        elements.shoppingCart.click();
        Log4j.info("Sepete gidilir, doğru ürünlerin seçildiği ve sepete eklendiği doğrulanır.");


        List<WebElement> addCardList = driver.findElements(By.cssSelector("[class='product_name_3Lh3t']>a"));
        for (WebElement e : addCardList) {
            Assert.assertTrue(e.getText().toLowerCase().contains("fritöz"));
            System.out.println("Product in cart = " + e.getText());
        }
        Log4j.info("Sepete gidilir, doğru ürünlerin seçildiği ve sepete eklendiği doğrulanır.");

        List<WebElement> removeCard = driver.findElements(By.xpath("//a[@class='product_delete_1zR-0']"));
        for (WebElement e : removeCard) {
            js.executeScript("arguments[0].scrollIntoView()", e);
            js.executeScript("arguments[0].click()", e);
        }
        Log4j.info("Sepetteki ürünler doğrulandıktan sonra ürünler sepetten silinir.");


        String newtab1 = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String tab1 : windows) {
            if (tab1.equals(newtab1)) continue;
            driver.switchTo().window(tab1);
        }
        Log4j.info("İlk açılan sekmeye gidilir.");

        Actions actions2 = new Actions(driver);
        actions2.moveToElement(elements.myAccount).build().perform();
        wait.until(ExpectedConditions.visibilityOf(elements.exit));
        elements.exit.click();
        Log4j.info("Kullanıcı girişinden çıkış yapılır.");
    }



    @Test(priority = 2)
    void userlessLogin() {

        FinalCasePractiumPOM elements = new FinalCasePractiumPOM(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elements = new FinalCasePractiumPOM(driver);
        wait.until(ExpectedConditions.visibilityOf(elements.homePage));
        elements.homePage.click();
        Log4j.info("Kullanıcı ana sayfaya gider.");
        wait.until(ExpectedConditions.visibilityOf(elements.search));
        elements.search.sendKeys(Product2);
        Log4j.info("Product :" + Product2);
        Log4j.info("Kullanıcı Girişi yapılmadan ürün için arama yapılır.");

        elements.SearchButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.product2Tik));
        elements.product2Tik.click();


        String anaSayfaWindows = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String id : windows) {
            if (id.equals(anaSayfaWindows)) continue;
            driver.switchTo().window(id);
        }
        Log4j.info("Arama yapılan ürün ile yeni sekmede işleme devam edilir.");

        js.executeScript("arguments[0].scrollIntoView()", elements.addCart);
        js.executeScript("arguments[0].click()", elements.addCart);
        Log4j.info("Ürün ilk açılan satıcıdan sepete eklenir.");

        wait.until(ExpectedConditions.visibilityOf(elements.ürünSepetteKapat));
        elements.ürünSepetteKapat.click();

        js.executeScript("arguments[0].scrollIntoView()", elements.product2AddCart);
        js.executeScript("arguments[0].click()", elements.product2AddCart);
        Log4j.info("Farklı bir satıcıdan ürün tekrar dan sepete eklenir.");

       wait.until(ExpectedConditions.visibilityOf(elements.noRepair));
       elements.noRepair.click();


        wait.until(ExpectedConditions.visibilityOf(elements.ürünSepetteKapat2));
        elements.ürünSepetteKapat2.click();

        js.executeScript("window.scrollBy(0,-1000)");
        elements.shoppingCart.click();
        Log4j.info("Kullanıcı sepete gider.");

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
        Log4j.info("Sepetteki ürünler doğrulandıktan sonra ürünler sepetten silinir.");


    }
}

