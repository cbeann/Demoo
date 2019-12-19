package myioc.entity;

/**
 * @author CBeann
 * @create 2019-12-18 10:06
 */
public class StudentService {

    private StudentDao studentDao;
    public void speak() {
        System.out.println("-----StudentService------");
    }

    public StudentService() {
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
