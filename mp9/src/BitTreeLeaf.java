
class BitTreeLeaf extends BitTreeNode {
  String value;

  // +--------------+------------------------------------------------------------
  // | Constructure |
  // +--------------+
  BitTreeLeaf(String bits, String value) {
    super(bits);
    this.value = value;
  } // BitTreeNode

//override method
  @Override
  boolean isLeaf() {
    return true;
  } // isLeaf()

} // class BitTreeNode