package javacc.asint;

import java.io.FileReader;

import manual.asint.AnalizadorSintacticoTiny;

public class Main {
	public static void main(String[] args) throws Exception {
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(
				new FileReader(args.length == 0 ? "input.txt" : args[0]));
		asint.Sp();
	}
}