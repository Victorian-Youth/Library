package com.book.Servlet;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.book.Bean.BookBean;
import com.book.Dao.bookDao;

@WebServlet("/insert.let")

public class BookInsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取各种对象
        HttpSession session=req.getSession();
        PrintWriter out=resp.getWriter();
        bookDao bookdao = new bookDao();

        String title=req.getParameter("title");
        String author=req.getParameter("author");
        String publisher=req.getParameter("publisher");
        float price=Float.parseFloat(req.getParameter("price"));

//        BookBean book = new BookBean(
//                Long.parseLong(req.getParameter("bookid")),req.getParameter("title"),
//                req.getParameter("author"),req.getParameter("publisher"),
//                Float.parseFloat(req.getParameter("price"))
//

        int count= 0;
        try {
            count = bookdao.insertBook(title,author,publisher,price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count>0){
            out.println("<script>alert('插入记录成功！');location.href='index.jsp';</script>");
        }else{
            out.println("<script>alert('插入记录失败');location.href='bookInsert.jsp';</script>");
        }
    }
}
