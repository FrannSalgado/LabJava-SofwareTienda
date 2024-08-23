package domain;

public class Bebida extends Producto {
    private static final String ALFA_CODE_BEBIDA= "AC";
    private int graduacionAlcoholica;
    private static int cantidadRegistrada = 0;
    private boolean esImportado;

    public Bebida( String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad, int graduacionAlcoholica, boolean esImportado) {
        super(generarCodigo(ALFA_CODE_BEBIDA, cantidadRegistrada), descripcion, stock, precio, ganaciaPorcentual, disponibilidad);
        this.cantidadRegistrada++;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.esImportado = esImportado;
    }

    public int getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(int graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean getEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }
    @Override
    public void mostrarInfoProducto() {
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Alcohol: : " + graduacionAlcoholica + "%");
        System.out.println("Importado: " + (esImportado ? "Sí" : "No"));
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());



    }

}
