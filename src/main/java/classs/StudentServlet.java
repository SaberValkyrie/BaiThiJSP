package classs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private List<Student> studentList;

    @Override
    public void init() throws ServletException {
        super.init();
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Nguyen Thanh Nam",
                "Dang Kim Thi",(byte) 80,(byte)2,"T2109A","0987654321","Ha Noi","Male"));
        studentList.add(new Student(2,"Nguyen Thanh Nu",
                "Dang Kim Thi",(byte) 90,(byte)7,"T2109A","0492994142","Ha Nam","Female"));
        studentList.add(new Student(3,"Tran Thanh Tam",
                "Dang Kim Thi",(byte) 1,(byte)2,"T2109A","0482394914","TP HCM","Female"));
        studentList.add(new Student(4,"Le Thi Thu Diem",
                "Dang Kim Thi",(byte) 20,(byte)3,"T2109A","0429149214","Da Nang","Male"));
        studentList.add(new Student(5,"Nguyen Dinh Hai",
                "Dang Kim Thi",(byte) 30,(byte)5,"T2109A","0418531595","Hoi An","Female"));
        studentList.add(new Student(6,"Nguyen Huy Vu",
                "Dang Kim Thi",(byte) 40,(byte)1,"T2109A","0421949214","Bac Giang","Male"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showStudentList(request, response);
        }else {
            switch (action) {
                case "new":
                    showCreateForm(request,response);
                    break;
                case "add":
                    addStudent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    editStudent(request,response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "search":
                    String searchItem = request.getParameter("searchItem");
                    List<Student> searchResults = searchStudent(searchItem);
                    request.setAttribute("studentList", searchResults);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "grade":
                    List<Student> sortedByMarks = sortStudentsByMarks();
                    request.setAttribute("studentList", sortedByMarks);
                    RequestDispatcher gradeDispatcher = request.getRequestDispatcher("student-list.jsp");
                    gradeDispatcher.forward(request, response);
                    break;

                default:
                    showStudentList(request, response);
                    break;
            }

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }


    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private List<Student> searchStudent(String searchItem) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(searchItem.toLowerCase()) // ten hs
            || student.getClassStudent().toLowerCase().contains(searchItem.toLowerCase()) // ten lop
                    || student.getTeachername().toLowerCase().contains(searchItem.toLowerCase()) // ten giao vien
            ) {
                searchResults.add(student);
            }
        }
        return searchResults;
    }

    private List<Student> sortStudentsByMarks() {
        List<Student> sortedList = new ArrayList<>(studentList);
        sortedList.sort(Comparator.comparingInt(Student::getMark).reversed());
        return sortedList;
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang tạo sản phẩm
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = studentList.size() + 1;
        String name = request.getParameter("name");
        String teachername = request.getParameter("teachername");
        byte mark = Byte.parseByte(request.getParameter("mark"));
        byte absent = Byte.parseByte(request.getParameter("absent"));
        String classStudent = request.getParameter("classStudent");
        String phone = request.getParameter("phone");
//        String top = request.getParameter("top");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");


        Student newStudent = new Student(id, name, teachername,mark,absent,classStudent,phone
        ,address,gender);
        studentList.add(newStudent);

        response.sendRedirect("students");

    }
        private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID sản phẩm cần chỉnh sửa từ request
        int studentID = Integer.parseInt(request.getParameter("id"));

        // Tìm sản phẩm trong danh sách theo ID
        Student students = getStudentsById(studentID);

        if (students == null) {
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            response.sendRedirect("students");
            return;
        }
            // Đặt sản phẩm vào attribute của request để hiển thị trên trang chỉnh sửa
            request.setAttribute("student", students);

            // Hiển thị trang chỉnh sửa sản phẩm
            RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
            dispatcher.forward(request, response);

    }
    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lấy thông tin từ request
        int studentsID = Integer.parseInt(request.getParameter("id"));
        // Tìm hs trong danh sách theo ID
        Student student = getStudentsById(studentsID);
        if (student == null){
            response.sendRedirect("students");
        }
        String name = request.getParameter("name");
        String teachername = request.getParameter("teachername");
        byte mark = Byte.parseByte(request.getParameter("mark"));
        byte absent = Byte.parseByte(request.getParameter("absent"));
        String classStudent = request.getParameter("classStudent");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");


            // Cập nhật thông tin sản phẩm
            student.setName(name);
student.setTeachername(teachername);
student.setMark(mark);
student.setAbsent(absent);
student.setClassStudent(classStudent);
student.setPhone(phone);
student.setAddress(address);
student.setGender(gender);
            // Chuyển hướng về trang danh sách
        response.sendRedirect("students");
    }


    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID cần xóa từ request
        int studentsID = Integer.parseInt(request.getParameter("id"));

        // Tìm sản phẩm trong danh sách theo ID
        Student students = getStudentsById(studentsID);

        if (students == null) {
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            response.sendRedirect("students");
        }
            // Xóa sản phẩm khỏi danh sách
            studentList.remove(students);

            // Chuyển hướng về trang danh sách sản phẩm
        response.sendRedirect("students");

    }

    private Student getStudentsById(int studentID) {
        for (Student students : studentList) {
            if (students.getId() == studentID) {
                return students;
            }
        }
        return null;
    }
}
