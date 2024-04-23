/**
 * Construct Bit Tree Node
 * @author Linda
 */
class BitTreeNode {
  String bits;
  BitTreeNode left;
  BitTreeNode right;

  // +--------------+------------------------------------------------------------
  // | Constructure |
  // +--------------+
  BitTreeNode(String bits) {
    this.bits = bits;
  } // BitTreeNode

// Method
  boolean isLeaf() {
    return false;
  } // isLeaf

} // class BitTreeNode