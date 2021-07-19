import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class AnnoSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория [{repository}]")
    public void searchForRepository(String repository) {
        $(".header-search-input").val(repository);
        $(".header-search-input").pressEnter();
    }

    @Step("Заходим в репозиторий [{repository}]")
    public void goToRepository(String repository){
        $(By.linkText(repository)).click();
    }

    @Step("Открываем Issue")
    public void openIssue() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем что есть Issue с номером [{number}]")
    public void checkIssue(String number) {
        $(withText(number)).should(Condition.exist);
    }
}
