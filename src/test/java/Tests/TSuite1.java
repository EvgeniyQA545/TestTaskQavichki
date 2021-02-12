package Tests;

import Pages.CheckmeKavichkiPage;
import TestMethods.MySpace;
import TestMethods.TBaseClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import TestMethods.JavaToMySQL.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static TestMethods.JavaToMySQL.*;
import static TestMethods.SuiteMethodsForCheckmeKavichkiPage.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TSuite1 extends TBaseClass {

    @Test
    public void test1GetDiffData() throws Exception {
        open(CheckmeKavichkiPage.url);
        List list = grabingDataTable(CheckmeKavichkiPage.countRows);
        Connection conn = getConnectToBD("jdbc:mysql://localhost:3306/kavichki?serverTimezone=Europe/Moscow&useSSL=false", "root", "eieu$Pp700");
        deleteTable(conn, "purchases");
        createTable(conn, "purchases");
        addDataToTable(conn, list, "purchases");
        addRowIntoTablePage("Фрактал", "150", "700");
        addRowIntoTablePage("Skill", "1000", "1000");
        addRowIntoTablePage("Api", "1000", "1000000");
        List list1 = grabingDataTable(CheckmeKavichkiPage.countRows);
        deleteTable(conn, "purchases1");
        createTable(conn, "purchases1");
        addDataToTable(conn, list1, "purchases1");
        getDiffTable(conn, "purchases1", "purchases");
        conn.close();
    }

    @Test
    public void testCheckReset() throws Exception {
        open(CheckmeKavichkiPage.url);
        $(byXpath(CheckmeKavichkiPage.addNewButton)).shouldBe(exist).shouldBe(visible).click();
        $(byXpath(CheckmeKavichkiPage.nameField)).shouldBe(exist).shouldBe(visible);
        $(byXpath(CheckmeKavichkiPage.countField)).shouldBe(exist).shouldBe(visible);
        $(byXpath(CheckmeKavichkiPage.priceField)).shouldBe(exist).shouldBe(visible);
        $(byXpath(CheckmeKavichkiPage.resetButton)).shouldBe(exist).shouldBe(visible).click();
        $(byXpath(CheckmeKavichkiPage.nameField)).shouldBe(hidden);
        $(byXpath(CheckmeKavichkiPage.countField)).shouldBe(hidden);
        $(byXpath(CheckmeKavichkiPage.priceField)).shouldBe(hidden);

    }

    @Test
    public void testCheckSortPrice() throws Exception {
        open(CheckmeKavichkiPage.url);
        $(byXpath(CheckmeKavichkiPage.columnPrice)).shouldBe(visible).shouldBe(exist).click();
        List listSort = grabingDataTable(CheckmeKavichkiPage.countRows);
        $(byXpath(CheckmeKavichkiPage.columnPrice)).shouldBe(visible).shouldBe(exist).click();
        checkSortTablePage(CheckmeKavichkiPage.columnPrice, listSort);
    }
    @Test
    public void testCheckSortCount() throws Exception {
        open(CheckmeKavichkiPage.url);
        $(byXpath(CheckmeKavichkiPage.columnCount)).shouldBe(visible).shouldBe(exist).click();
        List listSort = grabingDataTable(CheckmeKavichkiPage.countRows);
        $(byXpath(CheckmeKavichkiPage.columnCount)).shouldBe(visible).shouldBe(exist).click();
        checkSortTablePage(CheckmeKavichkiPage.columnCount, listSort);
    }
    @Test
    public void testCheckSortWhatBbuy() throws Exception {
        open(CheckmeKavichkiPage.url);
        $(byXpath(CheckmeKavichkiPage.columnWhatBuy)).shouldBe(visible).shouldBe(exist).click();
        List listSort = grabingDataTable(CheckmeKavichkiPage.countRows);
        $(byXpath(CheckmeKavichkiPage.columnWhatBuy)).shouldBe(visible).shouldBe(exist).click();
        checkSortTablePage(CheckmeKavichkiPage.columnWhatBuy, listSort);
    }

}

