public class StudentInfo {


    private int StudentId ;
    private String FirstName ; //first letter upper case
    private String lastName ; //all letter upper case
    //NO DUPLICATE FULL NAME
    private int age ; // >= 16
    private String studentLevel;// (Sophomore, Junior, Senior)
    private String Email ;

    public StudentInfo() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
