package com.book.Dao;

import com.book.Bean.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

import com.book.Util.DBHelper;

//用户表的数据操作对象
    public class userDao {
        //DbUtils是Apache组织提供的一个对JDBC进行简单封装的开源工具类库，使用它能够简化JDBC应用程序的开发同时不会影响程序的性
        QueryRunner runner=new QueryRunner();
        public UserBean getUser(String name, String pwd) throws SQLException {
            //1、调用DBHelper获取连接对象
                Connection conn= DBHelper.getConnection();

            //2、准备执行的sql语句
            String sql="select * from user\n" +
                    "where name=? and pwd=? and state =1";
            //3、调用查询方法，将查询的数据封装成User对象
            UserBean user=runner.query(conn,sql,new BeanHandler<UserBean>(UserBean.class),name,pwd);
            //4、关闭连接对象
            conn.close();
            //5、返回User
            return user;
        }

    public static void main(String[] args) throws SQLException {//测试类
        userDao test=new userDao();
        UserBean user=test.getUser("admin","123");
        System.out.println(user);
    }
}
