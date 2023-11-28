package library.pages;

import library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryPage {

public LibraryPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

 @FindBy(xpath = "//div//h2[@id='borrowed_books']")
    public WebElement borrowedCountBook;
}
