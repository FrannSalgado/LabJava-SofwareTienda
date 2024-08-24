package domain;

import java.util.ArrayList;
import java.util.List;


public class Tienda {
    String nombre;
    private int capacidadDeAlmacenamiento;
    private int existencias = 0;
    private float saldoEnCaja;
    private ArrayList<? extends Object> catalogo;

    public Tienda(String nombre, int capacidadDeAlmacenamiento, float saldoEnCaja) {
        this.nombre = nombre;
        this.capacidadDeAlmacenamiento = capacidadDeAlmacenamiento;
        this.saldoEnCaja = saldoEnCaja;
        this.catalogo = new ArrayList<>();
    }


    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadDeAlmacenamiento() {
        return capacidadDeAlmacenamiento;
    }

    public void setCapacidadDeAlmacenamiento(int capacidadDeAlmacenamiento) {
        this.capacidadDeAlmacenamiento = capacidadDeAlmacenamiento;
    }

    public float getSaldoEnCaja() {
        return saldoEnCaja;
    }

    public ArrayList<? extends Object> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<? extends Object> catalogo) {
        this.catalogo = catalogo;
    }

    public void setSaldoEnCaja(float saldoEnCaja) {
        this.saldoEnCaja = saldoEnCaja;
    }

    public void comprarProducto(EnvasadoComestible producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;
        } else if (saldoEnCaja < (producto.precio * producto.sotck)) {
            System.out.println("El producto no podra ser agregado a la tienda por saldo insuficiente en la caja.");
        } else if (producto.sotck + existencias > capacidadDeAlmacenamiento) {
            System.out.println("Agregar estos productos sobrepasaria la capaciadad maxima, Espacio Disponible (" + (capacidadDeAlmacenamiento - existencias) + ").");
        } else {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzo el maximo de stock.");
        }
        producto.mostrarInfoProducto();

    }

    public void comprarProducto(Bebida producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;
        } else if (saldoEnCaja < (producto.precio * producto.sotck)) {
            System.out.println("El producto no podra ser agregado a la tienda por saldo insuficiente en la caja.");


        } else if (producto.sotck + existencias > capacidadDeAlmacenamiento) {
            System.out.println("Agregar estos productos sobrepasaria la capaciadad maxima, Espacio Disponible (" + (capacidadDeAlmacenamiento - existencias) + ").");

        } else {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzo el maximo de stock.");
        }
        producto.mostrarInfoProducto();


    }

    public void comprarProducto(Envasado producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;
        } else if (saldoEnCaja < (producto.precio * producto.sotck)) {
            System.out.println("El producto no podra ser agregado a la tienda por saldo insuficiente en la caja.");


        } else if (producto.sotck + existencias > capacidadDeAlmacenamiento) {
            System.out.println("Agregar estos productos sobrepasaria la capaciadad maxima, Espacio Disponible (" + (capacidadDeAlmacenamiento - existencias) + ").");

        } else {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzo el maximo de stock.");
        }
        producto.mostrarInfoProducto();

    }

    public void comprarProducto(Limpieza producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;
        } else if (saldoEnCaja < (producto.precio * producto.sotck)) {
            System.out.println("El producto no podra ser agregado a la tienda por saldo insuficiente en la caja.");


        } else if (producto.sotck + existencias > capacidadDeAlmacenamiento) {
            System.out.println("Agregar estos productos sobrepasaria la capaciadad maxima, Espacio Disponible (" + (capacidadDeAlmacenamiento - existencias) + ").");

        } else {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzo el maximo de stock.");
        }

        producto.mostrarInfoProducto();
    }


    public void mostrarSaldoEnCaja() {
        System.out.println(String.format("El saldo es: $%.2f", this.saldoEnCaja));
    }

    public void mostrarExistencias() {
        System.out.println("Existencias : (" + this.existencias + "/" + capacidadDeAlmacenamiento + ")");
    }


    public void mostrarTodoElCatalogo() {

        for (int i = 0;
             i < this.catalogo.size();
             i++) {
            Object producto = catalogo.get(i);

            if (producto instanceof Producto) {
                ((Producto) producto).mostrarInfoProducto();
            }


        }
    }

    public List<List<Integer>> generarPedidoDeVenta(String producto1, int cantidad1) {
        if (cantidad1 < 1) {
            System.out.println("No puedes vender menos de 1 producto");
            return null;
        }
        List<List<Integer>> listaPosiciones = new ArrayList<>();
        List<Integer> datosProducto1 = new ArrayList<>();
        listaPosiciones.add(datosProducto1);
        if (cantidad1 <= 12) {
            String productoBuscado = "";
            int cantidadProductoBuscado = -1;
            for (int x = 0; x < listaPosiciones.size(); x++) {
                for (int i = 0; i < catalogo.size(); i++) {
                    Object iterador = catalogo.get(i);
                    if (iterador instanceof Producto) {
                        if (x == 0) {
                            productoBuscado = producto1;
                            cantidadProductoBuscado = cantidad1;
                        }
                        if (((Producto) iterador).descripcion.equalsIgnoreCase(productoBuscado) && ((Producto) iterador).disponibilidad == true) {
                            listaPosiciones.get(x).add(i); //posicion en array
                            if (((Producto) iterador).sotck >= cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(cantidadProductoBuscado); // stock a descontar
                                System.out.println("Pedido Generado .");
                            }
                            if (((Producto) iterador).sotck < cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(((Producto) iterador).sotck); //descontar stock total
                                System.out.println("“Hay productos con stock disponible menor al solicitado.");
                            }
                        }
                        if (((Producto) iterador).sotck == 0) {
                            System.out.println("El producto " + ((Producto) iterador).identificadorAlfNum + " " + ((Producto) iterador).descripcion + " no se encuentra disponible");
                            return listaPosiciones;
                        }
                    }
                }
            }
        } else {
            System.out.println("No puedes Vender mas de 12 unidades de ningun producto");
        }
        return listaPosiciones;
    }


    public List<List<Integer>> generarPedidoDeVenta(String producto1, int cantidad1, String producto2, int cantidad2) {
        if (cantidad1 < 1 || cantidad2 < 1) {
            System.out.println("No puedes vender menos de 1 producto");
            return null;
        }
        List<List<Integer>> listaPosiciones = new ArrayList<>();
        List<Integer> datosProducto1 = new ArrayList<>();
        List<Integer> datosProducto2 = new ArrayList<>();

        listaPosiciones.add(datosProducto1);
        listaPosiciones.add(datosProducto2);
        if (cantidad1 <= 12 && cantidad2 <= 12) {
            String productoBuscado = "";
            int cantidadProductoBuscado = -1;
            for (int x = 0; x < listaPosiciones.size(); x++) {
                for (int i = 0; i < catalogo.size(); i++) {
                    Object iterador = catalogo.get(i);
                    if (iterador instanceof Producto) {
                        if (x == 0) {
                            productoBuscado = producto1;
                            cantidadProductoBuscado = cantidad1;
                        }
                        if (x == 1) {
                            productoBuscado = producto2;
                            cantidadProductoBuscado = cantidad2;
                        }
                        if (((Producto) iterador).descripcion.equalsIgnoreCase(productoBuscado) && ((Producto) iterador).disponibilidad == true) {
                            listaPosiciones.get(x).add(i); //posicion en array
                            if (((Producto) iterador).sotck >= cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(cantidadProductoBuscado); // stock a descontar
                                System.out.println("Pedido Generado .");
                            }
                            if (((Producto) iterador).sotck < cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(((Producto) iterador).sotck); //descontar stock total
                                System.out.println("“Hay productos con stock disponible menor al solicitado.");
                            }
                        }
                        if (((Producto) iterador).sotck == 0) {
                            System.out.println("El producto " + ((Producto) iterador).identificadorAlfNum + " " + ((Producto) iterador).descripcion + " no se encuentra disponible");
                            return listaPosiciones;
                        }
                    }
                }
            }
            return listaPosiciones;
        } else {
            System.out.println("No puedes Vender mas de 12 unidades de ningun producto");
            return listaPosiciones;
        }
    }

    public List<List<Integer>> generarPedidoDeVenta(String producto1, int cantidad1, String producto2, int cantidad2, String producto3, int cantidad3) {
        if (cantidad1 < 1 || cantidad2 < 1 || cantidad3 < 1) {
            System.out.println("No puedes vender menos de 1 producto");
            return null;
        }

        List<List<Integer>> listaPosiciones = new ArrayList<>();
        List<Integer> datosProducto1 = new ArrayList<>();
        List<Integer> datosProducto2 = new ArrayList<>();
        List<Integer> datosProducto3 = new ArrayList<>();
        listaPosiciones.add(datosProducto1);
        listaPosiciones.add(datosProducto2);
        listaPosiciones.add(datosProducto3);
        if (cantidad1 <= 12 && cantidad2 <= 12 && cantidad3 <= 12) {
            String productoBuscado = "";
            int cantidadProductoBuscado = -1;
            for (int x = 0; x < listaPosiciones.size(); x++) {
                for (int i = 0; i < catalogo.size(); i++) {
                    Object iterador = catalogo.get(i);
                    if (iterador instanceof Producto) {
                        if (x == 0) {
                            productoBuscado = producto1;
                            cantidadProductoBuscado = cantidad1;
                        }
                        if (x == 1) {
                            productoBuscado = producto2;
                            cantidadProductoBuscado = cantidad2;
                        }
                        if (x == 2) {
                            productoBuscado = producto3;
                            cantidadProductoBuscado = cantidad3;
                        }
                        if (((Producto) iterador).descripcion.equalsIgnoreCase(productoBuscado) && ((Producto) iterador).disponibilidad == true) {
                            listaPosiciones.get(x).add(i); //posicion en array
                            if (((Producto) iterador).sotck >= cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(cantidadProductoBuscado); // stock a descontar
                                System.out.println("Pedido Generado .");
                            }
                            if (((Producto) iterador).sotck < cantidadProductoBuscado) {
                                listaPosiciones.get(x).add(((Producto) iterador).sotck); //descontar stock total
                                System.out.println("“Hay productos con stock disponible menor al solicitado.");
                            }
                        }
                        if (((Producto) iterador).sotck == 0) {
                            System.out.println("El producto " + ((Producto) iterador).identificadorAlfNum + " " + ((Producto) iterador).descripcion + " no se encuentra disponible");
                            return listaPosiciones;
                        }
                    }
                }
            }
            return listaPosiciones;
        } else {
            System.out.println("No puedes Vender mas de 12 unidades de ningun producto");
            return listaPosiciones;
        }
    }


    public float generarTicket(List<List<Object>> datosDelTicket, String nombreTienda) {
        float ventaTotal = 0;

        System.out.println("####### " + nombreTienda.toUpperCase() + " #######");
        for (int x = 0; x < datosDelTicket.size(); x++) {
            String detalleProducto = (String) datosDelTicket.get(x).get(0);
            float precioProducto = (float) datosDelTicket.get(x).get(1);

            System.out.println(detalleProducto);

            ventaTotal += precioProducto;
        }
        System.out.println("En caso de Descuento, se aplicaran Automaticamente ");
        System.out.println(String.format("TOTAL VENTA: $%.2f", ventaTotal));
        System.out.println("####### GRACIAS POR SU COMPRA #######");
        return ventaTotal;
    }

    public void realizarVenta(List<List<Integer>> posiciones) {
        try {
            List<List<Object>> datosDeTicket = new ArrayList<>();

            for (int x = 0; x < posiciones.size(); x++) {
                datosDeTicket.add(new ArrayList<>());

                int posicionProducto = posiciones.get(x).get(0);
                int stockADescontar = posiciones.get(x).get(1);

                List<Object> datosProducto = actualizarCatalogo(posicionProducto, stockADescontar);
                datosDeTicket.get(x).add(datosProducto.get(0));
                datosDeTicket.get(x).add(datosProducto.get(1));
            }

            float añadirALaCaja = generarTicket(datosDeTicket, nombre);
            aniadirSaldoDeVenta(añadirALaCaja);
        } catch (Exception e) {

            System.out.println("Error al Procesar Venta (Verifique argumentos)");
        }


    }


    public void aniadirSaldoDeVenta(float gananciaTotal) {
        this.saldoEnCaja = saldoEnCaja + gananciaTotal;
    }

    public List<Object> actualizarCatalogo(int posicion, int stock) {
        List<Object> datosParaElTicket = new ArrayList<>();
        Producto producto = (Producto) catalogo.get(posicion);
        String stringBuilder = producto.identificadorAlfNum + " " + producto.descripcion.toUpperCase() + " " + stock + " x " + String.format("%.2f", producto.calcularPrecioVenta());
        ;
        datosParaElTicket.add(stringBuilder);
        datosParaElTicket.add(producto.calcularPrecioVenta() * stock);

        producto.descontarStock(stock);
        existencias -= (stock);
        producto.mostrarInfoProducto();

        return datosParaElTicket;


    }

    ;

    public void obtenerComestiblesConMenorDescuento(float porcentaje_descuento) {
        StringBuilder listaProductosSolicitada = new StringBuilder();

        for (Object item : catalogo) {

            if (item instanceof EnvasadoComestible) {
                EnvasadoComestible producto = (EnvasadoComestible) item;
                if (producto.descuento < porcentaje_descuento && !producto.esImportado) {
                    listaProductosSolicitada.append(producto.descripcion.toUpperCase()).append(", ");
                }
            }
        }
        if (listaProductosSolicitada.length() > 0) {
            listaProductosSolicitada.setLength(listaProductosSolicitada.length() - 2);
        } else {
            listaProductosSolicitada.append("No se Encontraron productos NO importados con descuento menor a ").append(porcentaje_descuento).append("%");
        }

        System.out.println(listaProductosSolicitada);

    }

    ;


}

