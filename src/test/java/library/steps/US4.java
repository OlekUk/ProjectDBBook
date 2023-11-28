package library.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.pages.HomePage;
import library.utility.BrowserUtil;
import library.utility.DB_Util;
import library.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US4 {

    HomePage homePage = new HomePage();
    List<WebElement> actualResult;

    List<String> clearResult = new ArrayList<>();

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String searchedWorld) {

        homePage.search.sendKeys(searchedWorld);

    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        homePage.editButton.click();

        BrowserUtil.waitFor(1);

        actualResult = Driver.getDriver().findElements(By.xpath("//input[@type='text']"));

        for (WebElement element : actualResult) {
            clearResult.add(element.getAttribute("value"));
        }

        System.out.println("clearResult = " + clearResult);


    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        List<String> expectedResult = new ArrayList<>();

        String query = "select name from books where name='Book Borrow 2'";
        DB_Util.runQuery(query);

        expectedResult.add(DB_Util.getFirstRowFirstColumn());

        String query1 = "select isbn from books where name='Book Borrow 2'";
        DB_Util.runQuery(query1);

        expectedResult.add(DB_Util.getFirstRowFirstColumn());

        String query2 = "select year from books where name='Book Borrow 2'";
        DB_Util.runQuery(query2);

        expectedResult.add(DB_Util.getFirstRowFirstColumn());

        String query3 = "select author from books where name='Book Borrow 2'";
        DB_Util.runQuery(query3);

        expectedResult.add(DB_Util.getFirstRowFirstColumn());



        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(expectedResult,clearResult);



    }



}
