/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.pnl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dummy
 */
public class S1_set {

    public static class to_tables {

        public final String name;

        public to_tables(String name) {
            this.name = name;
        }
    }

    public static List<to_tables> get_tables(String user, String password, String db, String search) {
//        System.out.println("Listing all table name in Database!");
        List<to_tables> datas = new ArrayList();
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
//        String db = "slsdb_sms3";
        String driver = "com.mysql.jdbc.Driver";
//        String user = "root";
//        String pass = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, password);

            DatabaseMetaData dbm = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbm.getTables(null, null, "%", types);
//            System.out.println("Table name:");
            while (rs.next()) {
                String table = rs.getString("TABLE_NAME");
                to_tables to = new to_tables(table);
                datas.add(to);
//                System.out.println(table);

            }
            con.close();


        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Connection Failed");
            throw new RuntimeException(e);
        }
        return datas;
    }

    public static List<String> get_databases(String user, String password) {
//        System.out.println("Listing all table name in Database!");
        List<String> datas = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
// change user and password as you need it
            Connection con = DriverManager.getConnection(url, user, password);

            ResultSet rs = con.getMetaData().
                    getCatalogs();

            while (rs.next()) {
                datas.add(rs.getString("TABLE_CAT"));
//                System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failed");
//            throw new RuntimeException(e);
        }
        return datas;
    }

    public static class to_col {

        public final String name;
        public final String type;
        public boolean check;

        public to_col(String name, String type, boolean check) {
            this.name = name;
            this.type = type;
            this.check = check;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }

    public static List<to_col> get_columns(String username, String password, String dbName, String table_name) {
//        System.out.println("Listing all table name in Database!");
        List<to_col> datas = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
// change user and password as you need it
            Connection conn = DriverManager.getConnection(url, "root", "password");

//            System.out.println("Connected");
            dbName = dbName + "." + table_name; //'" + dbName + table_name+ "'
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM  " + dbName + " ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int NumOfCol = rsmd.getColumnCount();
            for (int i = 1; i <= NumOfCol; i++) {

                String name = rsmd.getColumnName(i);
                String type = rsmd.getColumnTypeName(i);
                to_col t = new to_col(name, type, true);
                System.out.println(name + "-" + type);
//                System.out.println("Name of [" + i + "] Column data type is ="
//                        + rsmd.getColumnTypeName(i));
                datas.add(t);
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return datas;
    }

    public static void add_database(String user, String password, String database_name, int stat) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
            if (stat == 1) {
                String s0 = "drop database if exists  " + database_name + "";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s2 = "create database " + database_name + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                JOptionPane.showMessageDialog(null, "Database Dropped and Created");
            } else {
                String s2 = "create database " + database_name + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                JOptionPane.showMessageDialog(null, "Dabase Created");
            }
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void delete_database(String user, String password, String database_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);

            String s0 = "drop database if exists  " + database_name + "";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();



            JOptionPane.showMessageDialog(null, "Database Dropped");

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static boolean check_database(String user, String password, String database_name) {
        boolean exists = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
// change user and password as you need it
            Connection conn = DriverManager.getConnection(url, user, password);
            ResultSet resultSet = conn.getMetaData().
                    getCatalogs();

            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if (databaseName.equals(database_name)) {
                    exists = true;
                    break;
                }
            }
            return exists;

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Connection Failed");
            throw new RuntimeException(e);
        }
    }

    public static boolean check_table(String user, String password, String database_name, String table_name) {
        boolean exists = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
// change user and password as you need it
            Connection conn = DriverManager.getConnection(url, user, password);
            String s0 = "select * from " + database_name + "." + table_name;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                exists = true;
            }

//          

        } catch (Exception e) {
            exists = false;
            return exists;
//            JOptionPane.showMessageDialog(null, "Connection Failed");
//            throw new RuntimeException(e);
        }
        return exists;
    }

    public static void add_table(String user, String password, String database_name, String text) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
//            text = "create table a.table3( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";

//            String s0 = text;
//            String s0="create table a.table2( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";
            PreparedStatement stmt = conn.prepareStatement(text);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Table Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void delete_table(String user, String password, String database_name, String table_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
//            text = "create table a.table3( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";

            String s0 = "drop table if exists " + database_name + "." + table_name;
//            String s0="create table a.table2( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Table Dropped");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void add_table_col(String user, String password, String database_name, String table_name, String col_name, String type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
//            text = "create table a.table3( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";

            String s0 = "alter table " + database_name + "." + table_name + " add " + col_name + " " + type;
//            String s0="create table a.table2( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Column Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void edit_table_col(String user, String password, String database_name, String table_name, String col_name, String type, String prev_colname) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
//            text = "create table a.table3( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";

            String s0 = "alter table " + database_name + "." + table_name + " change " + prev_colname + " " + col_name + " " + type;
//            String s0="create table a.table2( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Column Changed");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
//            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void delete_table_col(String user, String password, String database_name, String table_name, String col_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";

            Connection conn = DriverManager.getConnection(url, user, password);
//            text = "create table a.table3( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";

            String s0 = "alter table " + database_name + "." + table_name + " drop " + col_name;
//            String s0="create table a.table2( id int auto_increment primary key,fname varchar(100) ,lname varchar(100) ,mi varchar(100) );";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Column Deleted");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return datas;
    }

    public static void main(String[] args) {
        add_table("root", "password", "a", "tables");
    }
}