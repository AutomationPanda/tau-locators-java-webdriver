package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DuckDuckGoResultsPage extends AbstractPage {

    public final static By resultsLink = By.cssSelector("h2 a[data-testid='result-title-a'] span");

    public DuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultsLinkText(String phrase) {
        // Wait for results to appear
        getWait().until(ExpectedConditions.titleContains(phrase));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(resultsLink));

        // Get the result link texts
        List<WebElement> resultLinks = getDriver().findElements(resultsLink);
        List<String> linkTexts = new LinkedList<>();

        for (WebElement e : resultLinks) {
            linkTexts.add(e.getText());
        }

        return linkTexts;
    }
}
