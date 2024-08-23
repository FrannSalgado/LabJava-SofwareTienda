package domain;

public class Envasado extends Producto {
    private static final String ALFA_CODE_ENVASADO = "AB";
    protected String tipoDeEnvase;
    protected boolean esImportado;
    private static int cantidadRegistrada = 0;




    public Envasado(String descripcion, int stock, float precio, float gananciaPorcentual, boolean disponibilidad, String tipoDeEnvase, boolean esImportado) {
        super(generarCodigo(ALFA_CODE_ENVASADO,cantidadRegistrada), descripcion, stock, precio, gananciaPorcentual, disponibilidad);
        this.cantidadRegistrada++;
        this.tipoDeEnvase = tipoDeEnvase;
        this.esImportado = esImportado;

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
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de Envase: " + tipoDeEnvase);
        System.out.println("Importado: " + (esImportado ? "Sí" : "No"));
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());



    }


}
