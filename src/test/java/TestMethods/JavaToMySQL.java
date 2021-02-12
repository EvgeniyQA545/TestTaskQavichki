package TestMethods;

import TestMethods.MySpace.*;

import java.sql.*;
import java.util.List;

import TestMethods.MySpace.*;

public class JavaToMySQL {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/kavichki?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String user = "root";
    private static final String password = "eieu$Pp700";

    public static Connection getConnectToBD(String url, String user, String password) {

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            System.out.print("DB connection not established");
            e.printStackTrace();
            return null;
        }

    }

    public static void deleteTable(Connection connection, String nameTable) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists " + nameTable);
            System.out.println("The table " + nameTable + " if existed was deleted");
            statement.close();
        } catch (SQLException e) {
            System.out.println("The table " + nameTable + " not deleted");
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection, String nameTable) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table if not exists " + nameTable + " (id MEDIUMINT NOT NULL AUTO_INCREMENT, WhatBuy VARCHAR(50), Count INT, Price INT, Actions VARCHAR(50), PRIMARY KEY (id));");
            System.out.println("The table " + nameTable + " was created");
            statement.close();
        } catch (SQLException e) {
            System.out.println("The table " + nameTable + " not created");
            e.printStackTrace();
        }

    }

    public static void addDataToTable(Connection connection, List<MySpace> list, String nameTable) throws SQLException {
        for (int s = 0; s < list.size(); s++) {
            String whatBuy = list.get(s).getWhatBuy();
            int price = list.get(s).getPrice();
            int count = list.get(s).getCount();
            String action = list.get(s).getAction();

            try {

                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into " + nameTable + " (whatBuy, count, price, actions)  values ('" + whatBuy + "', '" + count + "', '" + price + "', '" + action + "');");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void getDiffTable(Connection connection, String nameTable1, String nameTable2) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rsDiff = statement.executeQuery("SELECT * FROM " + nameTable1 + " WHERE id NOT IN (SELECT id FROM " + nameTable2 + " WHERE id IS NOT NULL);");
            System.out.println("get diff");
            while (rsDiff.next())
                System.out.println(rsDiff.getString("id") + "  " + rsDiff.getString("Whatbuy") + "  " + rsDiff.getString("Count") + " " + rsDiff.getString("Price") + " " + rsDiff.getString("Actions"));



            statement.close();


        } catch (SQLException e) {
            System.out.println("The diff not got");
            e.printStackTrace();
        }

    }

}
