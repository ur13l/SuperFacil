package superfacil.com.superfacil.model;

import io.realm.RealmObject;

/**
 * Created by edgarperez on 4/23/16.
 */
public class Product extends RealmObject{

    private int id;
    private String nombre;
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
