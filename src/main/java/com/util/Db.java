package com.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Db {

    public static void main(String[] args) {
        // 指定数据库文件名
        String dbFileName = "test.db";

        // 创建数据库文件
        try {
            Files.createFile(Paths.get(dbFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return; // 如果创建文件失败，则退出程序
        }

        // SQLite 连接字符串，指定数据库文件路径
        String url = "jdbc:sqlite:" + dbFileName;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // 创建一个名为 users 的表
            stmt.execute("CREATE TABLE IF NOT EXISTS user (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL," +
                    "password TEXT NOT NULL," +
                    "age INTEGER)");

            // 插入一些示例数据
            stmt.execute("INSERT INTO user (username, password, age) VALUES ('a', 'a', 30)");
            stmt.execute("INSERT INTO user (username, password, age) VALUES ('a', 'a', 25)");

            // 查询所有用户
            System.out.println("All user:");
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("username") +
                        ", password: " + resultSet.getString("password") +
                        ", Age: " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
