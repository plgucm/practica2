package manual.asint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(input);
     asint.Sp();
 }
}   
   
