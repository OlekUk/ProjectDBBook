package library.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.pages.BasePage;
import library.pages.BooksModule;
import library.pages.DashBoardPage;
import library.pages.LoginPage;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import library.utility.Driver;
import org.junit.Assert;

import java.util.List;

public class US03  {

    LoginPage loginPage = new LoginPage();
    BooksModule booksModule = new BooksModule();

    DashBoardPage dashBoardPage = new DashBoardPage();

    List<String> actualBookCategory;


    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String books) {

        dashBoardPage.navigateModule(books);
    }

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

        actualBookCategory =   BrowserUtil.getAllSelectOptions(booksModule.bookCategory);
        actualBookCategory.remove(0);

        System.out.println("actualBookCategory = " + actualBookCategory);

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        String query = "select name from book_categories";
        DB_Util.runQuery(query);

        List <String> expectedBookCategory = DB_Util.getColumnDataAsList(1);
        System.out.println("expectedBookCategory = " + expectedBookCategory);


        Assert.assertEquals(expectedBookCategory,actualBookCategory);





    }


}
