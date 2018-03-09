package steps;

import ru.yandex.qatools.allure.annotations.Step;
import pages.ReportPage;

public class ReportSteps {
    ReportPage report = new ReportPage();
    @Step("находим кнопку")
    public void searchButton(){
        report.searchButton();
    }
    @Step("проверяем значение {0}")
    public void inputName (){
        report.inputName();
    }
}
