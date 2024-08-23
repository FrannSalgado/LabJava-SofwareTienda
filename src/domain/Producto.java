package domain;

public abstract class Producto {
   protected String descripcion;
   protected String identificadorAlfNum;
   protected int sotck;
   protected float precio;
   protected float gananciaPorcentual;
   protected boolean disponibilidad;


   public Producto(String identificadorAlfNum, String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad) {
      if (identificadorAlfNum.length() != 5){
         throw new IllegalArgumentException("El identificador debe tener 5 caracteres.");
      }
      this.descripcion=descripcion;
      this.identificadorAlfNum=identificadorAlfNum;
      this.sotck=stock;
      this.precio=precio;
      this.gananciaPorcentual=ganaciaPorcentual;
      this.disponibilidad=disponibilidad;

   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public String getIdentificadorAlfNum() {
      return identificadorAlfNum;
   }

   public void setIdentificadorAlfNum(String identificadorAlfNum) {
      if (identificadorAlfNum.length() == 5) {
         this.identificadorAlfNum = identificadorAlfNum;
      } else {
         throw new IllegalArgumentException("El identificador debe tener 5 caracteres.");
      }
   }

   public int getSotck() {
      return sotck;
   }

   public void setSotck(int sotck) {
      this.sotck = sotck;
   }

   public float getPrecio() {
      return precio;
   }

   public void setPrecio(float precio) {
      this.precio = precio;
   }

   public float getGanaciaPorcentual() {
      return gananciaPorcentual;
   }

   public void setGanaciaPorcentual(float ganaciaPorcentual) {
      this.gananciaPorcentual = ganaciaPorcentual;
   }

   public boolean isDisponibilidad() {
      return disponibilidad;
   }

   public void setDisponibilidad(boolean disponibilidad) {
      this.disponibilidad = disponibilidad;
   }
   public float calcularPrecioVenta() {
      return precio + (precio * gananciaPorcentual / 100);
   }

   protected static String generarCodigo(String codigoAlfaUnico, int contadorProducto) {
      contadorProducto++;
      return String.format(codigoAlfaUnico + "%03d", contadorProducto);
   }
   public void descontarStock(int sotckADescontar){
      this.sotck = getSotck() - sotckADescontar ;
   }
   public float generarTicket(int cantidadVendida){
      System.out.println(identificadorAlfNum + " " + descripcion.toUpperCase() + " " + cantidadVendida + " x "+ calcularPrecioVenta() ) ;
      return cantidadVendida * calcularPrecioVenta();
   }
   public void mostrarInfoProducto(){
      System.out.println("ID: " + identificadorAlfNum);
      System.out.println("Descripción: " + descripcion );
      System.out.println("Cantidad en stock: " + sotck);
      System.out.println("Precio por unidad: $" + precio);
      System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
      System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
      System.out.println("Precio de venta: $" + calcularPrecioVenta());


   }

}


