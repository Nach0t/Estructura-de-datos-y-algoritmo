class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

class Index {
  int index = 0;
}

class BinaryTree {
  Index index = new Index();

  Node buildTree(int in[], int pre[], int inStrt, int inEnd) {
    if (inStrt > inEnd)
      return null;

    Node tNode = new Node(pre[index.index++]);

    if (inStrt == inEnd)
      return tNode;

    int inIndex = search(in, inStrt, inEnd, tNode.data);

    tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
    tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

    return tNode;
  }

  int search(int arr[], int strt, int end, int value) {
    int i;
    for (i = strt; i <= end; i++) {
      if (arr[i] == value)
        return i;
    }
    return i;
  }

  void printInorder(Node node) {
    if (node == null)
      return;

    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }
}

public class Main {
  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();
    int in[] = new int[] { 1, 2, 3, 4, 5, 6 };
    int pre[] = new int[] { 4, 2, 1, 3, 6, 5 };
    int len = in.length;
    Node root = tree.buildTree(in, pre, 0, len - 1);

    System.out.println("Inorder traversal of constructed tree is : ");
    tree.printInorder(root);
  }
}