package superfacil.com.superfacil.model;

import java.util.Date;

/**
 * Created by Uriel on 23/04/2016.
 */
public class Compra {
    private long idCompra;
    private Date fecha;
    private Date fechaEntrega;
    private boolean entregado;
    private boolean enCamino;
    private float subtotal;
    private float iva;
    private float total;

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public boolean isEnCamino() {
        return enCamino;
    }

    public void setEnCamino(boolean enCamino) {
        this.enCamino = enCamino;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
