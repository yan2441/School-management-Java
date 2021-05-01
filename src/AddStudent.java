import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudent {

    public static int specialID = 100;
    private JPanel panel1;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField agetxt;
    private JTextField emailTxt;
    private JButton addStudentButton;
    private JButton backButton;
    private JRadioButton sophomoreRadioButton;
    private JRadioButton juniorRadioButton;
    private JRadioButton seniorRadioButton;



    public AddStudent(ArrayList<StudentInfo> list, JLabel countNum){
        JFrame j =new JFrame();

        ButtonGroup group = new ButtonGroup();
        group.add(sophomoreRadioButton);
        group.add(juniorRadioButton);
        group.add(seniorRadioButton);
        sophomoreRadioButton.setActionCommand("sophomore");
        juniorRadioButton.setActionCommand("junior");
        seniorRadioButton.setActionCommand("senior");

        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setSize(panel1.getMinimumSize());
        j.add(panel1);
        j.setVisible(true);

        backButton.addActionListener(e -> j.dispose());

        addStudentButton.addActionListener(e -> {
            StudentInfo add= new StudentInfo();

            add.setStudentId(++specialID);

            checkNameExist((firstname.getText().substring(0,1).toUpperCase()+firstname.getText().substring(1).toLowerCase()),
                            (lastname.getText().toUpperCase()), list);
            add.setFirstName(firstname.getText().substring(0,1).toUpperCase()+firstname.getText().substring(1).toLowerCase());
            add.setLastName(lastname.getText().toUpperCase());

            add.setAge(checkAge(Integer.parseInt(agetxt.getText())));

            add.setStudentLevel(group.getSelection().getActionCommand());

            if (checkEmail(emailTxt.getText())) {
                    add.setEmail(emailTxt.getText());
            }else{

                JOptionPane.showMessageDialog(null," the email not valid" ,"error",JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("the email not valid example : john@univ.com");
            }
            list.add(list.size(),add);

            JOptionPane.showMessageDialog(null, "Student added to record", "Information Message", JOptionPane.INFORMATION_MESSAGE);
            countNum.setText(String.valueOf(list.toArray().length));

            j.dispose();
        });



    }
    public void checkNameExist(String fn,String ln,ArrayList<StudentInfo> list) {
        for (StudentInfo st:list) {
            if ((fn.equals(st.getFirstName())) && (ln.equals(st.getLastName()))){
                JOptionPane.showMessageDialog(null," the name already in record" ,"error",JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("-------> the name already in record <--------");
            }
        }
    }

    public boolean checkEmail(String email){
            Pattern p = Pattern.compile("(^[a-zA-Z])([a-z0-9._%+-]{3,})+@univ+\\.com$");
            Matcher m = p.matcher(email);
            return m.find() && m.group().equals(email);
    }
    public int checkAge(int age) {
        if (age < 16) {
            JOptionPane.showMessageDialog(null," You must be at least 16 years old" ,"error",JOptionPane.ERROR_MESSAGE);
            throw new ArithmeticException("You must be at least 16 years old.");
        }
        else {
            return age;
        }
    }

}

