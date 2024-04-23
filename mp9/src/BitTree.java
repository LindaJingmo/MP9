import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 * intended to store mappings from bits to values.
 *
 * @author Linda
 */
class BitTree {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int size;
  BitTreeNode root = null;

  // +--------------+------------------------------------------------------------
  // | Constructure |
  // +--------------+

  BitTree(int n) {
    this.size = n;
  } // BitTree()

  // +--------------+------------------------------------------------------------
  // | Main Methods |
  // +--------------+

  void set(String bits, String value) {
    checkBits(bits);
    this.root = setHelper(bits, value, this.root);
  } // set

  String get(String bits) {
    checkBits(bits);
    return getHelper(bits, this.root);
  } // get

  void dump(PrintWriter pen) {
    dumpHelper(pen, this.root);
  } // dump

  void load(InputStream source) throws IOException {
    String[] Bytes;
    Bytes = new String(source.readAllBytes()).split("\n");
    for (String line : Bytes) {
      String[] elements = line.split(",");
      this.set(elements[0], elements[1]);
    } // for
  } // set

  // +----------------+------------------------------------------------------------
  // | Helper Methods |
  // +----------------+
  private void checkBits(String bits) {
      if (bits.length() != this.size) {
          try {
            throw new Exception("Invalid Bits");
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        } // if
      for (int i = 0; i < bits.length(); i++) {
        if (!(bits.charAt(i) == '0' || bits.charAt(i) == '1')) {
          try {
            throw new Exception("Invalid Bits");
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        } // if
      } // for
    } //checkBits 

  private BitTreeNode setHelper(String bits, String value, BitTreeNode node) {
    if (bits.isEmpty()) {
      return new BitTreeLeaf(bits, value);
    } else {
      if (node == null) {
        node = new BitTreeNode(bits);
      } // if
      if (bits.charAt(0) == '0') {
        node.left = setHelper(bits.substring(1), value, node.left);
      } else {
        node.right = setHelper(bits.substring(1), value, node.right);
      } // if
    } // if
    return node;
  } // setHelper
  
  private String getHelper(String bits, BitTreeNode node) {
    if (node == null) {
      return "No value found";
    } else if (node.isLeaf() && bits.isEmpty()) {
      return ((BitTreeLeaf) node).value;
    } else {
      if (bits.charAt(0) == '0') {
        return getHelper(bits.substring(1), node.left);
      } else {
        return getHelper(bits.substring(1), node.right);
      } // if
    } // if
  } // getHelper

  private void dumpHelper(PrintWriter pen, BitTreeNode node) {
    if (node == null) {
      return;
    } // if
    if (node.isLeaf()) {
      pen.println(node.bits + "," + ((BitTreeLeaf) node).value);
    } else {
      dumpHelper(pen, node.left);
      dumpHelper(pen, node.right);
    } // if
  } // dumpHelper
} // class BitTree