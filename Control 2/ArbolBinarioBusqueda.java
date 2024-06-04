class ArbolBinarioBusqueda {
  Nodo raiz;

  // Constructor
  public ArbolBinarioBusqueda() {
    raiz = null;
  }

  // Método para agregar un nodo
  void agregar(int valor) {
    raiz = agregarRec(raiz, valor);
  }

  Nodo agregarRec(Nodo raiz, int valor) {
    if (raiz == null) {
      raiz = new Nodo(valor);
      return raiz;
    }

    if (valor < raiz.valor)
      raiz.izquierdo = agregarRec(raiz.izquierdo, valor);
    else if (valor > raiz.valor)
      raiz.derecho = agregarRec(raiz.derecho, valor);

    return raiz;
  }

  // Método para eliminar un nodo
  void eliminar(int valor) {
    raiz = eliminarRec(raiz, valor);
  }

  Nodo eliminarRec(Nodo raiz, int valor) {
    if (raiz == null)
      return raiz;

    if (valor < raiz.valor)
      raiz.izquierdo = eliminarRec(raiz.izquierdo, valor);
    else if (valor > raiz.valor)
      raiz.derecho = eliminarRec(raiz.derecho, valor);
    else {
      if (raiz.izquierdo == null)
        return raiz.derecho;
      else if (raiz.derecho == null)
        return raiz.izquierdo;

      raiz.valor = valorMinimo(raiz.derecho);
      raiz.derecho = eliminarRec(raiz.derecho, raiz.valor);
    }

    return raiz;
  }

  int valorMinimo(Nodo raiz) {
    int minValor = raiz.valor;
    while (raiz.izquierdo != null) {
      minValor = raiz.izquierdo.valor;
      raiz = raiz.izquierdo;
    }
    return minValor;
  }

  // Método para mostrar el árbol en preorden
  void preorden() {
    preordenRec(raiz);
  }

  void preordenRec(Nodo raiz) {
    if (raiz != null) {
      System.out.print(raiz.valor + " ");
      preordenRec(raiz.izquierdo);
      preordenRec(raiz.derecho);
    }
  }
}
