package myioc.configbean;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean的定义信息
 */
public class BeanDefinationn {


    private String id;//名称
    private String clazz;//类型
    private Boolean isSinglen;//是否单例
    private Map<String, Object> properties = new HashMap<>();//非引用参数集合
    private Map<String, Object> refs = new HashMap<>();//引用参数集合

    public BeanDefinationn() {

    }

    @Override
    public String toString() {
        return "BeanDefinationn{" +
                "id='" + id + '\'' +
                ", clazz='" + clazz + '\'' +
                ", isSinglen=" + isSinglen +
                ", properties=" + properties +
                ", refs=" + refs +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Boolean getSinglen() {
        return isSinglen;
    }

    public void setSinglen(Boolean singlen) {
        isSinglen = singlen;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Map<String, Object> getRefs() {
        return refs;
    }

    public void setRefs(Map<String, Object> refs) {
        this.refs = refs;
    }
}
