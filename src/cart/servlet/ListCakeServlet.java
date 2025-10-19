package cart.servlet;
import cart.entity.Cake;
import cart.entity.CakeDB;
import java.io.*;
import java.util.Collection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(name = "ListCakeServlet",urlPatterns="/ListCakeServlet")
public class ListCakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获得所有的蛋糕，返回的是集合类型，泛型为Cake类
        Collection<Cake> cakes = CakeDB.getAll();

        //输出所有的蛋糕
        out.write("本站提供的蛋糕有：<br>");
        for (Cake cake : cakes) {
            //转到PurchaseServlet，？后表示带参数，购买指定id的cake
            String url = "PurchaseServlet?id=" + cake.getId();
            out.write(cake.getName() + "<a href='" + url
                    + "'>点击购买</a><br>");
        }
    }
}
