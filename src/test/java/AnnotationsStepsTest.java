import org.junit.jupiter.api.Test;


public class AnnotationsStepsTest {

    String repository = "eroshenkoam/allure-example";
    String number = "68";

    private AnnoSteps steps = new AnnoSteps();

    @Test
    public void annotationStepsIssue() {
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.goToRepository(repository);
        steps.openIssue();
        steps.checkIssue(number);

    }
}
