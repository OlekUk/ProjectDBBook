package library.pages;

import library.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BasePage{


    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
