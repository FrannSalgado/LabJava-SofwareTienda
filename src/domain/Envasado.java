package domain;

public class Envasado extends Producto {
    private static final String ALFA_CODE_ENVASADO = "AB";
    protected String tipoDeEnvase;

    private static int cantidadRegistrada = 0;




    public Envasado(String descripcion, int stock, float precio, float gananciaPorcentual, boolean disponibilidad, String tipoDeEnvase, boolean esImportado , float descuento) {
        super(generarCodigo(ALFA_CODE_ENVASADO,cantidadRegistrada), descripcion, stock, precio, gananciaPorcentual, disponibilidad, esImportado , descuento);
        this.cantidadRegistrada++;
        this.tipoDeEnvase = tipoDeEnvase;
        if(descuento >15 ){
            throw new IllegalArgumentException("El descuento No puede ser Mayor a 15%");
        }

    }

    public String getTipoDeEnvase() {
        return tipoDeEnvase;
    }

    public void setTipoDeEnvase(String tipoDeEnvase) {
        this.tipoDeEnvase = tipoDeEnvase;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }



    @Override
    public void mostrarInfoProducto() {
        System.out.println("----------------------------|----------------------------");
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de Envase: " + tipoDeEnvase);
        System.out.println("Importado: " + (esImportado ? "Sí" : "No"));
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());
        System.out.println("Descuento: " + descuento +"%" );
        System.out.println("----------------------------|----------------------------");



    }


}
