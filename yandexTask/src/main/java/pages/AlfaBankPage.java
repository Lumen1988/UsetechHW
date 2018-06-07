package pages;

import org.openqa.selenium.By;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class AlfaBankPage {


    public AlfaBankPage goToJobPage() {
        $(By.linkText("Вакансии")).click();
        return this;
    }

    public AlfaBankPage goToInfoAboutJobPage() {
        $("span.nav_item.right-section > a").click();
        return this;
    }

    public void addInfoAboutJobToTheFile() throws IOException {
        String getHeader = $("div.message").getText();
        String getBody = $("div.info").getText();

        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss") ;
        File file = new File("/resources/" + dateFormat.format(date) + "_GChrome_Yandex.txt") ;
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(getHeader + "\n");
        out.write(getBody);
        out.close();

    }
}
