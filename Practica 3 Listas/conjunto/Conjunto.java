package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        }
    }


    public int[] toArray() {
        int[] array = new int[this.numElementos];
        Nodo aux = inicio;
        int i = 0;

        while (aux != null) {
            array[i] = aux.getDato();
            aux = aux.getSiguiente();
            i++;
        }

        return array;
    }


    public int mayor() {
        int mayor = 0;
        Nodo aux = inicio;

        while (aux != null) {
            mayor = aux.getDato();
            aux = aux.getSiguiente();
        }

        return mayor;
    }

    public Conjunto subconjunto(int inferior, int superior) {
        Conjunto conjunto = new Conjunto();
        Nodo nodo = inicio;

        while (nodo != null) {
            if (nodo.getDato() >= inferior && nodo.getDato() <= superior) {
                conjunto.insertar(nodo.getDato());
            }
            nodo = nodo.getSiguiente();
        }

        return conjunto;
    }

    public boolean equals(Conjunto conjunto) {
        boolean equals = true;
        Nodo nodo1 = this.inicio, nodo2;
        if (conjunto != null) {
            nodo2 = conjunto.inicio;
            if (this.numElementos == conjunto.getNumElementos()) {
                while (nodo1 != null) {
                    if (nodo1.getDato() != nodo2.getDato()) {
                        equals = false;
                    }
                    nodo1 = nodo1.getSiguiente();
                    nodo2 = nodo2.getSiguiente();
                }
            } else equals = false;
        } else equals = false;

        return equals;
    }


}
