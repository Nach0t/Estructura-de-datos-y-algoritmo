public class ArbolAVL extends ArbolBinarioBusqueda {

  Nodo rotacionDerecha(Nodo y) {
    Nodo x = y.izquierdo;
    Nodo T2 = x.derecho;

    x.derecho = y;
    y.izquierdo = T2;

    return x;
  }

  Nodo rotacionIzquierda(Nodo x) {
    Nodo y = x.derecho;
    Nodo T2 = y.izquierdo;

    y.izquierdo = x;
    x.derecho = T2;

    return y;
  }

  int obtenerBalance(Nodo N) {
    if (N == null)
      return 0;
    return altura(N.izquierdo) - altura(N.derecho);
  }

  @Override
  Nodo insertarRecursivo(Nodo nodo, int valor) {
    if (nodo == null)
      return (new Nodo(valor));

    if (valor < nodo.valor)
      nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
    else if (valor > nodo.valor)
      nodo.derecho = insertarRecursivo(nodo.derecho, valor);
    else
      return nodo;

    int balance = obtenerBalance(nodo);

    if (balance > 1 && valor < nodo.izquierdo.valor)
      return rotacionDerecha(nodo);

    if (balance < -1 && valor > nodo.derecho.valor)
      return rotacionIzquierda(nodo);

    if (balance > 1 && valor > nodo.izquierdo.valor) {
      nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
      return rotacionDerecha(nodo);
    }

    if (balance < -1 && valor < nodo.derecho.valor) {
      nodo.derecho = rotacionDerecha(nodo.derecho);
      return rotacionIzquierda(nodo);
    }

    return nodo;
  }

  @Override
  Nodo eliminarRecursivo(Nodo raiz, int valor) {
    if (raiz == null)
      return raiz;

    if (valor < raiz.valor)
      raiz.izquierdo = eliminarRecursivo(raiz.izquierdo, valor);
    else if (valor > raiz.valor)
      raiz.derecho = eliminarRecursivo(raiz.derecho, valor);
    else {
      if ((raiz.izquierdo == null) || (raiz.derecho == null)) {
        Nodo temp = null;
        if (temp == raiz.izquierdo)
          temp = raiz.derecho;
        else
          temp = raiz.izquierdo;

        if (temp == null) {
          temp = raiz;
          raiz = null;
        } else
          raiz = temp;
      } else {
        Nodo temp = minValueNodo(raiz.derecho);
        raiz.valor = temp.valor;
        raiz.derecho = eliminarRecursivo(raiz.derecho, temp.valor);
      }
    }

    if (raiz == null)
      return raiz;

    int balance = obtenerBalance(raiz);

    if (balance > 1 && obtenerBalance(raiz.izquierdo) >= 0)
      return rotacionDerecha(raiz);

    if (balance > 1 && obtenerBalance(raiz.izquierdo) < 0) {
      raiz.izquierdo = rotacionIzquierda(raiz.izquierdo);
      return rotacionDerecha(raiz);
    }

    if (balance < -1 && obtenerBalance(raiz.derecho) <= 0)
      return rotacionIzquierda(raiz);

    if (balance < -1 && obtenerBalance(raiz.derecho) > 0) {
      raiz.derecho = rotacionDerecha(raiz.derecho);
      return rotacionIzquierda(raiz);
    }

    return raiz;
  }

  Nodo minValueNodo(Nodo nodo) {
    Nodo current = nodo;
    while (current.izquierdo != null)
      current = current.izquierdo;

    return current;
  }
}
