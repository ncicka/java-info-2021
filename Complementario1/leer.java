
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class leer {
    public static void main(String[] args) {
        

        Scanner n = new Scanner(System.in,StandardCharsets.US_ASCII);
        String teclado = n.nextLine();
        System.out.println(teclado);
        System.out.println(Charset.defaultCharset().displayName());
        System.out.println(StandardCharsets.ISO_8859_1);
        n.close();
    }
    
}
