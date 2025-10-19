package l4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取表单提交的token值
        String tokenForm = request.getParameter("token");
        //获取session中的token值
        HttpSession session = request.getSession();
        String tokenSession = (String) session.getAttribute("token");
        //比较表单和session中的token值
        if(tokenSession != null && tokenSession.equals(tokenForm)){
            //验证成功，移除session中的token值，防止重复提交
            session.removeAttribute("token");
            //获取表单数据
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //输出注册成功信息
            out.println("<h1>注册成功</h1>");
            out.println("用户名：" + username + "<br>");
            out.println("密码：" + password + "<br>");
        }else{
            //验证失败，说明是重复提交或者无效请求
            out.println("<h1>请不要重复提交表单！</h1>");
        }
        out.println("<a href='register.jsp'>返回注册页面</a>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>请通过表单提交数据</h1>");
        out.close();
    }
}
