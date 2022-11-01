import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCasePractiumPOM {

    public FinalCasePractiumPOM(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookie;

    @FindBy(xpath = "//*[@href='javascript:;']")
    public WebElement input;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//button[@id='btnGoogle']/div[@class='_3vX07w_kqpZqSEOOjOvSyI']")
    public WebElement google;

    @FindBy(id = "identifierId")
    public WebElement googleAccount;

    @FindBy(xpath = "//div[@id='identifierNext']//button[@type='button']/span[@class='VfPpkd-vQzf8d']")
    public WebElement go1;

    @FindBy(css = "input[name='password']")
    public WebElement password;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement go2;

    @FindBy(css = "span[class='sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq']")
    public WebElement accountTxt;

    @FindBy(css = " input[type='text']")
    public WebElement search;

    @FindBy(css = "i[class='Icon-mmozS7hAyo_kamAvO3d7 SearchBoxOld-mrtEgcTtTCASw8fiP4EG']")
    public WebElement searchBoxDelete;

    @FindBy(css = "div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement SearchButton;

    @FindBy(xpath = "(//div[@data-test-id='product-info-wrapper'])[2]")
    public WebElement productTik;

    @FindBy(xpath = "svg[width='171']")
    public WebElement ürünAdiGör;

    @FindBy(id = "addToCart")
    public WebElement addCart;


    @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement product1AddCart;

    @FindBy(css = "[data-bind] .close")
    public WebElement noRepair;

    @FindBy(css = "div[class='checkoutui-Modal-iooaV']>h1>a")
    public WebElement close;

    @FindBy(xpath = " (//button[@class='add-to-basket button small'])[2]")
    public WebElement satici2SepeteEkle;

    @FindBy(id = "shoppingCart")
    public WebElement myBasket;

    @FindBy(xpath = "(//a[@class='product_delete_1zR-0'])[1]")
    public WebElement removeCard;

    @FindBy(css = "div[class='hb-toast-notifier-container hb-toast-notifier-position-top-right']")
    public WebElement removeCardAlert;

    @FindBy(id = "myAccount")
    public WebElement myAccount;

    @FindBy(xpath = "(//li[@class='sf-OldMyAccount-qxFp0lp_7uZ6Ov82BhJu'] )[4]")
    public WebElement exit;

    @FindBy(css = "a[class='delete_product_3DFC0']>div")
    public WebElement sanalDelete;



}
