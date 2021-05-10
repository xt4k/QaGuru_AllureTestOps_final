package webshop.api.template;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

public class ReportTemplate {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private ReportTemplate() {}

    @Step("Custom ReportTemplated define.")
    public static ReportTemplate filteres() {
        return InitLogFilter.logFilter;
    }

    @Step("Custom filters define.")
    public AllureRestAssured customTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    private static class InitLogFilter {
        private static final ReportTemplate logFilter = new ReportTemplate();
    }


}
