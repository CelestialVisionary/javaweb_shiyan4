package l4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            System.out.println("模拟服务器处理数据时间");
            Thread.sleep(5000);//模拟服务器处理数据时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取session对象
        HttpSession session =request.getSession();;
        // 调用isToken()方法验证是否重复提交
        boolean b = isToken(session); //
        if ( !b ) {
            out.write("请不要重复提交！");
            return;
        }
        //处理提交请求之前，需要先将session中保存的token删除
        session.removeAttribute("token");
        // 获取用户输入的参数
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String sex =request.getParameter("sex");
        String birthday =request.getParameter("birthday");
        String[] hobby =request.getParameterValues("hobby");// 获取数组参数
        //将注册信息显示在控制台上
        System.out.println("username=" + username + " password=" + password + " password2=" + password2
                + " sex=" + sex + " birthday=" + birthday);
        if (hobby != null && hobby.length > 0) {
            System.out.print("爱好：");
            for (int i = 0; i < hobby.length; i++) {
                System.out.print(hobby[i] + "  ");
            }
            System.out.println();
        }

        if(null == username || "".equals(username) || !password.equals(password2)) {
            //重定向到RegisterServlet
            response.sendRedirect("RegisterServlet");
        }
        else {
            //转发到success.jsp页面
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private boolean isToken(HttpSession session) {
        //获得session中的token
        String serverToken = (String) session.getAttribute("token");
        //如果已经提交过一次了，会删除session中的token，serverToken就变成null了
        if (serverToken == null)  return false;
        return true;
    }

}
