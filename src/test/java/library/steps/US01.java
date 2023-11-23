package library.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.utility.DB_Util;
import org.junit.Assert;

import java.util.List;


public class US01 {

    String actualUserCount;
    List<String> actualDataTable;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.runQuery("select * from users;");
        System.out.println("Work HOOK");

    }


    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
      String query = "select count(id) from users";
        DB_Util.runQuery(query);

       actualUserCount = DB_Util.getFirstRowFirstColumn();

        System.out.println("actualUserCount = " + actualUserCount);


    }


    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        String query = "select count (distinct id) from users";
        DB_Util.runQuery(query);

        String expectedUserCount = DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedUserCount = " + expectedUserCount);

        Assert.assertEquals(expectedUserCount,actualUserCount);

    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        String query = "select * from users";
        DB_Util.runQuery(query);

     actualDataTable = DB_Util.getAllColumnNamesAsList();

        System.out.println("actualColumnResult = " + actualDataTable);


    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedDataTable) {
        System.out.println("expectedDataTable = " + expectedDataTable);

        Assert.assertEquals(expectedDataTable,actualDataTable);

    }


}
