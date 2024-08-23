package domain;

public class Bebida extends Producto {
    private static final String ALFA_CODE_BEBIDA= "AC";
    private float graduacionAlcoholica;
    private static int cantidadRegistrada = 0;

    private double  calorias;

    public Bebida( String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad, float graduacionAlcoholica, boolean esImportado, double calorias, float descuento) {
        super(generarCodigo(ALFA_CODE_BEBIDA, cantidadRegistrada), descripcion, stock, precio, ganaciaPorcentual, disponibilidad, esImportado,descuento);
        this.cantidadRegistrada++;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.calorias= calcularCalorias( graduacionAlcoholica, calorias);
        if(descuento >10 ){
            throw new IllegalArgumentException("El descuento No puede ser Mayor a 10%");
        }
    }
    private double  calcularCalorias(float graduacionAlcoholica, double calorias){
        double resultadoCalorias ;
        if (graduacionAlcoholica >= 0 && graduacionAlcoholica <= 2) {
            return calorias ;
        } else if (graduacionAlcoholica > 2 && graduacionAlcoholica <= 4.5) {
            resultadoCalorias = calorias * 1.25;
        } else if (graduacionAlcoholica > 4.5) {
            resultadoCalorias = calorias * 1.5;
        } else {
            throw new IllegalArgumentException("Las calorias no pueden ser menores a 0 ");
        }
        return resultadoCalorias;
    }

    public float getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(float graduacionAlcoholica) {
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
        System.out.println("----------------------------|----------------------------");
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Alcohol: : " + graduacionAlcoholica + "%");
        System.out.println("Calorias: " + calorias);
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
