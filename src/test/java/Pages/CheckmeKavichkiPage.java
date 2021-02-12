package Pages;

public class CheckmeKavichkiPage {
    public static String url = "https://checkme.kavichki.com/";
    public static String headerPage = "//div[text()='Список покупок']";
    public static String columnWhatBuy = "//table/thead/tr/th[text()='Что купить']";
    public static String columnCount = "//table/thead/tr/th[text()='Количество']";
    public static String columnPrice = "//table/thead/tr/th[text()='стоимсть, кр']";
    public static String columnAction = "//table/thead/tr/th[text()='Действия']";
    public static String addNewButton = "//a[text()='Добавить новое']";
    public static String resetButton = "//a[text()='Сбросить']";
    public static String nameField = "//*[@id='name']";
    public static String countField = "//*[@id='count']";
    public static String priceField = "//*[@id='price']";
    public static String addButton = "//*[@id='add']";
    public static String deleteRowButton(String valueWhatBuy) {
        return "//table/tbody/tr/td[text()='" + valueWhatBuy + "']/../td[last()]";
    }
    public static String anyCellLastRow(String value){
        return "//table/tbody/tr[last()]/td[text()='"+value+"']";
    }
    public static String anyCellFirstRow(String value){
        return "//table/tbody/tr[1]/td[text()='"+value+"']";
    }
    public static String countRows = "//table/tbody/tr";
    public static String countCells = "//table/tbody/tr/td";

}
