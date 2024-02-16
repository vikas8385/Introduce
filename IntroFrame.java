import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.*;
import java.sql.Statement;

import javax.swing.*;

public class IntroFrame extends JFrame {
    JLabel message;
    JLabel nameLabel, fathernameLabel, genderLabel, addressLabel, contectLabel;
    JTextField nameField;
    JTextField fathernameField;
    JRadioButton genderMale, genderFemale;
    ButtonGroup genderGroup;
    JTextField addressField;
    JTextField contectField;
    JButton introButton;
    Container container;

    public IntroFrame() {
        message = new JLabel("Please Give Your Information");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        fathernameLabel = new JLabel("Father,s Name");
        fathernameField = new JTextField();
        genderLabel = new JLabel("Gender");
        genderMale = new JRadioButton("Male", true);
        genderFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        addressLabel = new JLabel("Address");
        addressField = new JTextField();
        contectLabel = new JLabel("Mobile No");
        contectField = new JTextField();
        introButton = new JButton("Submit");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
    }

    public void setBounds() {
        message.setBounds(50, 10, 300, 20);
        nameLabel.setBounds(20, 60, 40, 60);
        nameField.setBounds(150, 80, 200, 20);
        fathernameLabel.setBounds(20, 90, 100, 60);
        fathernameField.setBounds(150, 110, 200, 20);
        genderLabel.setBounds(20, 120, 700, 60);
        genderMale.setBounds(150, 140, 70, 20);
        genderFemale.setBounds(250, 140, 70, 20);
        addressLabel.setBounds(20, 150, 70, 60);
        addressField.setBounds(150, 170, 200, 20);
        contectLabel.setBounds(20, 180, 70, 60);
        contectField.setBounds(150, 200, 200, 20);
        introButton.setBounds(130, 240, 80, 40);
    }

    public void addComponents() {
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(fathernameLabel);
        container.add(fathernameField);
        container.add(genderLabel);
        container.add(genderMale);
        container.add(genderFemale);
        container.add(addressLabel);
        container.add(addressField);
        container.add(contectLabel);
        container.add(contectField);
        container.add(introButton);
    }

    public static void main(String[] args) throws Exception {
        IntroFrame frame = new IntroFrame();
        frame.setTitle("General Information");
        frame.setVisible(true);
        frame.setBounds(400, 50, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        String url = "jdbc:mysql://localhost:3306/demo";
        String uname = "root";
        String pass = "jainvikas@9649";
        String query = "select * from new_table";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString("Name");
        System.out.println(name);
        st.close();
        con.close();
    }
}
