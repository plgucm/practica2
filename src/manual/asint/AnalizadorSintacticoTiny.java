/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manual.asint;

import java.io.IOException;
import java.io.Reader;

import manual.alex.AnalizadorLexicoTiny;
import manual.alex.ClaseLexica;
import manual.alex.UnidadLexica;
import manual.errors.GestionErroresTiny;

public class AnalizadorSintacticoTiny {
	private UnidadLexica anticipo;
	private AnalizadorLexicoTiny alex;
	private GestionErroresTiny errores;

	public AnalizadorSintacticoTiny(Reader input) {
		errores = new GestionErroresTiny();
		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();
	}

	public void Sp() {
		S();
		empareja(ClaseLexica.EOF);
	}

	private void S() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
			X();
			empareja(ClaseLexica.SEPSEC);
			E();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void X() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
			XD();
			RXD();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void XD() {
		switch (anticipo.clase()) {
		case BOOL:
			empareja(ClaseLexica.BOOL);
			empareja(ClaseLexica.ID);
			break;
		case INT:
			empareja(ClaseLexica.INT);
			empareja(ClaseLexica.ID);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void RXD() {
		switch (anticipo.clase()) {
		case PUNTOCOMA:
			empareja(ClaseLexica.PUNTOCOMA);
			XD();
			RXD();
			break;
		case SEPSEC:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PUNTOCOMA, ClaseLexica.SEPSEC);
		}
	}

	private void E() {
		switch (anticipo.clase()) {
		case NOT:
		case MENOS:
		case ID:
		case NUM:
		case PAP:
			E0();
			RE();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NOT, ClaseLexica.MENOS, ClaseLexica.ID,
					ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void E0() {
		switch (anticipo.clase()) {
		case NOT:
		case MENOS:
		case ID:
		case NUM:
		case PAP:
			E1();
			RE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NOT, ClaseLexica.MENOS, ClaseLexica.ID,
					ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void E1() {
		switch (anticipo.clase()) {
		case NOT:
		case MENOS:
		case ID:
		case NUM:
		case PAP:
			E2();
			RE1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NOT, ClaseLexica.MENOS, ClaseLexica.ID,
					ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case NOT:
		case MENOS:
		case ID:
		case NUM:
		case PAP:
			E3();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NOT, ClaseLexica.MENOS, ClaseLexica.ID,
					ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case NOT:
		case MENOS:
			empareja(anticipo.clase());
			E3();
			break;
		case ID:
		case NUM:
		case PAP:
			E4();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NOT, ClaseLexica.MENOS, ClaseLexica.ID,
					ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case ID:
		case NUM:
			empareja(anticipo.clase());
			break;
		case PAP:
			empareja(ClaseLexica.PAP);
			E0();
			empareja(ClaseLexica.PCIERRE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ID, ClaseLexica.NUM, ClaseLexica.PAP);
		}
	}

	private void RE() {
		switch (anticipo.clase()) {
		case PUNTOCOMA:
			empareja(ClaseLexica.PUNTOCOMA);
			E0();
			RE();
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PUNTOCOMA, ClaseLexica.SEPSEC);
		}
	}

	private void RE0() {
		switch (anticipo.clase()) {
		case LT:
		case ELT:
		case GT:
		case EGT:
		case NEQ:
		case EQ:
			empareja(anticipo.clase());
			E1();
			break;
		case ASIG:
			empareja(ClaseLexica.ASIG);
			E0();
			break;
		case PCIERRE:
		case PUNTOCOMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.LT, ClaseLexica.ELT, ClaseLexica.GT,
					ClaseLexica.EGT, ClaseLexica.NEQ, ClaseLexica.EQ,
					ClaseLexica.ASIG, ClaseLexica.PCIERRE,
					ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}

	private void RE1() {
		switch (anticipo.clase()) {
		case LT:
		case ELT:
		case GT:
		case EGT:
		case NEQ:
		case EQ:
		case ASIG:
		case PCIERRE:
		case PUNTOCOMA:
		case EOF:
			break;
		case MAS:
		case MENOS:
		case OR:
			empareja(anticipo.clase());
			E2();
			RE1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.LT, ClaseLexica.ELT, ClaseLexica.GT,
					ClaseLexica.EGT, ClaseLexica.NEQ, ClaseLexica.EQ,
					ClaseLexica.ASIG, ClaseLexica.PCIERRE,
					ClaseLexica.PUNTOCOMA, ClaseLexica.EOF, ClaseLexica.MAS,
					ClaseLexica.MENOS, ClaseLexica.OR);
		}
	}

	private void RE2() {
		switch (anticipo.clase()) {
		case LT:
		case ELT:
		case GT:
		case EGT:
		case NEQ:
		case EQ:
		case MAS:
		case MENOS:
		case OR:
		case ASIG:
		case PCIERRE:
		case PUNTOCOMA:
		case EOF:
			break;
		case POR:
		case DIV:
		case AND:
			empareja(anticipo.clase());
			E3();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.LT, ClaseLexica.ELT, ClaseLexica.GT,
					ClaseLexica.EGT, ClaseLexica.NEQ, ClaseLexica.EQ,
					ClaseLexica.ASIG, ClaseLexica.PCIERRE,
					ClaseLexica.PUNTOCOMA, ClaseLexica.EOF, ClaseLexica.MAS,
					ClaseLexica.MENOS, ClaseLexica.OR, ClaseLexica.POR,
					ClaseLexica.DIV, ClaseLexica.AND);
		}
	}

	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					claseEsperada);
	}

	private void sigToken() {
		try {
			anticipo = alex.yylex();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}

}
