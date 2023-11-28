package library.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.pages.BasePage;
import library.pages.HomePage;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import library.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US3 {


    HomePage homePage = new HomePage();
    List<WebElement> actualResult;
    List<String> clearResult = new ArrayList<>();

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String books) {

        BrowserUtil.waitFor(1);
        homePage.booksButton.click();
        BrowserUtil.waitFor(1);

        if (Driver.getDriver().getCurrentUrl().contains("books")) {
            System.out.println("Title verification is passed");
        } else {
            System.out.println("Title verification is failed!");
        }


    }

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

        homePage.bookCategories.click();

        actualResult = Driver.getDriver().findElements(By.xpath("//select[@id='book_categories']//option"));

        actualResult.remove(0);


        for (WebElement eachLink : actualResult) {

            clearResult.add(eachLink.getText());

        }

        System.out.println("clearResult = " + clearResult);


    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        List<String> expectedResult = DB_Util.getColumnDataAsList(1);

        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(expectedResult,clearResult);


//        for (String each : expectedResult) {
//            System.out.print(each+", ");
//        }


//        for (String eachExpected : expectedResult) {
//            for (WebElement eachActual : actualResult) {
//                BrowserUtil.waitFor(1);
//                Assert.assertEquals(eachExpected, eachActual.getText());
//                BrowserUtil.waitFor(1);
//            }
//        }


    }


}
