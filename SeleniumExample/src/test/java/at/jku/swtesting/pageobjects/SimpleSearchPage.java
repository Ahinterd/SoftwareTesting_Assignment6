package at.jku.swtesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleSearchPage {
    protected WebDriver driver;

    @FindBy(name = "q")
    WebElement searchField;
    @FindBy(css = "#L2AGLb") WebElement confirmButton;
    public ResultsPage searchFor(String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
        searchField.submit();
        return new ResultsPage(driver);
    }
}
