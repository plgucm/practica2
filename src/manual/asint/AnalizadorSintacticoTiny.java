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
			empareja(ClaseLexica.IDEN);
			break;
		case INT:
			empareja(ClaseLexica.INT);
			empareja(ClaseLexica.IDEN);
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
		case MENOS:
		case IDEN:
		case ENT:
		case PAP:
			E0();
			RE();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.IDEN, ClaseLexica.ENT,
					ClaseLexica.PAP);
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

	private void E0() {
		switch (anticipo.clase()) {
		case MENOS:
		case IDEN:
		case ENT:
		case PAP:
			E1();
			RE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.IDEN, ClaseLexica.ENT,
					ClaseLexica.PAP);
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

	private void E1() {
		switch (anticipo.clase()) {
		case MENOS:
		case IDEN:
		case ENT:
		case PAP:
			E2();
			RE1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.IDEN, ClaseLexica.ENT,
					ClaseLexica.PAP);
		}
	}

	private void RE1() {
		switch (anticipo.clase()) {
		case MAS:
		case MENOS:
		case OR:
			empareja(anticipo.clase());
			RE11();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.OR);
		}
	}

	private void RE11() {
		switch (anticipo.clase()) {
		case LT:
		case ELT:
		case GT:
		case EGT:
		case NEQ:
		case EQ:
			break;
		case MAS:
		case OR:
			break;
		case MENOS: // OP1 (MENOS BINARIO) y OP3 (MENOS UNARIO)??
			E1();
			RE1();
			break;
		case IDEN:
		case ENT:
		case PAP:
			E1();
			RE1();
			break;
		case ASIG:
		case PCIERRE:
		case PUNTOCOMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.LT, ClaseLexica.ELT, ClaseLexica.GT,
					ClaseLexica.EGT, ClaseLexica.NEQ, ClaseLexica.EQ,
					ClaseLexica.MAS, ClaseLexica.OR, ClaseLexica.MENOS,
					ClaseLexica.IDEN, ClaseLexica.ENT, ClaseLexica.PAP,
					ClaseLexica.ASIG, ClaseLexica.PCIERRE,
					ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case MENOS:
		case IDEN:
		case ENT:
		case PAP:
			E3();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.IDEN, ClaseLexica.ENT,
					ClaseLexica.PAP);
		}
	}

	private void RE2() {
		switch (anticipo.clase()) {
		case POR:
		case DIV:
		case AND:
			empareja(anticipo.clase());
			RE22();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.POR, ClaseLexica.DIV, ClaseLexica.AND);
		}
	}

	private void RE22() {
		switch (anticipo.clase()) {
		case MAS:
		case OR:
			break;
		case POR:
		case DIV:
		case AND:
			break;
		case MENOS: // OP1 (MENOS BINARIO) y OP3 (MENOS UNARIO)??
			E2();
			RE2();
			break;
		case IDEN:
		case ENT:
		case PAP:
			E2();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MAS, ClaseLexica.OR, ClaseLexica.POR,
					ClaseLexica.DIV, ClaseLexica.AND, ClaseLexica.MENOS,
					ClaseLexica.IDEN, ClaseLexica.ENT, ClaseLexica.PAP);
		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case MENOS:
			empareja(ClaseLexica.MENOS);
			E4();
			break;
		case IDEN:
		case ENT:
		case PAP:
			E4();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.IDEN, ClaseLexica.ENT,
					ClaseLexica.PAP);
		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case IDEN:
		case ENT:
		case PAP:
			E5();
			RE4();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN, ClaseLexica.ENT, ClaseLexica.PAP);
		}
	}

	private void RE4() {
		switch (anticipo.clase()) {
		case MENOS:
			break;
		//case OP4: ?CUAL ES OP4??
		default:
			/*errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS);*/
		}
	}

	private void E5() {
		switch (anticipo.clase()) {
		case IDEN:
		case ENT:
			empareja(anticipo.clase());
			break;
		case PAP:
			empareja(ClaseLexica.PAP);
			E0();
			empareja(ClaseLexica.PCIERRE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN, ClaseLexica.ENT, ClaseLexica.PAP);
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
