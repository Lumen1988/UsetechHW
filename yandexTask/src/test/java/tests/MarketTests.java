package tests;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.YandexPage;


public class MarketTests extends AbstractBrowserTest {

    @Test
    public void testSearchingMobilePhonesSamsung() {
        YandexPage yandexPage = new YandexPage();

        String getNameOnTheListing = yandexPage.openYandexPage()
                .goToYandexMarket()
                .searchItemsOnTheMarketPage("Мобильные телефоны Samsung")
                .filterByPriceAbove("40000")
                .getNameOfTheFirstItem();

        String getNameOnTheProductPage = yandexPage
                .goToProductPageOfTheFirstItem()
                .getNameOfTheItem();

        Assertions.assertThat(getNameOnTheListing).isEqualTo(getNameOnTheProductPage);
    }


    @Test
    public void testSearchingHeadphonesBeats() {
        YandexPage yandexPage = new YandexPage();

        String getNameOnTheListing = yandexPage.openYandexPage()
                .goToYandexMarket()
                .searchItemsOnTheMarketPage("Наушники beats")
                .filterByPriceAbove("17000")
                .filterByPriceBelow("25000")
                .getNameOfTheFirstItem();

        String getNameOnTheProductPage = yandexPage
                .goToProductPageOfTheFirstItem()
                .getNameOfTheItem();

        Assertions.assertThat(getNameOnTheListing).isEqualTo(getNameOnTheProductPage);

    }
}
