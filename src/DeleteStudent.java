import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteStudent {

    private JPanel panel1;
    private JTable table1;
    private JButton deleteRecordButton;

    public DeleteStudent(ArrayList<StudentInfo> list, JLabel countNum) {
        JFrame j =new JFrame();

        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        deleteRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    var data = model.getDataVector().elementAt(table1.getSelectedRow());
                    list.remove(table1.getSelectedRow());
                    model.removeRow(table1.getSelectedRow());
                    countNum.setText(String.valueOf(list.toArray().length));
                    JOptionPane.showMessageDialog(null, "Student deleted from record", "Information Message", JOptionPane.INFORMATION_MESSAGE);
                    j.dispose();
                } catch (Exception E){
                    JOptionPane.showMessageDialog(null, E.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
