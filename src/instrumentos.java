import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class instrumentos {
    int id;
    String nombre;
    String tipo;
    double precio;
    String caracteristicas;

    String foto;

    // Setear estos datos del objeto en donde se va a generar el constructor y sin valores y con setter y getters
    //Constructor con atributos
    public instrumentos(int id, String nombre, String tipo, double precio, String caracteristicas,String foto) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.foto=foto;
    }
    //Constructor sin atributos

    public instrumentos() {
    }


    // Setters y Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    // Metodo personalizado de agregacion a la base
    public boolean InsertarItemBD(String nombre, String tipo, double precio, String caracteristicas, String foto){
        try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajos","root","")){
            // Formato para insertar los valores
            String sql="INSERT INTO instrumentos(nombre,tipo,precio,caracteristicas,foto)VALUES(?,?,?,?,?)";
            //Para verificar si no estar repetidos los datos
            try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                // Setear los valores String.valueOf(nota1)
                preparedStatement.setString(1, this.nombre);
                preparedStatement.setString(2, this.tipo);
                preparedStatement.setString(3, String.valueOf(this.precio));
                preparedStatement.setString(4, this.caracteristicas);
                preparedStatement.setString(5, this.foto);

                int filasAfectadas=preparedStatement.executeUpdate();
                if(filasAfectadas>0){
                    System.out.println("Inserccion exitosa");

                }else{
                    System.out.println("Inserto de datos fallido");
                }

            }catch (Exception e){
                e.printStackTrace();
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

//    CREATE TABLE `proyectos`. (`id` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(50) NOT NULL , `tipo` VARCHAR(50) NOT NULL , `precio` DOUBLE NOT NULL ,
//            `caracteristicas` VARCHAR(150) NOT NULL , `foto` BLOB NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
}
