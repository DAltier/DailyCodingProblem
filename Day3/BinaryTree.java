import java.util.StringJoiner;

/** Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
  def __init__(self, val, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left' */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x;}
}

class BinaryTree {
  TreeNode root;

  /** Encodes a tree to a single string */
  public static void serializeRec(TreeNode root, StringJoiner sj) {
    if (root == null) {
      sj.add("null");
    } else {
      sj.add(Integer.toString(root.val));
      serializeRec(root.left, sj);
      serializeRec(root.right, sj);
    }
  }
  
  public static String serialize(TreeNode root) {
    StringJoiner sj = new StringJoiner(",");
    serializeRec(root, sj);
    return sj.toString();
  }

  /** Decodes the encoded data to a tree */
  public static int idx;
  public static TreeNode deserializeRec(String elements[]) {
    if (elements[idx].equals("null")) {
      idx++;
      return null;
    } else {
      TreeNode current = new TreeNode(Integer.parseInt(elements[idx]));
      idx++;
      current.left = deserializeRec(elements);
      current.right = deserializeRec(elements);
      return current;
    }
  }

  public static TreeNode deserialize(String data) {
    String elements[] = data.split(",");
    idx = 0;
    return deserializeRec(elements);
  }

  /** Inorder traversal used for testing the constructed tree */
  static void inorder(TreeNode root)
  {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.val + " ");
      inorder(root.right);
    }
  }

  /** Driver program to test functionality */
  public static void main(String args[])
  {

    /** Create binary search tree */
    BinaryTree tree = new BinaryTree();
    tree.root = new TreeNode(20);
    tree.root.left = new TreeNode(8);
    tree.root.right = new TreeNode(22);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(12);
    tree.root.left.right.left = new TreeNode(10);
    tree.root.left.right.right = new TreeNode(14);

    /** Serialize binary search tree */
    String serialized = serialize(tree.root);
    System.out.println("Serialized view of the tree:");
    System.out.println(serialized);
    System.out.println();

    /** Deserialize string into binary search tree */
    TreeNode t = deserialize(serialized);

    /** Print tree in order */
    System.out.println("Inorder Traversal of the tree constructed from serialized String:");
    inorder(t);
  }
}