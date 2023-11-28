package library.steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.pages.LibraryPage;
import library.pages.LoginPage;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import org.junit.Assert;

public class US2 {


    LibraryPage libraryPage = new LibraryPage();
    LoginPage loginPage = new LoginPage();

    String actualResult;


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);


    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        BrowserUtil.waitFor(1);
        actualResult = libraryPage.countOfBorrowedBooks.getText();

        System.out.println("actualResult = " + actualResult);


    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow where is_returned=0";

        DB_Util.runQuery(query);

        String expectedResult = DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(expectedResult,actualResult);

    }


}
