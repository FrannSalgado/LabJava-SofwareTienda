import domain.*;



public class TestTienda {
    public static void main(String[] args) {


        Tienda tiendaDonPepe = new Tienda("Tienda Don Pepe", 300, 30000);
        EnvasadoComestible atun = new EnvasadoComestible( "atun",20, 22.5f,10, true, "lata", true,EnvasadoComestible.fechaVencimientoYYYY_MM_DD(2020,4,12), 320 ,10);
        Envasado tierraJardineria = new Envasado( "tierra Jardineria",20, 22.5f,10, true, "lata", true , 10);
        Bebida cocaZero = new Bebida("coca Zero", 2, 50, 10, true, 0, true , 20, 10);
        Limpieza alaLiquido = new Limpieza("Ala Liquido", 10, 10, 14, true, "cocina", true,10);


        tiendaDonPepe.comprarProducto(cocaZero);
        tiendaDonPepe.comprarProducto(tierraJardineria);
       //
        tiendaDonPepe.comprarProducto(alaLiquido);
        tiendaDonPepe.comprarProducto(atun);
        System.out.println("--------------------------------------------------------");
        tiendaDonPepe.realizarVenta( tiendaDonPepe.generarPedidoDeVenta("coca Zero", 2, "ALA liquido", 1, "tierra Jardineria", 1 ));
        System.out.println("--------------------------------------------------------");
        //tiendaDonPepe.realizarVenta(tiendaDonPepe.generarPedidoDeVenta("coca zero", 1));
        tiendaDonPepe.mostrarTodoElCatalogo();

    }

}