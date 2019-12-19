package myioc.app;


import myioc.entity.Book;
import myioc.entity.Student;
import myioc.entity.StudentDao;
import myioc.entity.StudentService;
import myioc.factory.IOCFactory;
import myioc.factory.impl.IOCFactoryImpl;

/**
 * @author CBeann
 * @create 2019-12-18 9:49
 */
public class IOCStart {
    public static void main(String[] args) throws Exception {

        IOCFactory factory = new IOCFactoryImpl("E:\\IntelliJ IDEA 2019.1.3Workspace\\Demoo\\ioc-demo\\src\\main\\java\\myioc\\myioc.xml");

        System.out.println("----单例----");
        Book book1 = (Book) factory.getBean("book");
        Book book2 = (Book) factory.getBean("book");
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());

        System.out.println("------非单例------");
        Student student1 = (Student) factory.getBean("student");
        Student student2 = (Student) factory.getBean("student");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        System.out.println("-------依赖注入-------");
        StudentService studentService = (StudentService) factory.getBean("studentService");
        System.out.println(studentService.getStudentDao().hashCode());
        StudentDao studentDao = (StudentDao) factory.getBean("studentDao");
        System.out.println(studentDao.hashCode());


    }
}
