package week4;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class bai5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Sắp xếp danh sách sinh viên bằng Comparator
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 1. So sánh CGPA giảm dần
                if (s2.getCgpa() != s1.getCgpa()) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                }
                // 2. So sánh Tên (fname) theo bảng chữ cái
                else if (!s1.getFname().equals(s2.getFname())) {
                    return s1.getFname().compareTo(s2.getFname());
                }
                // 3. So sánh ID tăng dần
                else {
                    return Integer.compare(s1.getId(), s2.getId());
                }
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}
