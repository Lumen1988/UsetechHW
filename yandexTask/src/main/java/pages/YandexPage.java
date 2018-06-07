package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class YandexPage {


    public YandexPage openYandexPage() {
        open("http://yandex.ru");
        return this;
    }

    public YandexPage goToYandexMarket() {
        $x(".//*[@data-id = 'market']").click();
        return this;
    }

    public YandexPage searchItemsOnTheMarketPage(String s) {
        $(By.id("header-search")).val(s).pressEnter();
        return this;
    }

    public YandexPage filterByPriceAbove(String i) {
        $(By.id("glpricefrom")).clear();
        $(By.id("glpricefrom")).sendKeys(i);
        $("._1PQIIOelRL").waitUntil(Condition.visible, 10000);
        return this;
    }

    public YandexPage filterByPriceBelow(String i) {
        $(By.id("glpriceto")).clear();
        $(By.id("glpriceto")).sendKeys(i);
        $("._1PQIIOelRL").waitUntil(Condition.visible, 10000);
        return this;
    }


    public String getNameOfTheFirstItem() {
        return $x("(.//*[@class = 'n-snippet-cell2__title'])[1]").getText();
    }

    public YandexPage goToProductPageOfTheFirstItem() {
        $x("(.//*[@class = 'n-snippet-cell2__header'])[1]").click();
        return this;
    }

    public String getNameOfTheItem() {
        $(".n-product-tabs__list").waitUntil(Condition.visible, 10000);
        return $x("//h1").getText();
    }

    public void searchAndGoToAlfaBankSite() {
        $(By.id("text")).val("сайт АльфаБанк").pressEnter();
        open("https://alfabank.ru/");
    }
}
