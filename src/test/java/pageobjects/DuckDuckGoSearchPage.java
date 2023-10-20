package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DuckDuckGoSearchPage extends AbstractPage {

    public final static By searchInput = By.id("searchbox_input");
    public final static By searchButton = By.xpath("//button[@aria-label='Search']");

    public DuckDuckGoSearchPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        getDriver().get("https://www.duckduckgo.com");
    }

    public void search(String phrase) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        getDriver().findElement(searchInput).sendKeys(phrase);
        getDriver().findElement(searchButton).click();
    }
}
