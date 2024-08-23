import domain.*;



public class TestTienda {
    public static void main(String[] args) {


        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 300, 30000);
        EnvasadoComestible atun = new EnvasadoComestible( "atun",20, 22.5f,100, true, "lata", true,EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2020,4,12), 320 );
        Envasado tierraJardineria = new Envasado( "tierra Jardineria",20, 22.5f,100, true, "lata", true );
        Bebida cocaZero = new Bebida("coca Zero", 2, 50, 100, true, 27, true);
        Limpieza alaLiquido = new Limpieza("Ala Liquido", 10, 10, 100, true, "cocina");


        tiendaDonPepe.comprarProducto(cocaZero);
        tiendaDonPepe.comprarProducto(tierraJardineria);
       // System.out.println(tiendaDonPepe.getSaldoEnCaja());
        tiendaDonPepe.comprarProducto(alaLiquido);
        tiendaDonPepe.comprarProducto(atun);

        System.out.println("--------------------------------------------------------");
        tiendaDonPepe.mostrarTodoElCatalogo();
        //tiendaDonPepe.mostrarTodoElCatalogo();
        tiendaDonPepe.realizarVenta( tiendaDonPepe.generarPedidoDeVenta("coca Zero", 1, "ALA liquido", 4, "Tierra JARDINERIA", 2 ));
        System.out.println("--------------------------------------------------------");
        tiendaDonPepe.mostrarTodoElCatalogo();

    }

}