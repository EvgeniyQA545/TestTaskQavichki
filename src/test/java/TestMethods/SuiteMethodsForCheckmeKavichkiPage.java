package TestMethods;

import Pages.CheckmeKavichkiPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.util.Properties;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SuiteMethodsForCheckmeKavichkiPage {

    public static List<MySpace> grabingDataTable(String rows) {
        ElementsCollection countTr = $$(byXpath(rows));
        System.out.println(countTr.size());
        MySpace mySpace = new MySpace();
        List<MySpace> list = new ArrayList<MySpace>();
        for (int tr = 1; tr <= countTr.size(); tr++) {
            ElementsCollection countTd = $$(byXpath(rows + "[" + tr + "]/td"));
            /*System.out.println(countTd);*/
            mySpace.setWhatBuy(countTd.get(0).getText());
            String whatBuy = mySpace.getWhatBuy();
            mySpace.setCount(Integer.parseInt(countTd.get(1).getText()));
            int count = mySpace.getCount();
            mySpace.setPrice(Integer.parseInt(countTd.get(2).getText()));
            int price = mySpace.getPrice();
            mySpace.setAction(countTd.get(3).getText());
            String action = mySpace.getAction();
            list.add(new MySpace(whatBuy, count, price, action));

        }
        return list;

    }

    public static void addRowIntoTablePage(String name, String count, String price) {
        $(byXpath(CheckmeKavichkiPage.addNewButton)).shouldBe(exist).shouldBe(visible).click();
        $(byXpath(CheckmeKavichkiPage.nameField)).shouldBe(exist).shouldBe(visible).setValue(name);
        $(byXpath(CheckmeKavichkiPage.countField)).shouldBe(exist).shouldBe(visible).setValue(count);
        $(byXpath(CheckmeKavichkiPage.priceField)).shouldBe(exist).shouldBe(visible).setValue(price);
        $(byXpath(CheckmeKavichkiPage.addButton)).shouldBe(exist).shouldBe(visible).click();
    }

    public static void checkSortTablePage(String column, List<MySpace> list) {
        String whatBuyFirst = list.get(0).getWhatBuy();
        int priceFirst = list.get(0).getPrice();
        int countFirst = list.get(0).getCount();
        String whatBuyLast = list.get(3).getWhatBuy();
        int priceLast = list.get(3).getPrice();
        int countLast = list.get(3).getCount();
        if (column == CheckmeKavichkiPage.columnPrice) {
            $(byXpath(CheckmeKavichkiPage.anyCellFirstRow(Integer.toString(priceLast)))).shouldBe(exist).shouldBe(visible);
            $(byXpath(CheckmeKavichkiPage.anyCellLastRow(Integer.toString(priceFirst)))).shouldBe(exist).shouldBe(visible);
        }
        if (column == CheckmeKavichkiPage.columnCount) {
            $(byXpath(CheckmeKavichkiPage.anyCellFirstRow(Integer.toString(countLast)))).shouldBe(exist).shouldBe(visible);
            $(byXpath(CheckmeKavichkiPage.anyCellLastRow(Integer.toString(countFirst)))).shouldBe(exist).shouldBe(visible);
        }

        if (column == CheckmeKavichkiPage.columnWhatBuy) {
            $(byXpath(CheckmeKavichkiPage.anyCellFirstRow(whatBuyLast))).shouldBe(exist).shouldBe(visible);
            $(byXpath(CheckmeKavichkiPage.anyCellLastRow(whatBuyFirst))).shouldBe(exist).shouldBe(visible);
        }
    }

}



