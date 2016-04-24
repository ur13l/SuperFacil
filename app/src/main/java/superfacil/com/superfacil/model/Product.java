package superfacil.com.superfacil.model;

/**
 * Created by edgarperez on 4/23/16.
 */
public class Product {

    private int id;
    private String nombre;
    private int image;
    private double precio;

    public Product(){

    }

    public Product(int id){
        this.id = id;
    }

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
