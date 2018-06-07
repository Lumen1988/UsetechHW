package tests;

import org.testng.annotations.Test;
import pages.AlfaBankPage;
import pages.YandexPage;

import java.io.IOException;

public class AlfaBankTest extends AbstractBrowserTest {

    @Test
    public void testWriteInfoToTheFile() throws IOException {
        YandexPage yandexPage = new YandexPage();
        AlfaBankPage alfaBankPage = new AlfaBankPage();

        yandexPage.openYandexPage()
                .searchAndGoToAlfaBankSite();

        alfaBankPage
                .goToJobPage()
                .goToInfoAboutJobPage()
                .addInfoAboutJobToTheFile();
    }
}
