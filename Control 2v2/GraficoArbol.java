
// Segun GPT
import javax.swing.*;
import java.awt.*;

class GraficoArbol extends JPanel {
  private ArbolBinarioBusqueda arbol;

  public GraficoArbol(ArbolBinarioBusqueda arbol) {
    this.arbol = arbol;
    this.setBackground(Color.BLACK); // Establecer el fondo negro

  }

  // Dibuja un nodo en la posición (x, y) con un desplazamiento horizontal xOffset
  private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int xOffset) {
    if (nodo == null)
      return;

    // Colores
    g.setColor(Color.green); // Color de los nodos
    g.fillOval(x, y, 30, 30); // Dibujar el nodo
    g.setColor(Color.black); // Color del texto en los nodos
    g.drawString(Integer.toString(nodo.valor), x + 10, y + 20);
    g.setColor(Color.white); // Color de las líneas

    if (nodo.izquierdo != null)
      g.drawLine(x + 15, y + 30, x - xOffset + 15, y + 60); // Línea al hijo izquierdo
    if (nodo.derecho != null)
      g.drawLine(x + 15, y + 30, x + xOffset + 15, y + 60); // Línea al hijo derecho

    // Llamadas recursivas para dibujar los hijos
    dibujarNodo(g, nodo.izquierdo, x - xOffset, y + 60, xOffset / 2);
    dibujarNodo(g, nodo.derecho, x + xOffset, y + 60, xOffset / 2);
  }

  // Override el método paintComponent para dibujar el árbol
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dibujarNodo(g, arbol.raiz, getWidth() / 2, 30, getWidth() / 4);
  }

  public void actualizar() {
    repaint();
  }
}