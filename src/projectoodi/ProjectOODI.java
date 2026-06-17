package projectoodi;

import javax.swing.SwingUtilities;

public class ProjectOODI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LoginPage login = new LoginPage();
            login.setLocationRelativeTo(null); 
            login.setVisible(true);

        });

    }
}