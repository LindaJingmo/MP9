import java.io.PrintWriter;
/**
 * Taking command line
 *
 * @author Linda
 */
class BrailleASCII {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Invalid Input Length");
    } // if
    BrailleASCIITables BAtable = new BrailleASCIITables();
    PrintWriter pen = new PrintWriter(System.out, true);
    switch (args[0].toLowerCase()) {
      case "braille" -> {
        for (char c : args[1].toCharArray()) {
          pen.print(BAtable.toBraille(c));
        } // for
        pen.println();
      } // case
      case "ascii" -> {
        for (int i = 0; i < args[1].length(); i += 6) {
          pen.print(BAtable.toASCII(args[1].substring(i, i + 6)));
        } // for
        pen.println();
      } // case
      case "unicode" -> {
        for (int i = 0; i < args[1].length() - 6; i += 6) {
          int codePoint = Integer.parseInt(BAtable.toUnicode(args[1].substring(i, i + 6)), 16);
          pen.print(Character.toString(codePoint));
        } // for
        pen.println();
      } // case
      default -> System.out.println("Invalid Input");
    } // switch
    pen.close();
  } // main()

} // class BrailleASCII