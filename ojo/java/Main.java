// Clase nodo para la creacion de los nodos del arbol
class Nodo {
  int dato;
  Nodo izquierda;
  Nodo derecha;

  Nodo(int item) {
    dato = item;
    izquierda = derecha = null; // se anula si son iguales
  }
}

class Indice {
  int indice = 0; // se inicializa en 0 para el arbol
}

// Se crea la clase para determinar el arbol binario
class ArbolBinario {
  Indice indice = new Indice();

  Nodo construirArbol(int in[], int pre[], int inInicio, int inFin) {
    if (inInicio > inFin)
      return null;

    Nodo tNodo = new Nodo(pre[indice.indice++]);

    if (inInicio == inFin)
      return tNodo;

    int inIndice = buscar(in, inInicio, inFin, tNodo.dato);

    tNodo.izquierda = construirArbol(in, pre, inInicio, inIndice - 1);
    tNodo.derecha = construirArbol(in, pre, inIndice + 1, inFin);

    return tNodo;
  }

  int buscar(int arr[], int inicio, int fin, int valor) {
    int i;
    for (i = inicio; i <= fin; i++) {
      if (arr[i] == valor)
        return i;
    }
    return i;
  }

  void imprimirInorden(Nodo nodo) {
    if (nodo == null)
      return;

    imprimirInorden(nodo.izquierda);
    System.out.print(nodo.dato + " ");
    imprimirInorden(nodo.derecha);
  }
}

// Clase principal para la creacion dela rbol
public class Main {
  public static void main(String args[]) {
    ArbolBinario arbol = new ArbolBinario();
    int in[] = new int[] { 1, 2, 3, 4, 5, 6 };
    int pre[] = new int[] { 4, 2, 1, 3, 6, 5 };
    int len = in.length;
    Nodo raiz = arbol.construirArbol(in, pre, 0, len - 1);

    System.out.println("El arbol queda: ");
    arbol.imprimirInorden(raiz);
  }
}