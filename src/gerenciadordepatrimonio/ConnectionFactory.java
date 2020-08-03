/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.security.AuthProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor Hugo
 */
public class ConnectionFactory {

    String con = "jdbc:mysql://localhost:3306/patrimonio?serverTimezone=UTC";
    private String user = "root";
    private String pass = "12345";

    Properties properties = new Properties();

    public static ConnectionFactory getConnection() {
        ConnectionFactory connection = null;
        if (connection == null) {
            connection = new ConnectionFactory();
            return connection;
        } else {
            return null;
        }
    }

    public Connection Conn() {
        try {
            return DriverManager.getConnection(con, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e, "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
