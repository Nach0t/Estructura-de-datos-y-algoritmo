public class ArbolBinarioBusqueda {
  Nodo raiz;

  public ArbolBinarioBusqueda() {
    raiz = null;
  }

  void insertar(int valor) {
    raiz = insertarRecursivo(raiz, valor);
  }

  Nodo insertarRecursivo(Nodo raiz, int valor) {
    if (raiz == null) {
      raiz = new Nodo(valor);
      return raiz;
    }
    if (valor < raiz.valor)
      raiz.izquierdo = insertarRecursivo(raiz.izquierdo, valor);
    else if (valor > raiz.valor)
      raiz.derecho = insertarRecursivo(raiz.derecho, valor);

    return raiz;
  }

  void eliminar(int valor) {
    raiz = eliminarRecursivo(raiz, valor);
  }

  Nodo eliminarRecursivo(Nodo raiz, int valor) {
    if (raiz == null)
      return raiz;

    if (valor < raiz.valor)
      raiz.izquierdo = eliminarRecursivo(raiz.izquierdo, valor);
    else if (valor > raiz.valor)
      raiz.derecho = eliminarRecursivo(raiz.derecho, valor);
    else {
      if (raiz.izquierdo == null)
        return raiz.derecho;
      else if (raiz.derecho == null)
        return raiz.izquierdo;

      raiz.valor = minValue(raiz.derecho);
      raiz.derecho = eliminarRecursivo(raiz.derecho, raiz.valor);
    }

    return raiz;
  }

  int minValue(Nodo raiz) {
    int minv = raiz.valor;
    while (raiz.izquierdo != null) {
      minv = raiz.izquierdo.valor;
      raiz = raiz.izquierdo;
    }
    return minv;
  }

  int maxValue(Nodo raiz) {
    int maxv = raiz.valor;
    while (raiz.derecho != null) {
      maxv = raiz.derecho.valor;
      raiz = raiz.derecho;
    }
    return maxv;
  }

  int altura(Nodo raiz) {
    if (raiz == null)
      return 0;
    return Math.max(altura(raiz.izquierdo), altura(raiz.derecho)) + 1;
  }

  int contarNodos(Nodo raiz) {
    if (raiz == null)
      return 0;
    return 1 + contarNodos(raiz.izquierdo) + contarNodos(raiz.derecho);
  }

  void recorridoInOrder(Nodo raiz) {
    if (raiz != null) {
      recorridoInOrder(raiz.izquierdo);
      System.out.print(raiz.valor + " ");
      recorridoInOrder(raiz.derecho);
    }
  }

  void recorridoPreOrder(Nodo raiz) {
    if (raiz != null) {
      System.out.print(raiz.valor + " ");
      recorridoPreOrder(raiz.izquierdo);
      recorridoPreOrder(raiz.derecho);
    }
  }

  void recorridoPostOrder(Nodo raiz) {
    if (raiz != null) {
      recorridoPostOrder(raiz.izquierdo);
      recorridoPostOrder(raiz.derecho);
      System.out.print(raiz.valor + " ");
    }
  }
}
