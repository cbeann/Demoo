package myioc.factory.impl;

import myioc.configbean.BeanDefinationn;
import myioc.factory.IOCFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author CBeann
 * @create 2019-12-18 10:08
 */
public class IOCFactoryImpl implements IOCFactory {

    private static Object NO_SINGLEN = new Object();


    //IOC容器
    private Map<String, Object> iocMap = new HashMap<>();
    //BeanDefination容器
    private Map<String, BeanDefinationn> beanDefinationnMap = new HashMap<>();


    public IOCFactoryImpl(String configPath) throws Exception {

        try {
            //解析配置文件
            xmlParse(configPath);
            //初始化Bean
            prepareSingleBean();


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /*解析XML方法*/
    private void xmlParse(String configPath) throws Exception {
        File file = new File(configPath);
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(file);
        // 创建XPath对象,反射获取XPath对象
        XPathFactory factory = XPathFactory.instance();

        XPathExpression expression = factory.compile("//bean");
        List<Element> beans = expression.evaluate(document);
        for (Element beanElement : beans) {
            //获取id
            String id = beanElement.getAttributeValue("id");
            //获取类全路径
            String clazz = beanElement.getAttributeValue("class");
            //是否单例
            String singleton = beanElement.getAttributeValue("scope");
            //获取参数
            List<Element> properties = beanElement.getChildren("property");

            //初始化Bean定义对象
            BeanDefinationn beanDefination = new BeanDefinationn();
            beanDefination.setId(id);
            beanDefination.setClazz(clazz);
            beanDefination.setSinglen((singleton != null && "singleton".equals(singleton)));
            for (Element property : properties) {
                String name = property.getAttributeValue("name");
                String value = property.getAttributeValue("value");
                String ref = property.getAttributeValue("ref");


                if (null != value) {
                    //如果是非引用类型
                    beanDefination.getProperties().put(name, value);
                } else {
                    //如果是引用类型
                    beanDefination.getRefs().put(name, ref);
                }

            }
            beanDefinationnMap.put(beanDefination.getId(), beanDefination);
        }


    }

    //初始化单例类
    private void prepareSingleBean() throws Exception {

        //循环遍历Bean的定义信息
        Set<Map.Entry<String, BeanDefinationn>> entries = beanDefinationnMap.entrySet();
        for (Map.Entry<String, BeanDefinationn> entry : entries) {
            //获取Bean的唯一ID名称
            String id = entry.getKey();
            BeanDefinationn value = entry.getValue();
            //创建Bean
            Object bean = getBean(id);
            //如果是单例，放入IOC容器中
            if (value.getSinglen()) {
                iocMap.put(id, bean);
            } else {
                //非单例则放入一个静态类，如果放null,则容易和没有定义的类混淆
                iocMap.put(id, NO_SINGLEN);
            }
        }

    }

    /*
    获取Bean
    如果单例，在IOC容器获取并且返回，如果获取不到，创建并且并且返回
     */
    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinationn beanDefinationn = beanDefinationnMap.get(beanName);

        //如果是单例
        if (beanDefinationn.getSinglen()) {
            //如果容器中有该Bean，直接返回
            if (null != iocMap.get(beanName)) {
                return iocMap.get(beanName);
            } else {
                //如果容器中没有该Bean，则创建Bean
                return doCreateBean(beanName);
            }

        } else {
            //如果不是单例,直接创建，不在IOC容器中获取
            return doCreateBean(beanName);
        }
    }

    /*
    创建Bean
     */
    private Object doCreateBean(String beanName) throws Exception {
        //获取Bean的定义信息
        BeanDefinationn beanDefinationn = beanDefinationnMap.get(beanName);
        // 反射拿到类的相应信息,首先是拿到类的实例对象
        Class clazz = Class.forName(beanDefinationn.getClazz());
        Object object = clazz.newInstance();
        // 获取类的所有方法,然后通过set方法给这个对象设置属性值
        Method[] methods = clazz.getDeclaredMethods();
        //获取所有的参数和引用
        Map<String, Object> properties = beanDefinationn.getProperties();
        Map<String, Object> refs = beanDefinationn.getRefs();


        //给对象封装引用参数和非引用参数
        for (int i = 0; i < methods.length; i++) {
            //获得方法的名称
            String methodName = methods[i].getName();
            // 属性名
            String beanPropertyName = "";
            // 这里检索set方法
            if (methodName.startsWith("set")) {
                // 根据set方法获取属性名->这里就只截取set方法的方法名并且转换为小写的名字
                //setStudentDao--->studentDao
                beanPropertyName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
                if (properties.containsKey(beanPropertyName)) {
                    //如果这个参数是非引用参数
                    //在参数列表中获取value
                    Object proVal = properties.get(beanPropertyName);
                    //通过反射执行此方法
                    methods[i].invoke(object, proVal);


                } else if (refs.containsKey(beanPropertyName)) {
                    //如果这个参数是引用参数
                    //在ioc容器中获取value
                    Object proVal = getBean(refs.get(beanPropertyName).toString());
                    //通过反射执行此方法
                    methods[i].invoke(object, proVal);

                } else {
                    //什么也不做
                }


            }


        }
        //返回这个类型
        return object;

    }
}