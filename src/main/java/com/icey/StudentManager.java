package com.icey;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 学生管理系统
 *
 */
public class StudentManager {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("--------------1.添加学生---------------");
            System.out.println("--------------2.删除学生---------------");
            System.out.println("--------------3.修改学生---------------");
            System.out.println("--------------4.查看所有学生-----------");
            System.out.println("--------------5.退出系统---------------");
            System.out.println("请输入对应标号做出选择:");
            String i = sc.nextLine();
            switch (i) {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用!");
                    sc.close();
                    array.clear();
                    System.exit(0);// 终止当前正在运行的 Java 虚拟机。
                default:
                    System.out.println("输入有误,请重新输入");
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        String sid;
        while (true) {
            System.out.println("请输入学生学号:");
            sid = sc.nextLine();
            boolean flag = false;
            for (int i = 0; i < array.size(); i++) {
                if (sid.equals(array.get(i).getSid())) {
                    flag = true;
                    System.out.println("该学号已存在,按1重新输入,按2返回系统");
                    while (true) {
                        String line = sc.nextLine();
                        switch (line) {
                            case "1":
                                break;
                            case "2":
                                return;
                            default:
                                System.out.println("请输入1或2");
                        }
                        break;
                    }
                    break;
                }
            }
            if (flag == false) {
                break;
            }
        }
        Student stu = new Student();
        stu.setSid(sid);
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        stu.setName(name);
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();
        stu.setAge(age);
        System.out.println("请输入学生籍贯:");
        String address = sc.nextLine();
        stu.setAddress(address);
        array.add(stu);
        System.out.println("添加成功!");
    }

    public static void deleteStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("系统空空的,先加点什么吧!");
            return;
        }
        System.out.println("请输入你要删除的学生学号:");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            if (sid.equals(array.get(i).getSid())) {
                array.remove(i);
                System.out.println("删除成功!");
                return;
            }
        }
        System.out.println("输入的学生学号不存在!");
    }

    public static void updateStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("系统空空的,先加点什么吧!");
            return;
        }
        System.out.println("请输入你要修改的学生学号:");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            if (sid.equals(array.get(i).getSid())) {
                Student stu = new Student();
                stu.setSid(sid);
                System.out.println("请输入学生新姓名:");
                String name = sc.nextLine();
                stu.setName(name);
                System.out.println("请输入学生新年龄:");
                String age = sc.nextLine();
                stu.setAge(age);
                System.out.println("请输入学生新籍贯:");
                String address = sc.nextLine();
                stu.setAddress(address);
                array.set(i, stu);
                System.out.println("修改成功!");
                return;
            }
        }
        System.out.println("输入的学生学号不存在!");
    }

    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("系统空空的,先加点什么吧!");
            return;// 对于空返回值方法,return;语句后程序不再向下执行
        }
        System.out.println("学号\t姓名\t年龄\t籍贯");// \t:补全当前字符串长度到8的整数倍,最少1个最多8个空格,补多少看\t前字符串长度
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }
}