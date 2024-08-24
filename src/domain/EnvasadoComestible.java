package domain;

import java.time.DateTimeException;
import java.time.LocalDate;


public class EnvasadoComestible extends Envasado {
    private LocalDate vencimiento;
    private int calorias;

    public EnvasadoComestible(String descripcion, int stock, float precio, float gananciaPorcentual, boolean disponibilidad, String tipoDeEnvase, boolean esImportado, LocalDate vencimiento, int calorias, float descuento) {
        super(descripcion, stock, precio, gananciaPorcentual, disponibilidad, tipoDeEnvase, esImportado, descuento);
        this.calorias = calorias;
        this.vencimiento = vencimiento;
        if (gananciaPorcentual > 20) {
            throw new IllegalArgumentException("La ganancia en productos Comestibles no puede superar el 20%");
        }
        if (descuento > 15) {
            throw new IllegalArgumentException("El descuento No puede ser Mayor a 15%");
        }

    }

    public static LocalDate fechaVencimientoYYYY_MM_DD(int anio, int mes, int dia) {
        try {
             return LocalDate.of(anio, mes, dia);

        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Ingrese una Fecha Valida" );

        }
    }
    @Override
    public void mostrarInfoProducto() {
        System.out.println("----------------------------|----------------------------");
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de Envase: " + tipoDeEnvase);
        System.out.println("Importado: " + (esImportado ? "Sí" : "No"));
        System.out.println("Fecha de vencimiento: " + vencimiento);
        System.out.println("Calorias:  " + calorias);
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());
        System.out.println("Descuento: " + descuento + "%");
        System.out.println("----------------------------|----------------------------");


    }
}
