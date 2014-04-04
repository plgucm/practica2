package cup.alex;

import cup.asint.ClaseLexica;

public class ALexOperations {
	private AnalizadorLexicoTiny alex;
	public ALexOperations(AnalizadorLexicoTiny alex) {
		this.alex = alex;   
	}
	public UnidadLexica unidadId() {
		return new UnidadLexica(alex.fila(),ClaseLexica.ID,
				alex.lexema()); 
	} 
	public UnidadLexica unidadEnt() {
		return new UnidadLexica(alex.fila(),ClaseLexica.NUM,alex.lexema()); 
	}
	public UnidadLexica unidadMas() {
		return new UnidadLexica(alex.fila(),ClaseLexica.MAS, "+"); 
	} 
	public UnidadLexica unidadMenos() {
		return new UnidadLexica(alex.fila(),ClaseLexica.MENOS, "-"); 
	} 
	public UnidadLexica unidadPor() {
		return new UnidadLexica(alex.fila(),ClaseLexica.POR, "*"); 
	} 
	public UnidadLexica unidadDiv() {
		return new UnidadLexica(alex.fila(),ClaseLexica.DIV, "/"); 
	} 
	public UnidadLexica unidadPAp() {
		return new UnidadLexica(alex.fila(),ClaseLexica.PAP, "("); 
	} 
	public UnidadLexica unidadPCierre() {
		return new UnidadLexica(alex.fila(),ClaseLexica.PCIERRE, ")"); 
	} 
	public UnidadLexica unidadAsig() {
		return new UnidadLexica(alex.fila(),ClaseLexica.ASIG, "="); 
	} 
	public UnidadLexica unidadPuntoComa() {
		return new UnidadLexica(alex.fila(),ClaseLexica.PUNTOCOMA, ";"); 
	} 
	public UnidadLexica unidadEof() {
		return new UnidadLexica(alex.fila(),ClaseLexica.EOF, "<EOF>"); 
	}    
	public UnidadLexica unidadEQ() {
		return new UnidadLexica(alex.fila(),ClaseLexica.NEQ, "!=");     
	}    
	public UnidadLexica unidadNEQ() {
		return new UnidadLexica(alex.fila(),ClaseLexica.EQ, "==");     
	}    
	public UnidadLexica unidadGT() {
		return new UnidadLexica(alex.fila(),ClaseLexica.GT, ">");     
	}    
	public UnidadLexica unidadEGT() {
		return new UnidadLexica(alex.fila(),ClaseLexica.EGT, ">=");     
	}    
	public UnidadLexica unidadLT() {
		return new UnidadLexica(alex.fila(),ClaseLexica.LT, "<");     
	}    
	public UnidadLexica unidadELT() {
		return new UnidadLexica(alex.fila(),ClaseLexica.ELT, "<=");     
	}    
	public UnidadLexica unidadBool() {
		return new UnidadLexica(alex.fila(),ClaseLexica.BOOL, "bool");     
	}   
	public UnidadLexica unidadInt() {
		return new UnidadLexica(alex.fila(),ClaseLexica.INT, "int");     
	}     
	public UnidadLexica unidadAnd() {
		return new UnidadLexica(alex.fila(),ClaseLexica.AND, "and");     
	}     
	public UnidadLexica unidadOr() {
		return new UnidadLexica(alex.fila(),ClaseLexica.OR, "or");     
	}    
	public UnidadLexica unidadNot() {
		return new UnidadLexica(alex.fila(),ClaseLexica.NOT, "not");     
	}  
	public UnidadLexica unidadTrue() {
		return new UnidadLexica(alex.fila(),ClaseLexica.TRUE, "true");     
	}   
	public UnidadLexica unidadFalse() {
		return new UnidadLexica(alex.fila(),ClaseLexica.FALSE, "false");     
	}  
	public UnidadLexica unidadSepSec() {
		return new UnidadLexica(alex.fila(),ClaseLexica.SEPSEC, "&&");     
	}
}
