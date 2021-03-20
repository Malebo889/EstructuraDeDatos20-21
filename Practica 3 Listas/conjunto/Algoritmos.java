package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto conjuntoResul = new Conjunto();
        int[] array;
        if (conjunto1 != null && conjunto2 != null) {
            if (conjunto1.getNumElementos() > conjunto2.getNumElementos()) {
                array = conjunto2.toArray();
                for (int i : array) {
                    if (conjunto1.contiene(i)) {
                        conjuntoResul.insertar(i);
                    }
                }
            } else if (conjunto1.getNumElementos() <= conjunto2.getNumElementos()) {
                array = conjunto1.toArray();
                for (int i : array) {
                    if (conjunto2.contiene(i)) {
                        conjuntoResul.insertar(i);
                    }
                }
            }
        }
        return conjuntoResul;
    }
}
