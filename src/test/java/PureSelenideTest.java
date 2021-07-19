import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.partialLinkText;

public class PureSelenideTest {

    String REPOSITORY = "eroshenkoam/allure-example";


    @Test
    public void repositorieIssueTest(){
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(By.linkText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.exist);
    }
}
