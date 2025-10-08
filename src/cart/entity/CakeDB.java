package cart.entity;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

//模拟Cake的数据库
public class CakeDB {

    //用Map集合类型数据，泛型为（字符串、Cake类），模拟一个数据库，存储若干蛋糕品种
    private static Map<String, Cake> cake = new LinkedHashMap<String, Cake>();
    static {
        cake.put("1", new Cake("1", "A类蛋糕"));//直接调用构造方法构建一个Cake的实例
        cake.put("2", new Cake("2", "B类蛋糕"));
        cake.put("3", new Cake("3", "C类蛋糕"));
        cake.put("4", new Cake("4", "D类蛋糕"));
        cake.put("5", new Cake("5", "E类蛋糕"));
    }

    // 获得所有的蛋糕，返回的是集合类型，泛型为Cake类
    public static Collection<Cake> getAll() {
        return cake.values();
    }

    // 根据指定的id获蛋糕
    public static Cake getCake(String id) {
        return cake.get(id);
    }
}
