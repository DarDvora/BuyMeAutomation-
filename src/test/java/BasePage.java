import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebElement getWebElement(By locator) {
        return SingletonWebDriver.chromeWebDriver().findElement(locator);
    }
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }
    public void sendKeysToElementList(int index, String text, List<WebElement> list){
        list.get(index).sendKeys(text);
    }
    public WebElement getWebElementFromList(List<WebElement> list, int index) {
        return list.get(index);
    }
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }
    public void clearElement(By locator) {
        getWebElement(locator).clear();
    }
}