import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Conexion con la base en "src" click derecho abrir el modulo de configuración
        // Establece la conexion desde la clase "conexiondb" y se muestra en consola con lo siguiente:
        JFrame principal = new JFrame("Ingreso de calificaciones");
        principal.setContentPane(new conexion_base().panel1);
        //principal.setContentPane(new menuInsertion().for);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.pack();
        principal.setSize(800, 500);
        principal.setLocationRelativeTo(null); // Centrar la ventana
        principal.setVisible(true);

        //Instrumentos parte
        instrumentos miinstrumento = new instrumentos();
        // Setear los valores quemados con los set

        System.out.println(" Primer Instrumento ");
        miinstrumento.setNombre("Guitarra");
        miinstrumento.setTipo("Española");
        miinstrumento.setPrecio(400.80);
        miinstrumento.setCaracteristicas("Guitarra clasica");
        miinstrumento.setFoto("null");

        // Getters
        miinstrumento.InsertarItemBD(miinstrumento.getNombre(),miinstrumento.getTipo(),miinstrumento.getPrecio(),miinstrumento.getCaracteristicas(),miinstrumento.getFoto());

    }
}