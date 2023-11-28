package library.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.pages.LibraryPage;
import library.pages.LoginPage;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import library.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US02 {

    LoginPage loginPage = new LoginPage();
    String actualBorrowedBooks;
    LibraryPage libraryPage = new LibraryPage();

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {

        loginPage.login(librarian);

    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

      BrowserUtil.waitFor(3);

     actualBorrowedBooks =  libraryPage.borrowedCountBook.getText();

        System.out.println("actualBorrowedBooks = " + actualBorrowedBooks);

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow where is_returned = 0";
        DB_Util.runQuery(query);

        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooks);

    }



}
