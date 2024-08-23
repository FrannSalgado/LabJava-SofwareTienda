package domain;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    String nombre;
    private int capacidadDeAlmacenamiento;
    private int existencias = 0;
    private float saldoEnCaja;
    public ArrayList<? extends Object> catalogo;

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


        } else {
            System.out.println("No se puede agregar más productos. El stock ha alcanzado su capacidad máxima.");
        }


    }

    public void comprarProducto(Bebida producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;

        } else {
            System.out.println("No se puede agregar más productos. El stock ha alcanzado su capacidad máxima.");
        }


    }

    public void comprarProducto(Envasado producto) {
        if (existencias <= capacidadDeAlmacenamiento && (existencias + producto.sotck) <= capacidadDeAlmacenamiento && saldoEnCaja >= (producto.precio * producto.sotck)) {
            ((ArrayList<Object>) this.catalogo).add(producto);
            this.saldoEnCaja = this.saldoEnCaja - (producto.precio * producto.sotck);
            this.existencias = this.existencias + producto.sotck;


        } else {
            System.out.println("No se puede agregar más productos. El stock ha alcanzado su capacidad máxima.");
        }


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


    }

    public void mostrarSaldoEnCaja() {
        System.out.println("El saldo es: $" + this.saldoEnCaja);
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

    public void generarPedidoDeVenta(String producto, int cantidad) {
        List<List<Integer>> listaPosiciones = new ArrayList<>();
        List<Integer> prodcuto1 = new ArrayList<>();
        for (int i = 0; i < catalogo.size(); i++) {
            Object iterador = catalogo.get(i);

            if (iterador instanceof Producto) {
                if (((Producto) iterador).descripcion.equalsIgnoreCase(producto) && ((Producto) iterador).disponibilidad == true) {
                    prodcuto1.add(i); //posicion en array
                    if (((Producto) iterador).sotck > cantidad) {
                        prodcuto1.add(cantidad); // stock a descontar
                        System.out.println("Pedido Generado .");
                    }
                    if (((Producto) iterador).sotck < cantidad) {
                        prodcuto1.add(((Producto) iterador).sotck); //descontar stock total
                        System.out.println("“Hay productos con stock disponible menor al solicitado.");
                    }
                }
            }
        }

    }


    public List<List<Integer>> generarPedidoDeVenta(String producto1, int cantidad, String producto2, int cantidadp2) {
        List<List<Integer>> listaPosiciones = new ArrayList<>();
        List<Integer> prodcuto1 = new ArrayList<>();
        List<Integer> prodcuto2 = new ArrayList<>();
        listaPosiciones.add(prodcuto1);
        listaPosiciones.add(prodcuto2);//acaaaaaaaaaaaaaaaaaa
        for (int x = 0; x < listaPosiciones.size(); x++) {
            for (int i = 0; i < catalogo.size(); i++) {
                Object iterador = catalogo.get(i);
                if (iterador instanceof Producto) {
                    if (((Producto) iterador).descripcion.equalsIgnoreCase(producto) && ((Producto) iterador).disponibilidad == true) {
                        listaPosiciones.get(x).add(i); //posicion en array
                        if (((Producto) iterador).sotck > cantidad) {
                            listaPosiciones.get(x).add(cantidad); // stock a descontar
                            System.out.println("Pedido Generado .");
                            System.out.println(listaPosiciones);
                            continue;


                        }
                        if (((Producto) iterador).sotck < cantidad) {
                            listaPosiciones.get(x).add(((Producto) iterador).sotck); //descontar stock total
                            System.out.println("“Hay productos con stock disponible menor al solicitado.");
                        }
                    }
                }
            }
        }
        return listaPosiciones;

    }

    public void realizarVenta(List<List<Integer>> posiciones) {
        for (int x = 0; x < posiciones.size(); x++) { //lsiatapadre
            int posisionProducto = -1;
            int stockADescontar = 0;

            for (int i = 0; i < posiciones.get(x).size(); i++) { // sublista
                if (i == 0) {
                    posisionProducto = posiciones.get(x).get(i); // Primer valor en poscisionProducto
                } else if (i == 1) {
                    stockADescontar = posiciones.get(x).get(i); // Segundo valor en stockADescontar
                }
                actualizarCatalogo(posisionProducto, stockADescontar);

            }

        }
    }

    public void actualizarCatalogo(int posicion, int stock) {
        Producto producto = (Producto) catalogo.get(posicion);
        producto.descontarStock(stock);





    }

    ;


}

