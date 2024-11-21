package student_management;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentManagementSystem extends JFrame {
    private JTextField txtId, txtName, txtAge, txtGender, txtDepartment;
    private JButton btnAdd, btnUpdate, btnDelete, btnView;
    private JTable table;
    private DefaultTableModel model;

    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Student ID:"));
        txtId = new JTextField();
        formPanel.add(txtId);
        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);
        formPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        formPanel.add(txtAge);
        formPanel.add(new JLabel("Gender:"));
        txtGender = new JTextField();
        formPanel.add(txtGender);
        formPanel.add(new JLabel("Department:"));
        txtDepartment = new JTextField();
        formPanel.add(txtDepartment);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnView = new JButton("View");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnView);

        // Create table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Department"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add panels to frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });
    }

    private void addStudent() {
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String gender = txtGender.getText();
        String department = txtDepartment.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "Muzammil Mohammad", "7893735818")) {
            String sql = "INSERT INTO students (name, age, gender, department) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, department);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String gender = txtGender.getText();
        String department = txtDepartment.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "Muzammil Mohammad", "7893735818")) {
            String sql = "UPDATE students SET name = ?, age = ?, gender = ?, department = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, department);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student updated successfully!");
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        int id = Integer.parseInt(txtId.getText());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "Muzammil Mohammad", "7893735818")) {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage());
        }
    }

    private void viewStudents() {
        model.setRowCount(0); // Clear existing rows
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "Muzammil Mohammad", "7893735818")) {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String department = rs.getString("department");
                model.addRow(new Object[]{id, name, age, gender, department});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving students: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtDepartment.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagementSystem().setVisible(true);
        });
    }
}