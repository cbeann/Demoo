package myioc.factory;

/**
 * @author CBeann
 * @create 2019-12-18 9:46
 */
public interface IOCFactory {

    /**
     * 根据名称获得Bean
     */
    public Object getBean(String beanName) throws Exception;


}
