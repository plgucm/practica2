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

	public void ProgramaPrima() {
		Programa();
		empareja(ClaseLexica.EOF);
	}

	private void Programa() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
			Declaraciones();
			empareja(ClaseLexica.SEPSEC);
			Instrucciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void Declaraciones() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
			Declaracion();
			RestoDeclaraciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void Declaracion() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
			empareja(anticipo.clase());
			empareja(ClaseLexica.ID);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT);
		}
	}

	private void RestoDeclaraciones() {
		switch (anticipo.clase()) {
		case PUNTOCOMA:
			empareja(ClaseLexica.PUNTOCOMA);
			Declaraciones();
			break;
		case SEPSEC:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PUNTOCOMA, ClaseLexica.SEPSEC);
		}
	}

	private void Instrucciones() {
		switch (anticipo.clase()) {
		case ID:
			Instruccion();
			RestoInstrucciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ID);
		}
	}

	private void Instruccion() {
		switch (anticipo.clase()) {
		case ID:
			InstruccionAsig();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ID);
		}
	}
	
	private void InstruccionAsig() {
		switch (anticipo.clase()) {
		case ID:
			empareja(ClaseLexica.ID);
			empareja(ClaseLexica.ASIG);
			E0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ID);
		}
	}

	private void RestoInstrucciones() {
		switch (anticipo.clase()) {
		case PUNTOCOMA:
			empareja(ClaseLexica.PUNTOCOMA);
			Instrucciones();
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PUNTOCOMA);
		}
	}

	private void E0() {
		switch (anticipo.clase()) {
		case TRUE:
		case FALSE:
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
		case TRUE:
		case FALSE:
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
		case TRUE:
		case FALSE:
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
		case TRUE:
		case FALSE:
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
		case TRUE:
		case FALSE:
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
