import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchStudent {
    private JPanel panel1;
    private JTextField lname;
    private JTextField fname;
    private JButton searchButton;
    private JLabel agelabel;
    private JLabel levellabel;
    private JLabel agetxt;
    private JLabel leveltxt;
    private JLabel emailtxt;
    private JLabel idtxt;
    private JPanel searchresult;
    private JButton searchAgainButton;
    private JPanel research;

    public SearchStudent(ArrayList<StudentInfo> list) {
        JFrame j =new JFrame();
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setSize(panel1.getMinimumSize());
        j.add(panel1);
        j.setVisible(true);
        searchresult.setVisible(false);
        research.setVisible(false);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!list.isEmpty()) {
                 if (fname.getText().equals("") && lname.getText().equals("")) {
                       JOptionPane.showMessageDialog(null, "  one or both text fields are empty  ", "error", JOptionPane.ERROR_MESSAGE);
                       throw new IllegalArgumentException("-------> one or both text fields are empty <--------");
                 } else{
                for (StudentInfo studentInfo : list) {
                    fname.setText(fname.getText().substring(0,1).toUpperCase()+fname.getText().substring(1).toLowerCase());
                    lname.setText(lname.getText().toUpperCase());
                    if (fname.getText().equals(studentInfo.getFirstName()) && lname.getText().equals(studentInfo.getLastName())) {
                            searchresult.setVisible(true);
                            agetxt.setText(String.valueOf(studentInfo.getAge()));
                            leveltxt.setText(studentInfo.getStudentLevel());
                            emailtxt.setText(studentInfo.getEmail());
                            idtxt.setText(String.valueOf(studentInfo.getStudentId()));
                            research.setVisible(true);
                    }
                }
                if (!searchresult.isVisible()){
                           JOptionPane.showMessageDialog(null, "  name does not exist  ", "error", JOptionPane.ERROR_MESSAGE);
                         throw new IllegalArgumentException("-------> the name not found <--------");
                  }
                  }
              }else {
                    JOptionPane.showMessageDialog(null, "  record is empty  ", "error", JOptionPane.ERROR_MESSAGE);
                   throw new ArrayIndexOutOfBoundsException("-------> record is empty <--------");
               }

            }
        });
        searchAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchresult.setVisible(false);
                research.setVisible(false);
            }
        });
    }

}
