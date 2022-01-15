package com.book.Servlet;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.book.Bean.BookBean;
import com.book.Dao.bookDao;

@WebServlet("/query.let")

public class BookQueryServlet extends HttpServlet {
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
        List<BookBean> booksForSelectedTitle=null;
        ServletContext application=req.getServletContext();

        String type = req.getParameter("book");
        if(type.equals("query")) {
            String title = req.getParameter("title");
            try {
                booksForSelectedTitle = bookdao.searchBook(title);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(booksForSelectedTitle.size()>0){
//            req.getSession().setAttribute("books", booksForSelectedTitle);
//            out.println("<script>alert('查询成功!');location.href='display.jsp';</script>");
            session.setAttribute("books", booksForSelectedTitle);
            req.getRequestDispatcher("display.jsp").forward(req,resp);//进行页面转发
            }
        else{
            out.println("<script>location.href='errorPage.jsp';</script>");
            }
        }

    }


