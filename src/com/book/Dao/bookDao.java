package com.book.Dao;
import java.awt.print.Book;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.ArrayList;
import java.util.List;

import com.book.Bean.BookBean;
import com.book.Util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class bookDao {
    private static InitialContext context = null;
    private DataSource dataSource = null;
    QueryRunner runner=new QueryRunner();
    public void BookDAO() {
        try {
            if (context == null) {
                context = new InitialContext();
            }
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bookDS");
        } catch (NamingException e2) {
        }
    }
    List<BookBean> booksForSelectTitle=null;
    //根据书名查询书本记录
    public List<BookBean> searchBook(String title) throws SQLException {
        Connection conn= DBHelper.getConnection();
        String sql="select * from book where title=?";
        booksForSelectTitle=runner.query(conn,sql,new BeanListHandler<BookBean>(BookBean.class),title);
        conn.close();
        return booksForSelectTitle;
    }

    // 插入一本图书记录
    public int insertBook(String title,String author,String publisher,float price) throws SQLException {

            Connection conn= DBHelper.getConnection();
            String sql="insert into book(title, author, publisher,price) values " +
                "(?,?,?,?)";
            int count=runner.update(conn,sql,title, author,publisher,price);
            conn.close();
           return count;
    }

    public static void main(String[] args) throws SQLException { //测试类
        bookDao bookDao = new bookDao();
        List<BookBean> test = null;
        test = bookDao.searchBook("1");
        if(test.size()==0){
            System.out.println("aooooo");
        }
        for (BookBean book : test) {
            System.out.println(book.getAuthor());
            System.out.println(test.size());
        }
    }
    }

