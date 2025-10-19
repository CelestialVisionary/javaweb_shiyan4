package cart.servlet;
import cart.entity.Cake;
import java.io.*;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(name = "CartServlet",urlPatterns="/CartServlet")
public class CartServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 声明变量cart引用用户的购物车
        List<Cake> cart = null;
        // 声明变量pruFlag标记用户是否买过商品
        boolean purFlag = true;
        // 获得用户的session，跟PurchaseServlet中是同一个session
        HttpSession session = req.getSession(false);
        // 如果session为null，purFlag置为false
        if (session == null) {
            purFlag = false;
        } else {
            // 获得用户购物车
            cart = (List) session.getAttribute("cart");
            // 如果用的购物车为null，purFlag置为false
            if (cart == null) {
                purFlag = false;
            }
        }
        /*
         * 如果purFlag为false，表明用户没有购买蛋糕  重定向到ListServlet页面
         */
        if (!purFlag) {
            out.write("对不起！您还没有购买任何商品！<br>");
        } else {
            // 否则显示用户购买蛋糕的信息
            out.write("您购买的蛋糕有：<br>");
            double totalPrice = 0;
            for (Cake cake : cart) {
                out.write(cake.getName() + " - 价格：" + cake.getPrice() + "元<br>");
                totalPrice += cake.getPrice();
            }
            out.write("<br><strong>购物总价格：" + totalPrice + "元</strong><br>");
        }
        out.close();
    }
}
