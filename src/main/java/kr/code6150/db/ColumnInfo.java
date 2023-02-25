package kr.code6150.db;

public class ColumnInfo {

    private String name;
    private String sqlType; // int, text, double, char(n) ...
    private boolean notNull; // 기본값으로 notNull = false ( null 허용 )


    public ColumnInfo(String name, String sqlType) {
        this(name,sqlType,false);
    }

    public ColumnInfo(String name, String sqlType, boolean notNull) {
        this.name = name;
        this.sqlType = sqlType;
        this.notNull = notNull;
    }

    // toString -> 오버라이딩 ( 덮어쓰기 : 문자열로 출력(사용)될 때 표현될 값 )
    @Override
    public String toString() {
        // notNull => true ? `name` type not null
        // notNull ? " not null" : "" - 3항 조건 연산자
        return "`" + name + "` " + sqlType + (notNull? " not Null" : "");
    }

}
