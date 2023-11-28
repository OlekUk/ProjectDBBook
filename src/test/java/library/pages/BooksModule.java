package library.pages;

import library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksModule {

    public BooksModule(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li//span[text()='Books']")
    public WebElement booksModule;

    @FindBy(id ="book_categories")
    public WebElement bookCategory;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    @FindBy(name="name")
    public WebElement bookName;

    @FindBy(name="isbn")
    public WebElement isbn;

    @FindBy(name="year")
    public WebElement year;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(id="book_group_id")
    public WebElement bookCategoryDropdown;

    @FindBy(id="description")
    public WebElement description;




    public WebElement editBook(String book){
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
