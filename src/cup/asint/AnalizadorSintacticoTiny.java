
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Mon May 05 10:58:33 CEST 2014
//----------------------------------------------------

package cup.asint;

import java_cup.runtime.*;
import cup.alex.AnalizadorLexicoTiny;
import cup.alex.UnidadLexica;
import cup.errors.GestionErroresTiny;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Mon May 05 10:58:33 CEST 2014
  */
public class AnalizadorSintacticoTiny extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoTiny() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\047\000\002\002\003\000\002\002\004\000\002\003" +
    "\005\000\002\003\002\000\002\004\005\000\002\004\003" +
    "\000\002\005\004\000\002\005\004\000\002\006\005\000" +
    "\002\006\003\000\002\007\003\000\002\010\005\000\002" +
    "\011\005\000\002\011\003\000\002\012\005\000\002\012" +
    "\003\000\002\013\005\000\002\013\003\000\002\014\004" +
    "\000\002\014\003\000\002\015\003\000\002\015\003\000" +
    "\002\015\003\000\002\015\003\000\002\015\005\000\002" +
    "\016\003\000\002\016\003\000\002\016\003\000\002\016" +
    "\003\000\002\016\003\000\002\016\003\000\002\017\003" +
    "\000\002\017\003\000\002\017\003\000\002\020\003\000" +
    "\002\020\003\000\002\020\003\000\002\021\003\000\002" +
    "\021\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\010\002\ufffe\024\007\025\011\001\002\000" +
    "\004\002\070\001\002\000\004\002\001\001\002\000\004" +
    "\033\016\001\002\000\004\004\015\001\002\000\006\015" +
    "\013\033\ufffc\001\002\000\004\004\012\001\002\000\006" +
    "\015\ufffa\033\ufffa\001\002\000\006\024\007\025\011\001" +
    "\002\000\004\033\ufffd\001\002\000\006\015\ufffb\033\ufffb" +
    "\001\002\000\004\004\017\001\002\000\004\014\025\001" +
    "\002\000\006\002\ufff7\015\ufff7\001\002\000\004\002\uffff" +
    "\001\002\000\006\002\ufff8\015\023\001\002\000\004\004" +
    "\017\001\002\000\004\002\ufff9\001\002\000\020\004\034" +
    "\005\026\007\030\012\031\030\037\031\032\032\033\001" +
    "\002\000\040\002\uffec\006\uffec\007\uffec\010\uffec\011\uffec" +
    "\013\uffec\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022" +
    "\uffec\023\uffec\026\uffec\027\uffec\001\002\000\020\004\034" +
    "\005\026\007\030\012\031\030\037\031\032\032\033\001" +
    "\002\000\020\004\uffdc\005\uffdc\007\uffdc\012\uffdc\030\uffdc" +
    "\031\uffdc\032\uffdc\001\002\000\020\004\034\005\026\007" +
    "\030\012\031\030\037\031\032\032\033\001\002\000\040" +
    "\002\uffeb\006\uffeb\007\uffeb\010\uffeb\011\uffeb\013\uffeb\015" +
    "\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\022\uffeb\023\uffeb" +
    "\026\uffeb\027\uffeb\001\002\000\040\002\uffea\006\uffea\007" +
    "\uffea\010\uffea\011\uffea\013\uffea\015\uffea\016\uffea\017\uffea" +
    "\020\uffea\021\uffea\022\uffea\023\uffea\026\uffea\027\uffea\001" +
    "\002\000\040\002\uffed\006\uffed\007\uffed\010\uffed\011\uffed" +
    "\013\uffed\015\uffed\016\uffed\017\uffed\020\uffed\021\uffed\022" +
    "\uffed\023\uffed\026\uffed\027\uffed\001\002\000\040\002\uffee" +
    "\006\uffee\007\uffee\010\uffee\011\uffee\013\uffee\015\uffee\016" +
    "\uffee\017\uffee\020\uffee\021\uffee\022\uffee\023\uffee\026\uffee" +
    "\027\uffee\001\002\000\040\002\ufff0\006\ufff0\007\ufff0\010" +
    "\ufff0\011\ufff0\013\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0" +
    "\021\ufff0\022\ufff0\023\ufff0\026\ufff0\027\ufff0\001\002\000" +
    "\020\004\uffdb\005\uffdb\007\uffdb\012\uffdb\030\uffdb\031\uffdb" +
    "\032\uffdb\001\002\000\040\002\ufff2\006\ufff2\007\ufff2\010" +
    "\063\011\062\013\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2" +
    "\021\ufff2\022\ufff2\023\ufff2\026\061\027\ufff2\001\002\000" +
    "\032\002\ufff4\006\050\007\043\013\ufff4\015\ufff4\016\046" +
    "\017\047\020\051\021\052\022\053\023\054\027\055\001" +
    "\002\000\006\002\ufff6\015\ufff6\001\002\000\020\004\uffe1" +
    "\005\uffe1\007\uffe1\012\uffe1\030\uffe1\031\uffe1\032\uffe1\001" +
    "\002\000\020\004\034\005\026\007\030\012\031\030\037" +
    "\031\032\032\033\001\002\000\020\004\034\005\026\007" +
    "\030\012\031\030\037\031\032\032\033\001\002\000\020" +
    "\004\uffe7\005\uffe7\007\uffe7\012\uffe7\030\uffe7\031\uffe7\032" +
    "\uffe7\001\002\000\020\004\uffe8\005\uffe8\007\uffe8\012\uffe8" +
    "\030\uffe8\031\uffe8\032\uffe8\001\002\000\020\004\uffe2\005" +
    "\uffe2\007\uffe2\012\uffe2\030\uffe2\031\uffe2\032\uffe2\001\002" +
    "\000\020\004\uffe6\005\uffe6\007\uffe6\012\uffe6\030\uffe6\031" +
    "\uffe6\032\uffe6\001\002\000\020\004\uffe5\005\uffe5\007\uffe5" +
    "\012\uffe5\030\uffe5\031\uffe5\032\uffe5\001\002\000\020\004" +
    "\uffe4\005\uffe4\007\uffe4\012\uffe4\030\uffe4\031\uffe4\032\uffe4" +
    "\001\002\000\020\004\uffe3\005\uffe3\007\uffe3\012\uffe3\030" +
    "\uffe3\031\uffe3\032\uffe3\001\002\000\020\004\uffe0\005\uffe0" +
    "\007\uffe0\012\uffe0\030\uffe0\031\uffe0\032\uffe0\001\002\000" +
    "\016\002\ufff5\006\050\007\043\013\ufff5\015\ufff5\027\055" +
    "\001\002\000\040\002\ufff3\006\ufff3\007\ufff3\010\063\011" +
    "\062\013\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3" +
    "\022\ufff3\023\ufff3\026\061\027\ufff3\001\002\000\020\004" +
    "\034\005\026\007\030\012\031\030\037\031\032\032\033" +
    "\001\002\000\020\004\uffdd\005\uffdd\007\uffdd\012\uffdd\030" +
    "\uffdd\031\uffdd\032\uffdd\001\002\000\020\004\uffde\005\uffde" +
    "\007\uffde\012\uffde\030\uffde\031\uffde\032\uffde\001\002\000" +
    "\020\004\uffdf\005\uffdf\007\uffdf\012\uffdf\030\uffdf\031\uffdf" +
    "\032\uffdf\001\002\000\040\002\ufff1\006\ufff1\007\ufff1\010" +
    "\ufff1\011\ufff1\013\ufff1\015\ufff1\016\ufff1\017\ufff1\020\ufff1" +
    "\021\ufff1\022\ufff1\023\ufff1\026\ufff1\027\ufff1\001\002\000" +
    "\004\013\066\001\002\000\040\002\uffe9\006\uffe9\007\uffe9" +
    "\010\uffe9\011\uffe9\013\uffe9\015\uffe9\016\uffe9\017\uffe9\020" +
    "\uffe9\021\uffe9\022\uffe9\023\uffe9\026\uffe9\027\uffe9\001\002" +
    "\000\040\002\uffef\006\uffef\007\uffef\010\uffef\011\uffef\013" +
    "\uffef\015\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef" +
    "\023\uffef\026\uffef\027\uffef\001\002\000\004\002\000\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\012\002\003\003\004\004\005\005\007\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\004\013\005\007\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\006\020\007\021\010" +
    "\017\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\006\023\007\021\010" +
    "\017\001\001\000\002\001\001\000\016\011\041\012\040" +
    "\013\037\014\035\015\034\021\026\001\001\000\002\001" +
    "\001\000\010\014\066\015\034\021\026\001\001\000\002" +
    "\001\001\000\016\011\064\012\040\013\037\014\035\015" +
    "\034\021\026\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\020\057\001\001\000\006\016\044" +
    "\017\043\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\013\056\014\035\015\034\021\026\001\001\000\014" +
    "\012\055\013\037\014\035\015\034\021\026\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\017\043\001\001\000\004" +
    "\020\057\001\001\000\010\014\063\015\034\021\026\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoTiny$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoTiny$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoTiny$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErroresTiny();
   AnalizadorLexicoTiny alex = (AnalizadorLexicoTiny)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresTiny errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoTiny$actions {
  private final AnalizadorSintacticoTiny parser;

  /** Constructor */
  CUP$AnalizadorSintacticoTiny$actions(AnalizadorSintacticoTiny parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action_part00000000(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoTiny$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // ProgramaPrima ::= Programa 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("ProgramaPrima",0, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= ProgramaPrima EOF 
            {
              Object RESULT =null;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoTiny$stack.elementAt(CUP$AnalizadorSintacticoTiny$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoTiny$parser.done_parsing();
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Programa ::= Declaraciones SEPSEC Instrucciones 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Programa",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Programa ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Programa",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Declaraciones ::= Declaracion PUNTOCOMA Declaraciones 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Declaraciones",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Declaraciones ::= Declaracion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Declaraciones",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Declaracion ::= BOOL ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Declaracion",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Declaracion ::= INT ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Declaracion",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Instrucciones ::= Instruccion PUNTOCOMA Instrucciones 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Instrucciones",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Instrucciones ::= Instruccion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Instrucciones",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Instruccion ::= InstruccionAsig 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Instruccion",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // InstruccionAsig ::= ID ASIG E0 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("InstruccionAsig",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E0 ::= E1 OP0 E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E0",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E0 ::= E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E0",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E1 ::= E1 OP1 E2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E1 ::= E2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E2 ::= E2 OP2 E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // E2 ::= E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // E3 ::= OP3 E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // E3 ::= E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // E4 ::= ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // E4 ::= NUM 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // E4 ::= TRUE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // E4 ::= FALSE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // E4 ::= PAP E0 PCIERRE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OP0 ::= EQ 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // OP0 ::= NEQ 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // OP0 ::= GT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // OP0 ::= EGT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // OP0 ::= LT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // OP0 ::= ELT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // OP1 ::= MAS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP1",13, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // OP1 ::= MENOS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP1",13, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // OP1 ::= OR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP1",13, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // OP2 ::= POR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // OP2 ::= DIV 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // OP2 ::= AND 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // OP3 ::= MENOS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP3",15, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // OP3 ::= NOT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP3",15, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintacticoTiny$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintacticoTiny$do_action_part00000000(
                               CUP$AnalizadorSintacticoTiny$act_num,
                               CUP$AnalizadorSintacticoTiny$parser,
                               CUP$AnalizadorSintacticoTiny$stack,
                               CUP$AnalizadorSintacticoTiny$top);
    }
}

