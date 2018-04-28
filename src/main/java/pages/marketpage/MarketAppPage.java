package pages.marketpage;

public class MarketAppPage {
    private NavigationBar bar;

    public void chooseMenuTab(String tab) {
        new NavigationBar().chooseCategoryName(tab);
    }
}
