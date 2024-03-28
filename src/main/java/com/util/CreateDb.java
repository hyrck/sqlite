package com.util;

import java.sql.*;

public class CreateDb {

        public static void main(String[] args) {
            // 获取当前类的类加载器
            ClassLoader classLoader = CreateDb.class.getClassLoader();
            // 获取类路径下指定文件的路径
            String dbFilePath = classLoader.getResource("test.db").getPath();

            // 构建 SQLite 连接字符串，指定数据库文件路径
            String url = "jdbc:sqlite:" + dbFilePath;

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {

                // 创建一个名为 users 的表
                stmt.execute("CREATE TABLE IF NOT EXISTS user (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "username TEXT NOT NULL," +
                        "passwored TEXT NOT NULL," +
                        "age INTEGER)");

                // 插入一些示例数据
                stmt.execute("INSERT INTO user (username, password, age) VALUES ('a', 'a', 30)");
                stmt.execute("INSERT INTO user (username, password, age) VALUES ('a', 'a', 25)");

                // 查询所有用户
                System.out.println("All users:");
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") +
                            ", Name: " + resultSet.getString("name") +
                            ", Age: " + resultSet.getInt("age"));
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        }
    }

