package classs;
public class Student {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    public byte getAbsent() {
        return absent;
    }

    public void setAbsent(byte absent) {
        this.absent = absent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getPhone(String phone) {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private int id;//id
    private String name; //tên
    private String teachername;
    private byte mark; // điểm
    private byte absent; // số buổi vắng
    private String classStudent; // lớp

    public String getPhone() {
        return phone;
    }

    private String phone; // sdt
private String address; // địa chỉ
    private String gender; // giới tính
    public Student(int id, String name, String teachername,byte mark,byte absent,String classStudent,
                   String phone,String address,String gender) {
        super();
        this.id = id;
        this.name = name;
      this.teachername = teachername;
      this.mark = mark;
      this.absent = absent;
      this.classStudent = classStudent;
      this.phone = phone;
//      this.top = top;
      this.address = address;
      this.gender = gender;
    }
}


