package cart.entity;

//javabean：定义cake类的属性和操作方法
public class Cake {
    private static final long serialVersionUID = 1L;
    //声明私有变量，作为Cake的属性
    private String id;
    private String name;
    public Cake() {     //无参数构造方法
    }
    public Cake(String id, String name) {    //有参数构造方法
        this.id = id;
        this.name = name;
    }

    //获取Getter和修改Setter属性的相关方法
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
