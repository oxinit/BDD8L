package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;


public class DefinitionsSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    LoginRegistrationPage loginRegistrationPage;
    AmazonBasicsPage amazonBasicsPage;
    EssentialsForGamersPage essentialsForGamersPage;
    ProductPage productPage;
   private String dataTransferString="init";
    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @When("User clicks 'All' button popup element")
    public void clickAllListPopupOpener() {
        homePage.clickAllListPopupOpener();
    }
    @And("User clicks 'Sing in' button from popup panel")
    public void userClicksSingInButtonFromPopupPanel() {
        homePage.waiterForPopUpPanel();
        homePage.clickSignInFromPopupAllOpenerButton();
    }
    @And("User checks 'Sign in' label visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginRegistrationPage=pageFactoryManager.getLoginRegistrationPage();
        loginRegistrationPage.isVisibleSignInLabel();
    }
    @Then("User fills email field with {string}")
    public void userFillsEmailFieldWithKeyword(final String email) {
        loginRegistrationPage.fillEmailField(email);
    }
    @And("User click 'Continue' button")
    public void userClicksContinueButton() {
        loginRegistrationPage.clickContinueButton();
    }

    @Then("User must see error box popup")
    public void userMustSeeErrorBoxPopup() {loginRegistrationPage.isVisibleErrorBox();
    }

    @And("User checks error Text are {string}")
    public void userCheckErrorTextAreErrorText(final String errorMessage) {
        assertEquals(errorMessage,loginRegistrationPage.getTextFormErrorMassageWithEmailInput());
    }

    @Then("User clicks left arrow button on widget below search")
    public void userClicksLeftArrowButtonOnWidgetBelowSearch() {
        homePage.clickCarouselWidgetButtonLeft();
    }

    @And("User checks does widget changed image")
    public void userCheckDoesWidgetChangedImage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselWidgetImg2());
        assertFalse(homePage.isVisibleCarouselWidgetImg());
    }

    @Then("User clicks right arrow button")
    public void userClicksRightArrowButton() {
        homePage.clickCarouselWidgetButtonRight();
    }
    @And("User checks does widget have original image")
    public void userCheckDoesWidgetSameImage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselWidgetImg());
        assertTrue(homePage.isVisibleCarouselWidgetImg());
    }

    @When("User clicks on image of for home category")
    public void userClickOnImageOfForHomeCategory() {
        homePage.waiterForCategoryImgButtonHome();
        homePage.clickImgCategoryForHomeButton();
    }

    @And("User clicks on first from list")
    public void userClickOnFirstFromList() {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.waiterForFirstElementProduct();
        amazonBasicsPage.clickFirstElementProduct();
    }

    @Then("User clicks add to cart button")
    public void userClickAddToCartButton() throws InterruptedException {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.clickAddToCartButton();
    }

    @And("User checks does product{string}match")
    public void userCheckDoesProductAddedToCart(String label) {
        amazonBasicsPage.waiterProductAddedToCartInscription();
        assertTrue(amazonBasicsPage.isVisibleProductAddedToCartInscription());
        assertEquals(amazonBasicsPage.getTextProductAddedToCartInscription(),label);
    }

    @When("User fills search field with {string}")
    public void userFillSearchFieldWithSearchText(String searchtext) {
        homePage.fillSearchField(searchtext);
    }

    @Then("User clicks find button")
    public void userClickFindButton() {
        homePage.clickSearchFieldFindButton();
    }

    @And("User clicks on second element from list")
    public void userClickOnSecondElementFromList() {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.waiterForFirstElementProduct();
        amazonBasicsPage.clickSecondElementProduct();
    }

    @When("User clicks on widget below search")
    public void userClickOnWidgetBelowSearch() {
        homePage.clickCarouselWidgetForGamers();
    }

    @And("user musts see inscription Featured Categories")
    public void userMustSeeInscription() {
       essentialsForGamersPage=pageFactoryManager.getEssentialsForGamersPage();
       essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(essentialsForGamersPage.isInscriptionContainsFeaturedCategories());
    }

    @Then("user clicks on chairs category")
    public void userClickOnChairsCategory() {
        essentialsForGamersPage.clickChairsCategory();
    }

    @And("user starting add first {int} elements to cart and get back to{string}")
    public void userStartingAddFewElementsToCart(final int j,final String url) {int i=0;
        while (i!=j){
            essentialsForGamersPage.clickProductElement(i);
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

            essentialsForGamersPage.clickAddToCartButton();

            amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
            amazonBasicsPage.waiterProductAddedToCartInscription();
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            essentialsForGamersPage.openChairsForGamersPage(url);
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            i++;
        }
    }

    @Then("User checks {string} of products in cart")
    public void userChekAmountOfProductsInCart(final String amount) {
        assertEquals(essentialsForGamersPage.getQuantityFromCartIconWith(),amount);
    }

    @And("User checks visibility of product image")
    public void userChekVisibilityOfProductImage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.isVisibleProductImage();
    }

    @And("User checks visibility of product price")
    public void userChekVisibilityOfProductPrice() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        productPage.isVisibleProductBaseCurrentPrice();
        dataTransferString= productPage.getTextProductBaseCurrentPrice();
        softAssert.assertEquals("%",dataTransferString);
    }

    @And("User checks does product price match to price in cart")
    public void userChekDoesProductPriceMatchToPriceInCart() throws InterruptedException {
        productPage=pageFactoryManager.getProductPage();
        assertEquals(dataTransferString,productPage.getTextCartCurrentPrice());

    }

    @And("User checks in Stock Inscription")
    public void userChekInStockInscription() throws InterruptedException {

        productPage.isVisibleInStockInscription();
    }

    @Then("User checks query generated {string}")
    public void userCheckQueryGenerated(final String query) {
        assertTrue( homePage.isQueryContainSearchKeyWords(query));

    }

    @When("User checks help button visibility")
    public void userChekHelpButtonVisibility() {
        homePage.isVisibleHelpButtonOnBottomOfHomePage();
    }

    @Then("User clicks help button")
    public void userClickHelpButton() {
       homePage.clickHelpButton();
    }

    @And("User checks Help Category Boxes visibility")
    public void userCheckHelpCategoryBoxesVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isVisibleHelpCategoryBox();

    }

    @Then("User clicks Returns&Refunds category")
    public void userClickReturnsRefundsCategory() {
        homePage.clickHelpCategoryBoxFirstElement();
    }

    @And("User checks Sign in box visibility")
    public void userFindOutLoginPage() {
        loginRegistrationPage= pageFactoryManager.getLoginRegistrationPage();
       assertTrue(loginRegistrationPage.isVisibleSignInLabel2());
    }

    @When("User clicks language button")
    public void userClickLanguageButton() {
        homePage.clickLanguageButton();
        homePage.waiterForLanguageChangeBox();
    }


    @Then("User clicks Spanish language check box")
    public void userClickSpanishLanguageCheckBox() {
        homePage.clickEspanolLanguageCheckBox();
    }

    @And("User checks inscription nearby")
    public void userChekInscriptionNearby() {
        assertTrue(homePage.doesInscriptionMatchLanguage());
    }

    @Then("User clicks Deutsch language check box")
    public void userClickDeutschLanguageCheckBox() {
        homePage.clickDeutschlLanguageCheckBox();
    }

    @And("User checks inscription according to language")
    public void userCheckInscriptionAccordingToLanguage() {
        assertTrue(homePage.doesInscriptionMatchLanguageDeutsch());
    }

    @And("User returns to English language using check box")
    public void userReturnsToEnglishLanguageUsingCheckBox() {
        homePage.clickEnglishLanguageCheckBox();
    }

    @Then("User clicks Save Changes button")
    public void userClickConfirmButton() {
        homePage.clickSaveChangesForLanguageBox();
        
    }

    @And("User cheks main page inscriptions for English language")
    public void userChekMainPageInscriptionsForEnglishLanguage() {

        assertTrue(homePage.doesLanguageButtonInscriptionEnglish());
    }

    @Then("User checks does cart empty")
    public void userChecksDoesCartEmpty() {
        essentialsForGamersPage=pageFactoryManager.getEssentialsForGamersPage();
        assertEquals( essentialsForGamersPage.getQuantityFromCartIconWith(),"0");
    }

    @And("User change delivery country")
    public void userChangeDeliveryCountry() throws InterruptedException {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickDeliveryCountryButton();
    }
}
