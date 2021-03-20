package listaordinal;

public class PruebasLista {
    public static void main(String[] args) {

        ListaOrdinal lista = new ListaOrdinal();

        Producto mesaEscritorio = new Producto("Mesa de Escritorio", 185, 2);
        Producto sillaOficina = new Producto("Silla de Oficina", 95.9f, 3);
        Producto mesaCocina = new Producto("Mesa de Cocina", 125, 1);
        Producto sillonReclinable = new Producto("Sillon Reclinable", 230, 2);

        lista.insertar(mesaEscritorio);
        lista.insertar(sillaOficina);
        lista.insertar(mesaCocina);
        lista.insertar(sillonReclinable);

        Iterador it = lista.getIterador();

        System.out.println("---------- PRODUCTOS EN LA LISTA -----------");
        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println("Después de borrar las sillas de oficina:");

        lista.borrar(sillaOficina);

        it = lista.getIterador();

        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println();
        System.out.println("---------- Prueba Clase Factura ----------");

        Producto sillaNueva = new Producto("Silla de Oficina", 95.9f, 1);

        Factura factura = new Factura("12345678A", "17/03/2021");

        factura.añadirProducto(mesaEscritorio);
        factura.añadirProducto(sillaOficina);
        factura.añadirProducto(mesaCocina);
        factura.añadirProducto(sillonReclinable);
        factura.añadirProducto(sillaNueva);

        factura.mostrar();

        System.out.println();
        System.out.println("---------- Prueba Metodo EliminarProducto ----------");

        Producto sillaOficina1 = new Producto("Silla de Oficina", 95.9f, 2);
        Producto sillonReclinable1 = new Producto("Sillon Reclinable", 230, 3);

        int eliminacion = factura.eliminarProducto(sillaOficina1) + factura.eliminarProducto(sillonReclinable1);

        System.out.println("Se han eliminado " + eliminacion + " unidades.");
        factura.mostrar();

        System.out.println();
        System.out.println("---------- Prueba Metodo mayoresPrecios ----------");

        System.out.println("Se han obtenido " + factura.mayoresPrecios(100).getNumElementos() + " productos con precio mayor a 100 € por unidad");
        ListaOrdinal mayores = factura.mayoresPrecios(100);

        it = mayores.getIterador();

        while (it.hasNext()){
            it.next().mostrar();
        }
    }
}