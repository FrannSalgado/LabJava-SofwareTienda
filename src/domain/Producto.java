package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Producto {
    protected String descripcion;
    protected String identificadorAlfNum;
    protected int sotck;
    protected float precio;
    protected float gananciaPorcentual;
    protected boolean disponibilidad;
    protected boolean esImportado;
    protected float descuento;


    public Producto(String identificadorAlfNum, String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad, boolean esImportado,float descuento) {
        if (identificadorAlfNum.length() != 5) {
            throw new IllegalArgumentException("El identificador debe tener 5 caracteres.");
        }
        this.esImportado=esImportado;
        this.descripcion = descripcion;
        this.identificadorAlfNum = identificadorAlfNum;
        this.sotck = stock;
        this.precio = precio;
        this.gananciaPorcentual = ganaciaPorcentual;
        this.disponibilidad = disponibilidad;
        this.descuento=descuento;
        if(descuento <0 ){
                throw new IllegalArgumentException("El descuento No puede ser menor a 0%");
        }

    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificadorAlfNum() {
        return identificadorAlfNum;
    }

    public void setIdentificadorAlfNum(String identificadorAlfNum) {
        if (identificadorAlfNum.length() == 5) {
            this.identificadorAlfNum = identificadorAlfNum;
        } else {
            throw new IllegalArgumentException("El identificador debe tener 5 caracteres.");
        }
    }

    public int getSotck() {
        return sotck;
    }

    public void setSotck(int sotck) {
        this.sotck = sotck;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getGanaciaPorcentual() {
        return gananciaPorcentual;
    }

    public void setGanaciaPorcentual(float ganaciaPorcentual) {
        this.gananciaPorcentual = ganaciaPorcentual;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float calcularPrecioVenta() {
        float precioConGanacia= precio + (precio * gananciaPorcentual / 100);
        if (esImportado==true){
            float precioConImpuesto = precioConGanacia + (precioConGanacia * 12 / 100);
            return precioConImpuesto - (precioConImpuesto * descuento/ 100);
        }
        else {return precioConGanacia - (precioConGanacia * descuento/ 100);}

    }

    protected static String generarCodigo(String codigoAlfaUnico, int contadorProducto) {
        contadorProducto++;
        return String.format(codigoAlfaUnico + "%03d", contadorProducto);
    }

    public void descontarStock(int sotckADescontar) {
        this.sotck = getSotck() - sotckADescontar;
        if (sotck == 0) {
            disponibilidad = false;
        }
    }



    public void mostrarInfoProducto() {
        System.out.println("----------------------------|----------------------------");
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());
        System.out.println("Descuento: " + descuento +"%" );
        System.out.println("----------------------------|----------------------------");


    }


}
