 /*
  * Justin Morrow - 05/17/26
  * Modified Null_Layout_8.java GUI example from the original by Professor Darrell Payne from Bellevue University
  * Modified to work with the "fans" table in databasedb
  * GUI with First, Previous, Next, Last, and Exit buttons to navigate database records using SelectFansData
  */


 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 public class Null_Layout_Fans extends JFrame {

     SelectFansData selectData = new SelectFansData();

     private JButton btnFirst;
     private JButton btnPrevious;
     private JButton btnNext;
     private JButton btnLast;
     private JButton btnExit;

     private JTextField txtId;
     private JTextField txtFirstName;
     private JTextField txtLastName;
     private JTextField txtFavoriteTeam;

     private JLabel lblId;
     private JLabel lblFirstName;
     private JLabel lblLastName;
     private JLabel lblFavoriteTeam;

     private ActionListener buttonListener = new ActionListener() {

         public void actionPerformed(ActionEvent e) {

             String buttonSelected = ((JButton)e.getSource()).getText();

             if (buttonSelected.equals("First")) {
                 update(selectData.getFirst());
             }

             if (buttonSelected.equals("Previous")) {
                 update(selectData.getPrevious());
             }

             if (buttonSelected.equals("Next")) {
                 update(selectData.getNext());
             }

             if (buttonSelected.equals("Last")) {
                 update(selectData.getLast());
             }

             if (buttonSelected.equals("Exit")) {
                 System.exit(0);
             }
         }
     };

     public Null_Layout_Fans() {

         super("Justin's Sports Fan Database Entries");

         btnFirst = new JButton("First");
         btnPrevious = new JButton("Previous");
         btnNext = new JButton("Next");
         btnLast = new JButton("Last");
         btnExit = new JButton("Exit");

         txtId = new JTextField();
         txtFirstName = new JTextField();
         txtLastName = new JTextField();
         txtFavoriteTeam = new JTextField();

         lblId = new JLabel("ID");
         lblFirstName = new JLabel("First Name");
         lblLastName = new JLabel("Last Name");
         lblFavoriteTeam = new JLabel("Favorite Team");

         txtId.setEditable(false);
         txtFirstName.setEditable(false);
         txtLastName.setEditable(false);
         txtFavoriteTeam.setEditable(false);
     }

     public void launchJFrame() {

         setSize(500, 300);
         getContentPane().setLayout(null);
         getContentPane().setBackground(Color.white);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         getContentPane().add(btnFirst);
         getContentPane().add(btnPrevious);
         getContentPane().add(btnNext);
         getContentPane().add(btnLast);
         getContentPane().add(btnExit);

         getContentPane().add(txtId);
         getContentPane().add(txtFirstName);
         getContentPane().add(txtLastName);
         getContentPane().add(txtFavoriteTeam);

         getContentPane().add(lblId);
         getContentPane().add(lblFirstName);
         getContentPane().add(lblLastName);
         getContentPane().add(lblFavoriteTeam);

         lblId.setBounds(65, 10, 120, 25);
         lblFirstName.setBounds(65, 45, 120, 25);
         lblLastName.setBounds(65, 80, 120, 25);
         lblFavoriteTeam.setBounds(65, 115, 120, 25);

         txtId.setBounds(210, 10, 150, 25);
         txtFirstName.setBounds(210, 45, 150, 25);
         txtLastName.setBounds(210, 80, 150, 25);
         txtFavoriteTeam.setBounds(210, 115, 150, 25);

         btnFirst.setBounds(10, 200, 90, 30);
         btnPrevious.setBounds(100, 200, 90, 30);
         btnNext.setBounds(190, 200, 90, 30);
         btnLast.setBounds(280, 200, 90, 30);
         btnExit.setBounds(370, 200, 90, 30);

         setVisible(true);

         btnFirst.addActionListener(buttonListener);
         btnPrevious.addActionListener(buttonListener);
         btnNext.addActionListener(buttonListener);
         btnLast.addActionListener(buttonListener);
         btnExit.addActionListener(buttonListener);
     }

     private void update(FanRecord record) {

         txtId.setText(record.getId());
         txtFirstName.setText(record.getFirstName());
         txtLastName.setText(record.getLastName());
         txtFavoriteTeam.setText(record.getFavoriteTeam());
     }

     public static void main(String[] args) {

         Null_Layout_Fans layout = new Null_Layout_Fans();
         layout.launchJFrame();
     }
 }