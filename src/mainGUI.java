import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class mainGUI extends StudentInfo{
    //GUI items
    static JFrame jFrame = new JFrame();
    private JPanel mainscreen;
    private JButton addStudentButton;
    private JButton deleteStudentButton;
    private JButton searchStudentButton;
    private JButton updateStudentButton;
    private JButton generateAFileButton;
    public JLabel countNum;

    //vars---
    ArrayList<StudentInfo> studentInfoArrayList = new ArrayList<StudentInfo>();



    public mainGUI(){

        countNum.setText(String.valueOf(studentInfoArrayList.toArray().length));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(mainscreen.getMinimumSize());
        jFrame.add(mainscreen);

        jFrame.setVisible(true);

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==addStudentButton){
                    AddStudent W = new AddStudent(studentInfoArrayList , countNum);
                }

            }
        });

        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==updateStudentButton){
                    UpdateStudent W = new UpdateStudent(studentInfoArrayList);
                }
            }
        });

        generateAFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter writer = null;
                try {
                    writer = new FileWriter("studentRecords.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                for(StudentInfo stud: studentInfoArrayList) {
                    try {
                        writer.write(MessageFormat.format("\s{0}\t{1}\t{2}\t\t{3}\t{4}\t{5}\n"
                                , stud.getStudentId()
                                , stud.getFirstName()
                                , stud.getLastName()
                                , stud.getAge()
                                , stud.getEmail()
                                , stud.getStudentLevel()));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                try {
                    writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==searchStudentButton){
                    SearchStudent W = new SearchStudent(studentInfoArrayList);
                }
            }
        });
        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==deleteStudentButton){
                    DeleteStudent W = new DeleteStudent(studentInfoArrayList ,countNum);
                }
            }
        });
    }

    public static void main(String[] args) {

         new mainGUI();

    }
}
