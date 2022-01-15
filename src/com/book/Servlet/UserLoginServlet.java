package com.book.Servlet;

import com.book.Bean.UserBean;
import com.book.Dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/user.let")
public class UserLoginServlet extends HttpServlet {
    //构建UserDao的对象
   com.book.Dao.userDao userDao=new userDao();
    UserBean loginUserBean=new UserBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * /user.let?type=login 登录   斜杠/：代表项目的根目录 -->web
     * web
     *      |-login.html
     *      |-user.let?type=login
     *      |-index.jsp
     *
     * /user.let?type=exit 安全退出
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        //1、判读用户请求的类型为login
        String method=req.getParameter("type");
        switch (method){
            case "login": //2、从login.html中获取用户名和密码,验证码
                String name=req.getParameter("name");
                String pwd=req.getParameter("pwd");

                //3、调用UserDao的getUser方法，根据用户名和密码获取对象
                try {
                    loginUserBean=userDao.getUser(name,pwd);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //4、判断用户对象是否为null：
                if(loginUserBean==null){
                    //4.1如果是null表示用户名和密码不正确，提示错误，回到登陆页面
                    out.println("<script>alert('用户名或密码不存在！');location.href='login.jsp';</script>");
                }else {
                    //4.2非空：表示登录成功，将用户对象保存在session中，提示登录成功后，将页面跳转到bookInsert.jsp
                    session.setAttribute("user",loginUserBean);
                    out.println("<script>alert('登陆成功');location.href='index.jsp';</script>");
                }
                break;
            case "exit":
                //1、清除session
                session.invalidate();
                //2、跳转到login.html(框架中需要回去) top.jsp->parent->index.jsp
                out.println("<script>parent.window.location.href='login.jsp';</script>");
                break;

        }
    }
}

