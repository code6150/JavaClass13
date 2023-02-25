package kr.code6150;

import kr.code6150.db.ColumnInfo;
import kr.code6150.db.DbManager;

import java.sql.*;

public class Main {

    // org.mariadb.jdbc.Driver
    public static void main(String[] args) {

        DbManager.getInstance().createTable("table",
                new ColumnInfo("num1","int"),
                new ColumnInfo("num2","text",true),
                new ColumnInfo("num3","text",false));
    }

}
        // url = "jdbc:mariadb://127.0.0.1:3306/test"
        // "https://www.naver.com"
//        try {
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mariadb://127.0.0.1:3306/test","root","1234");
//            Statement st = con.createStatement();
//            st.execute("create table if not exists `table` (`num` int, `name` text)");
//
//            PreparedStatement ps = con.prepareStatement("create table if not exists `?` (`num` int, `name` text)"); // 준비 된 사수로부터...
//
//            ps.setString(1,"abc");
//            ps.execute();
//
//        } catch (SQLException e) {
//            System.out.println("데이터베이스 접근에 실패했습니다.");
//            e.printStackTrace();
//        }
//
//
//
//    }

