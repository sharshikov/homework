package steps;

import ru.yandex.qatools.allure.annotations.Step;
import pages.ReportPage;

public class ReportSteps {
    ReportPage report = new ReportPage();
    @Step("выполнено нажатие на кнопку показать по 12, если существует кнопка и проверяем кол-во элментов")
    public void searchButton12(){
        report.searchButton12();
    }
    @Step("проверяем есть ли элемент в результате поиска")
    public void check (){
        report.check();
    }
}
