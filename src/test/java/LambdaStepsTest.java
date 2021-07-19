import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {
    String REPOSITORY = "eroshenkoam/allure-example";
    String ISSUE_NUMBER = "68";

    @Test
    public void lambdaStepsIssue() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search repository "+ REPOSITORY, () -> {
            $(".header-search-input").val(REPOSITORY).pressEnter();
        });
        step("Go to the repository "+ REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Looking for issue", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check if there is a value " + ISSUE_NUMBER + " Issue", () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}

