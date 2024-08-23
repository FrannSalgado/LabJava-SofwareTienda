package domain;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class EnvasadoComestible extends Envasado {
    private LocalDate vencimiento;
    private int calorias;

    public EnvasadoComestible(String descripcion, int stock, float precio, float gananciaPorcentual, boolean disponibilidad, String tipoDeEnvase, boolean esImportado,LocalDate vencimiento, int calorias) {
        super(descripcion, stock, precio, gananciaPorcentual, disponibilidad, tipoDeEnvase, esImportado);
        this.calorias = calorias;
        this.vencimiento=vencimiento;

    }

    public static LocalDate fechaVencimientoYYYY_MM_DD(int anio, int mes, int dia) {
        try {
            return LocalDate.of(anio, mes, dia);

        } catch (DateTimeException e) {
            System.out.println("|---------------------------------------------------------------------|");
            System.out.println("|                ##/##/##/##/##_ATENCION_##/##/##/##/##               |");
            System.out.println("|                   Fecha de vencimiento no válida                    |");
            System.out.println("|   Se asignara la siguiente fecha '6060.01.01' modifique mas tarde   |");
            System.out.println("|                ##/##/##/##/##_ATENCION_##/##/##/##/##               |");
            System.out.println("|---------------------------------------------------------------------|");
            return LocalDate.of(6060, 01, 01);


        }

    }

    @Override
    public void mostrarInfoProducto() {
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


    }
}
