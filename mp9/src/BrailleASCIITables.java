import java.io.FileInputStream;
/**
 *  store the translation information 
 *
 * @author Linda
 */
public class BrailleASCIITables {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  BitTree ASCIIToBraille = new BitTree(8);
  BitTree BrailleToASCII = new BitTree(6);
  BitTree BrailleToUnicode = new BitTree(6);

  // +--------------+------------------------------------------------------------
  // | Constructure |
  // +--------------+

  BrailleASCIITables() throws Exception {
    FileInputStream ASCIIToBrailleFile = new FileInputStream("ASCIIToBraille.txt");
    FileInputStream BrailleToASCIIFile = new FileInputStream("BrailleToASCII.txt");
    FileInputStream BrailleToUnicodeFile = new FileInputStream("BrailleToUnicode.txt");
    ASCIIToBraille.load(ASCIIToBrailleFile);
    BrailleToASCII.load(BrailleToASCIIFile);
    BrailleToUnicode.load(BrailleToUnicodeFile);
  } // BrailleASCIITables

  // +--------------+------------------------------------------------------------
  // | Main Methods |
  // +--------------+

  String toBraille(char letter) {
    String bits = Integer.toString(letter, 2);
    bits = "0".repeat(8 - bits.length()) + bits;
    return ASCIIToBraille.get(bits);
  } // toBraille()

  String toASCII(String bits) {
    return BrailleToASCII.get(bits);
  } // toASCII()

  String toUnicode(String bits) {
    return BrailleToUnicode.get(bits);
  } // toUnicode()

} // class BrailleASCIITables