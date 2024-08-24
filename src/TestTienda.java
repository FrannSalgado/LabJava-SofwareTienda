import domain.*;

//Es la primera vez q trabajo con java y objetos, si reconozco haber hecho codigo engorroso, en algunos lados , q se pueden optimizar , en algunos lados
// los hice de una forma y luego trabaje una estructura igual de una manera mas simple, iba aprendiendo en el camino. y no di tiempo a cambiar todo a la manera optima disculpas
//espero cumplir con los requerimientos pedidos, y q los test que deje prediseñados cubran todas o la mayoria de las areas.

public class TestTienda {
    public static void main(String[] args) {


        //se debera borrar uno a uno cada producto para ver los errores
        //testIntanciarProductosInvalidos();

        //testComparProductoSinDineroEnCaja();
        //testComparProductoSinStockDisponible();
        //testVenderProductos();
        //testVenderProductosStockLimitado();
        //testVenderProductosDeMas();
        //testVenderNoDisponibles();
    }

    public static void testIntanciarProductosInvalidos() {
        try {
            //producto fuera de fecha
            EnvasadoComestible atun = new EnvasadoComestible("atun", 20, 22.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2020, 42, 12), 320, 16);

            //producto descuento fuera termino
            EnvasadoComestible milanesa = new EnvasadoComestible("Milanesas", 20, 22.5f, 20, true, "Bandeja", true, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2020, 1, 12), 320, 100);

            //producto exceso de ganancia
            Envasado tierraJardineria = new Envasado("tierra Jardineria", 20, 22.5f, 10, true, "lata", true, 10);

            //producto graduacion alcoholica fuera de termino
            Bebida vino = new Bebida("Vino", 2, 50, 10, true, -1, true, 20, 10);

            //producto Calorias fuera de menores a 0
            Bebida cocaZero = new Bebida("Coca Zero", 2, 50, 10, true, 0, true, -1, 10);

            //producto tipo de aplicacion erronea
            Limpieza alaLiquido = new Limpieza("Ala Liquido", 10, 10, 14, true, "cocinna", true, 10);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void testComparProductoSinDineroEnCaja(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 300, 100);
        EnvasadoComestible productoCaro = new EnvasadoComestible("atun", 1, 222.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);

        tiendaDonPepe.comprarProducto(productoCaro);

    }

    public static void testComparProductoSinStockDisponible(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 100, 10000);
        EnvasadoComestible productoExceso = new EnvasadoComestible("atun", 150, 22.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);

        tiendaDonPepe.comprarProducto(productoExceso);

    }

    public static void testVenderProductos(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 3000, 100000);
        EnvasadoComestible atun = new EnvasadoComestible("atun", 100, 222.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);
        Envasado tierraJardineria = new Envasado("tierra Jardineria", 200, 22.5f, 10, true, "lata", true, 10);
        Bebida vino = new Bebida("Vino", 200, 50, 10, true, 10, true, 20, 10);
        Bebida cocaZero = new Bebida("Coca Zero", 200, 50, 10, true, 0, true, 10, 10);
        Limpieza alaLiquido = new Limpieza("Ala Liquido", 100, 10, 14, true, "cocina", true, 10);

        tiendaDonPepe.comprarProducto(atun);
        tiendaDonPepe.comprarProducto(tierraJardineria);
        tiendaDonPepe.comprarProducto(vino);
        tiendaDonPepe.comprarProducto(cocaZero);
        tiendaDonPepe.comprarProducto(alaLiquido);
        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

        System.out.println("---------------------Vender 3 Prodcutos en conjunto-----------------------");
        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("atun" ,1, "tierra jardineria", 2, "Vino",5 ));
        System.out.println("---------------------------------#----------------------------------------");
        System.out.println("---------------------Vender 2 Prodcutos en conjunto-----------------------");

        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("tierra jardineria" , 3, "Vino",2));
        System.out.println("---------------------------------#----------------------------------------");
        System.out.println("---------------------Vender 1 Prodcutos -------------------------");

        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("tierra jardineria" , 3));
        System.out.println("---------------------------------#----------------------------------------");
        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

    }

    public static void testVenderProductosStockLimitado(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 3000, 100000);
        EnvasadoComestible atun = new EnvasadoComestible("atun", 10, 222.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);
        Envasado tierraJardineria = new Envasado("tierra Jardineria", 200, 22.5f, 10, true, "lata", true, 10);
        Bebida vino = new Bebida("Vino", 12, 50, 10, true, 10, true, 20, 10);



        tiendaDonPepe.comprarProducto(atun);
        tiendaDonPepe.comprarProducto(tierraJardineria);
        tiendaDonPepe.comprarProducto(vino);
        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

        System.out.println("---------------------Vender 3 Prodcutos en conjunto-----------------------");
        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("atun" ,11, "tierra jardineria", 7, "Vino",11 ));
        System.out.println("---------------------------------#----------------------------------------");


        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

    }
    public static void testVenderProductosDeMas(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 3000, 100000);
        EnvasadoComestible atun = new EnvasadoComestible("atun", 10, 222.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);
        Envasado tierraJardineria = new Envasado("tierra Jardineria", 200, 22.5f, 10, true, "lata", true, 10);
        Bebida vino = new Bebida("Vino", 12, 50, 10, true, 10, true, 20, 10);



        tiendaDonPepe.comprarProducto(atun);
        tiendaDonPepe.comprarProducto(tierraJardineria);
        tiendaDonPepe.comprarProducto(vino);
        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

        System.out.println("---------------------Vender 3 Prodcutos en conjunto-----------------------");
        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("atun" ,12, "tierra jardineria", 13, "Vino",11 ));
        System.out.println("---------------------------------#----------------------------------------");


        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

    }
    public static void testVenderNoDisponibles(){
        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 3000, 100000);
        EnvasadoComestible atun = new EnvasadoComestible("atun", 10, 222.5f, 10, true, "lata", false, EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2025, 1, 12), 320, 10);

        tiendaDonPepe.comprarProducto(atun);
        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

        System.out.println("---------------------Vender 1 Prodcutos -----------------------");
        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("atun" ,10 ));
        System.out.println("---------------------------------#----------------------------------------");
        tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("atun" ,10 ));


        tiendaDonPepe.mostrarSaldoEnCaja();
        tiendaDonPepe.mostrarExistencias();

    }


}