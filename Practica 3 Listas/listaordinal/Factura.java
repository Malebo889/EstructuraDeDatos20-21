package listaordinal;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        Iterador it = listaProductos.getIterador();
        Producto aux;
        if (listaProductos.contiene(producto)) {
            while (it.hasNext()) {
                aux = it.next();
                if (aux.equals(producto)) {
                    aux.setUnidades(aux.getUnidades() + producto.getUnidades());
                }
            }
        } else {
            listaProductos.insertar(producto);
        }
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + getDNI() + ". Fecha: " + getFecha());
        if (listaProductos.vacia()) {
            System.out.println("Lista vacía");
        } else {
            Iterador it = listaProductos.getIterador();
            while (it.hasNext()) {
                it.next().mostrar();
            }
        }
        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        float importeTotal = 0;
        Producto producto;

        Iterador it = listaProductos.getIterador();

        while (it.hasNext()) {
            producto = it.next();
            importeTotal += producto.getPrecio() * producto.getUnidades();
        }
        return importeTotal;
    }

    public int eliminarProducto(Producto producto) {
        int resul = 0;
        Producto aux;
        Iterador it = listaProductos.getIterador();
        if (listaProductos.contiene(producto)){
            while (it.hasNext()){
                aux = it.next();
                if (aux.equals(producto) && aux.getUnidades() > producto.getUnidades()){
                    resul = aux.getUnidades() - producto.getUnidades();
                    aux.setUnidades(resul);
                } else if (aux.equals(producto) && aux.getUnidades() <= producto.getUnidades()){
                    listaProductos.borrar(producto);
                }
            }
        }

        return resul;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal mayor = new ListaOrdinal();
        Producto producto;
        Iterador it = listaProductos.getIterador();

        while (it.hasNext()){
            producto = it.next();
            if (producto.getPrecio() > precio){
                mayor.insertar(producto);
            }
        }

        return mayor;
    }
}
