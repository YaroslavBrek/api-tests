package atlaspages.site;

import io.qameta.atlas.webdriver.extension.Page;
import pageobjects.HomePage;

public interface AutomationPracticeSite {

    @Page
    HomePage onHomePage();

/*    @Page(url = "search")
    SearchPage onSearchPage(@Query("q") String value);

    @Page(url = "{profile}/{project}/tree/master/")
    ProjectPage onProjectPage(@Path("profile") String profile, @Path("project") String project);

    @Page
    ContributorsPage onContributorsPage();*/
}
