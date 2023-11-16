package houyw.java.myself.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.jdbc.Driver;
import houyw.common.utils.TransferUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/6/8 11:52
 * @Description: 将输入实例直接转化成表数据
 */
public class JdbcUtils {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static List<String> tableNames = new ArrayList<>();
    private static List<String> tableBodys = new ArrayList<>();
    private static List<List<String>> lst = new ArrayList<>();
    private static List<String> insert = new ArrayList<>();
    private static List<List<String>> types = new ArrayList<>();
    private static String url = "jdbc:mysql://localhost:3306/sqltest2?useUnicode=true&characterEncoding=Utf8&useSSl=false&serverTimezone=Asia/Shanghai&useTimezone=true";

    static {
        String stringFromTXT = TransferUtils.getStringFromTXT("C:\\Users\\DELL\\Desktop\\tableValues.txt");
        JSONObject jsonObject = JSONObject.parseObject(stringFromTXT);
        JSONObject headers = (JSONObject) jsonObject.get("headers");
        JSONObject rows = (JSONObject) jsonObject.get("rows");
        Set<String> strings = headers.keySet();
        for (String key : strings) {
            tableNames.add(key);
            JSONArray column = (JSONArray) headers.get(key);
            List<String> cols = new ArrayList<>();
            for (Object o : column) {
                cols.add((String) o);
            }
            lst.add(cols);
        }
        for (int j = 0; j < tableNames.size(); j++) {
            String tableName = tableNames.get(j);
            JSONArray allRows = (JSONArray) rows.get(tableName);
            JSONArray oneRow = (JSONArray) allRows.get(j);
            List<String> list = new ArrayList<>();
            for (Object o1 : oneRow) {
                if (o1 instanceof Integer) {
                    list.add("int");
                } else {
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        formatter.parse(String.valueOf(o1));
                        list.add("date default null");
                    } catch (Exception e) {
                        list.add("varchar(255) default null");
                    }
                }
            }
            types.add(list);
            for (Object o : allRows) {
                JSONArray row = (JSONArray) o;

                String sql = "insert into " + tableName + " values(";
                for (Object o1 : row) {
                    if (o1 == null) {
                        sql += "null,";
                    } else if (o1 instanceof Integer) {
                        sql += ((Integer) o1).intValue() + ",";
                    } else {
                        sql += "'" + String.valueOf(o1) + "'" + ",";
                    }
                }
                sql = sql.substring(0, sql.length() - 1) + ")";
                insert.add(sql);
            }
        }
        for (int i = 0; i < tableNames.size(); i++) {
            String tableBody = "";
            List<String> strings1 = lst.get(i);
            List<String> strings2 = types.get(i);
            for (int k = 0; k < strings1.size(); k++) {
                tableBody += strings1.get(k) + " " + strings2.get(k) + ",";
            }
            tableBody = "(" + tableBody.substring(0, tableBody.length() - 1) + ")";
            tableBodys.add(tableBody);
        }

    }

    public static void main(String[] args) throws Exception {


        connectDB();
        dropTable();
        createTable();
        closeDB();
    }

    public static void connectDB() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        Driver driver = (Driver) aClass.newInstance();
        connection = driver.connect(url, properties);
        statement = connection.createStatement();
    }

    public static void closeDB() throws Exception {
        if (null != connection) {
            connection.close();
        }
        if (null != statement) {
            statement.close();
        }
        if (null != resultSet) {
            resultSet.close();
        }
    }

    public static void createTable() throws Exception {
        for (int i = 0; i < tableNames.size(); i++) {
            String sql = "create table " + tableNames.get(i) + tableBodys.get(i);
            statement.execute(sql);
        }
        for (String into : insert) {
            boolean execute = statement.execute(into);
        }
    }

    public static void dropTable() throws Exception {

        for (int i = 0; i < tableNames.size(); i++) {
            //如果存在 才执行
            String sql = "drop table if exists " + tableNames.get(i);
            statement.execute(sql);

        }

    }
}
