package library.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import library.pages.BooksModule;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US04 {

    String globalName;
    BooksModule booksModule =  new BooksModule();

    List<String> expectedResult;
    List<String> actualResult;

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        globalName = bookName;


    booksModule.searchInput.sendKeys(bookName, Keys.ENTER);

    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {

   BrowserUtil.waitForClickablility(booksModule.editBook(globalName),5).click(); ;

    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        String query = "select b.name, b.isbn,b.year,b.author,bc.name category,b.description from books b join book_categories bc on b.book_category_id = bc.id where b.name ='Book Borrow 2'";
        DB_Util.runQuery(query);

        expectedResult = DB_Util.getRowDataAsList(1);
        System.out.println("expectedResult = " + expectedResult);

        actualResult = new ArrayList<>();

        BrowserUtil.waitFor(2);
        actualResult.add(booksModule.bookName.getAttribute("value"));
        BrowserUtil.waitFor(2);
        actualResult.add(booksModule.isbn.getAttribute("value"));
        BrowserUtil.waitFor(2);
        actualResult.add(booksModule.year.getAttribute("value"));
        BrowserUtil.waitFor(2);
        actualResult.add(booksModule.author.getAttribute("value"));
        BrowserUtil.waitFor(4);
        Select select = new Select(booksModule.bookCategoryDropdown);
        actualResult.add(select.getFirstSelectedOption().getText());
        BrowserUtil.waitFor(4);
        actualResult.add(booksModule.description.getAttribute("value"));

        System.out.println("actualResult = " + actualResult);


        Assert.assertEquals(expectedResult,actualResult);


    }




}
