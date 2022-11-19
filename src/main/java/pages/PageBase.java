package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    Select select;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }
}
