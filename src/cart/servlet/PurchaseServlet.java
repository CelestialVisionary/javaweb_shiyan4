package cart.servlet;
import cart.entity.Cake;
import cart.entity.CakeDB;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "PurchaseServlet",urlPatterns="/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 获得用户购买的商品
        String id = req.getParameter("id");
        if (id == null) {   //防错设计
            // 如果id为null，重定向到ListBookServlet页面
            String url = "ListBookServlet";
            resp.sendRedirect(url);
            return;
        }
        //根据id获取对应的Cake对象
        Cake cake = CakeDB.getCake(id);

        // 获得当前用户的Session对象
        HttpSession session = req.getSession();
        // 从Session对象中获得用户的购物车，可能是上一次购买记录
        // 第一次运行项目时，session必然是空，第二次以后就会有记录
        List<Cake> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            // 首次购买，为用户创建一个购物车(List集合模拟购物车)
            cart = new ArrayList<Cake>();
            // 将购物城存入Session对象
            session.setAttribute("cart", cart);
        }
        // 将商品放入购物车
        cart.add(cake);
        // 创建Cookie存放Session的标识号
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/Servlet");
        resp.addCookie(cookie);
        // 重定向到购物车页面
        String url = "CartServlet";
        resp.sendRedirect(url);
    }
}
