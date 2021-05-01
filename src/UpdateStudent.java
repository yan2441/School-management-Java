import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateStudent {
    private JPanel panel1;
    private JTextField updtFname;
    private JTextField updtLname;
    private JTextField updtAge;
    private JButton modifyButton;
    private JTextField updtEmail;
    private JRadioButton sophomoreUpdt;
    private JRadioButton juniorUpdt;
    private JRadioButton seniorUpdt;
    private JTable table1;
    private JButton moveDataToFieldsButton;


    public UpdateStudent(ArrayList<StudentInfo> list){
        JFrame j =new JFrame();

        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ButtonGroup group = new ButtonGroup();
        group.add(sophomoreUpdt);
        group.add(juniorUpdt);
        group.add(seniorUpdt);
        sophomoreUpdt.setActionCommand("sophomore");
        juniorUpdt.setActionCommand("junior");
        seniorUpdt.setActionCommand("senior");
        j.setSize(panel1.getPreferredSize());
        j.add(panel1);

        DefaultTableModel model = new DefaultTableModel();
        Object[] column ={"ID","First name","Last name","Age","Level","Email"};
        model.setColumnIdentifiers(column);

        Object[] row = new Object[6];
        for (StudentInfo studentInfo : list) {
            row[0] = studentInfo.getStudentId();
            row[1] = studentInfo.getFirstName();
            row[2] = studentInfo.getLastName();
            row[3] = studentInfo.getAge();
            row[4] = studentInfo.getStudentLevel();
            row[5] = studentInfo.getEmail();
            model.addRow(row);
        }
        table1.setModel(model);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        j.setVisible(true);

        moveDataToFieldsButton.addActionListener(e -> {
            var data = model.getDataVector().elementAt(table1.getSelectedRow());
            updtFname.setText((String) data.get(1)) ;
            updtLname.setText((String) data.get(2));
            updtAge.setText(String.valueOf(data.get(3)));
            String radio = (String) data.get(4);
            if (radio.equals("sophomore")) {
                sophomoreUpdt.setSelected(true);
            }else if (radio.equals("junior")){
                juniorUpdt.setSelected(true);
            }else {
                seniorUpdt.setSelected(true);
            }
            updtEmail.setText((String) data.get(5));
        });

        modifyButton.addActionListener(e -> {
            StudentInfo add= new StudentInfo();

            add.setStudentId(list.get(table1.getSelectedRow()).getStudentId());

            add.setFirstName(updtFname.getText().substring(0,1).toUpperCase()+updtFname.getText().substring(1).toLowerCase());
            add.setLastName(updtLname.getText().toUpperCase());

            add.setAge(checkAge(Integer.parseInt(updtAge.getText())));

            add.setStudentLevel(group.getSelection().getActionCommand());

            if (checkEmail(updtEmail.getText())) {
                add.setEmail(updtEmail.getText());
            }else{

                JOptionPane.showMessageDialog(null," the email not valid" ,"error",JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("the email not valid example : john@univ.com");
            }
            list.set(table1.getSelectedRow(),add);

            JOptionPane.showMessageDialog(null, "Student record has been updated", "Information Message", JOptionPane.INFORMATION_MESSAGE);

            j.dispose();
        });


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

    public boolean checkEmail(String email){
        Pattern p = Pattern.compile("([a-zA-Z])([a-z0-9._%+-]{3,})+@univ+\\.com");
        Matcher m = p.matcher(email);
        return m.find() && m.group().equals(email);
    }

}
