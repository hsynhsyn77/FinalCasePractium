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

    @FindBy(id = "i0")
    public WebElement productTik;

    @FindBy(id="i1")
    public WebElement product2Tik;

    @FindBy(xpath = "(//h3[@type='comfort'])[2]")
    public WebElement productTik2;

    @FindBy(css = "div[class='sf-OldHeader-FpTYTu4Avgrxt5ZgRSEL']>div>div")
    public WebElement homePage;

    @FindBy(xpath = "svg[width='171']")
    public WebElement ürünAdiGör;

    @FindBy(id = "addToCart")
    public WebElement addCart;


    @FindBy(xpath = "(//h3[@class='moria-ProductCard-fHiOwt eaNrp sqw67vyonfl'])[2]")
    public WebElement product1AddCart;

    @FindBy(xpath = "//i[@class='close']")
    public WebElement noRepair;

    @FindBy(css = "a[class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']>svg")
    public WebElement close2;

    @FindBy(css = "div[class='checkoutui-Modal-iooaV']>h1>a")
    public WebElement close;

    @FindBy(xpath = " (//button[@class='add-to-basket button small'])[1]")
    public WebElement product2AddCart;

    @FindBy(css = "a[class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']>svg")
    public WebElement ürünSepetteKapat;

    @FindBy(css = "a[class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']>svg")
    public WebElement ürünSepetteKapat2;

    @FindBy(id = "shoppingCart")
    public WebElement shoppingCart;

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
