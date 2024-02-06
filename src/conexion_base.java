import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class conexion_base {
    private JButton comprobacionButton;
    JPanel panel1;


    public conexion_base() {
        comprobacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Nombre de la clase de la conexion
                conexionbd miconexion=new conexionbd();
                // Conexion con la base de datos
                miconexion.conexionlocaL("jdbc:mysql://localhost:3306/trabajos","root","");
                //
                //mensaje1.setText(miconexion.getMensaje());
            }
        });
    }
}
