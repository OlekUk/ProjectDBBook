package library.pages;

import library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Books")
    public WebElement booksButton;

    @FindBy(xpath = "//select[@id='book_categories']")
    public WebElement bookCategories;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(xpath = "//a[@onclick='Books.edit_book(16567)']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement bookYear;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement bookName;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;


}
