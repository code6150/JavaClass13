package kr.code6150.db;

import java.sql.*;

public class DbManager {

    private static DbManager instance;
    public static DbManager getInstance() {
        if(instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

    private Connection con;
    private DbManager () {
        // 객체가 생성될 때 실행
        try {
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test","root","1234");
        } catch (SQLException e) {
            System.out.println("데이터베이스 접근에 실패했습니다.");
        }

    }
    public boolean isConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean createTable(String table, ColumnInfo... info) {
        if(!isConnected()) return false;
        if(info.length == 0) return false;

        // `num` int not null,`a` int,~
        String infoText = "";
        for (ColumnInfo columnInfo : info) {
            infoText += columnInfo.toString() + ",";

        }
        infoText = infoText.substring(0,infoText.length() -1);

        // try-with-resources
        // try(closeable) {
        //      Exception 이 발생 했을 때 자동으로 close 해준다.
        // } -> try 가 끝날때 자동으로 close 해준다.
        try(Statement stmt = con.createStatement()) {
            //create table if not exists `~~~` (`number` int, `name` text)
            stmt.execute("create table if not exists `"+table+"` (" + infoText + " )");
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

}
