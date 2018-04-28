package pages.mainpage;

import pages.mainpage.widgets.NavigationBar;
import pages.mainpage.widgets.SearchAppWidget;

public class MainPage {

    public MainPage() {
    }

    public void searchForSomething(String query) {
        new SearchAppWidget().search(query);
    }

    public void selectAppCategory(String appName) {
        new NavigationBar().chooseAppCategory("Маркет");
    }
}
