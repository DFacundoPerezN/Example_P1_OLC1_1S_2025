/* 1. Package e importaciones */
package Analizadores;
import java_cup.runtime.*;

%%
/* 2. Configuraciones para el analisis (Opciones y Declaraciones) */
%{
    //Codigo de usuario en sintaxis java
    //Agregar clases, variables, arreglos, objetos etc...
    public class Lexema{        
            public String lexema;
            public String token;


            public Lexema(String lexema, String token){
            this.lexema = lexema;
            this.token = token;
        }
    }
%}

//Directivas
%class Scanner
%public 
%cup
%char
%column
%full
%line
%unicode
//%ignorecase
//%debug

//Inicializar el contador de yychar y fila con 1
%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

//Expresiones regulares
BOOL = "true"| "false"
NUM = [0-9]+
DEC = [0-9]+"."[0-9]+
BLANCOS=[ \r\t]+
ID =  [a-zA-Z][a-zA-Z_0-9]*
ACC = "D" | "C"

//Palabras reservadas
%%
"AND" {    
    return new Symbol(sym.AND,yyline,yychar,yytext());
}
"if" {    
    return new Symbol(sym.PR_IF,yyline,yychar,yytext());
} 
"then" {    
    return new Symbol(sym.PR_THEN,yyline,yychar,yytext());
}
"rules" {    
    return new Symbol(sym.PR_RULES,yyline,yychar,yytext());
}
"else" {    
    return new Symbol(sym.PR_ELSE,yyline,yychar,yytext());
} 
"initial" {    
    return new Symbol(sym.PR_INITIAL,yyline,yychar,yytext());
}
"strategy" {    
    return new Symbol(sym.PR_STRATEGY,yyline,yychar,yytext());
}
"players" {    
    return new Symbol(sym.PR_PLAYERS,yyline,yychar,yytext());
}
"strategies" {    
    return new Symbol(sym.PR_STRATEGIES,yyline,yychar,yytext());
}
"rounds" {    
    return new Symbol(sym.PR_ROUNDS,yyline,yychar,yytext());
}
"scoring" {    
    return new Symbol(sym.PR_SCORING,yyline,yychar,yytext());
}
"mutual" {    
    return new Symbol(sym.PR_MUTUAL,yyline,yychar,yytext());
}
"defection" {    
    return new Symbol(sym.PR_DEFECTION,yyline,yychar,yytext());
}
"reward" {    
    return new Symbol(sym.PR_REWARD,yyline,yychar,yytext());
}
"cooperation" {    
    return new Symbol(sym.PR_COOPERATION,yyline,yychar,yytext());
}
"betrayal" {    
    return new Symbol(sym.PR_BETRAYAL,yyline,yychar,yytext());
}
"punishment" {    
    return new Symbol(sym.PR_PUNISHMENT,yyline,yychar,yytext());
}
"match" {    
    return new Symbol(sym.PR_MATCH,yyline,yychar,yytext());
}
"run" {    
    return new Symbol(sym.PR_RUN,yyline,yychar,yytext());
}
"with" {    
    return new Symbol(sym.PR_WITH,yyline,yychar,yytext());
}
"seed" {    
    return new Symbol(sym.PR_SEED,yyline,yychar,yytext());
}


//Simbolos
"[" {    
    return new Symbol(sym.COR_IZQ,yyline,yychar,yytext());
}
"]" {    
    return new Symbol(sym.COR_DER,yyline,yychar,yytext());
} 
"{" {    
    return new Symbol(sym.LLAV_IZQ,yyline,yychar,yytext());
} 
"}" {    
    return new Symbol(sym.LLAV_DER,yyline,yychar,yytext());
} 
//Operadores
"&&" {    
    return new Symbol(sym.AND,yyline,yychar,yytext());
}
"||" {
    return new Symbol(sym.OR,yyline,yychar,yytext());
} 
"!" {
    return new Symbol(sym.NOT,yyline,yychar,yytext());
} 
"==" {
    return new Symbol(sym.EQUAL,yyline,yychar,yytext());
} 
//Signos de puntuacion 
"," {
    return new Symbol(sym.COMA,yyline,yychar,yytext());
} 
":" {
    return new Symbol(sym.DOS_PUNTOS,yyline,yychar,yytext());
} 

\n {yychar=1 ;} //en cambio de linea reinicia la columna

{BLANCOS} {}
{BOOL} {//System.out.println("Reconocio BOOL: "+yytext());  
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.BOOLEANO,yyline,yychar, yytext());
} 
{ACC} {
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.ACCION,yyline,yychar, yytext());
}  
{NUM} {
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.ENTERO,yyline,yychar, yytext());
} 
{ID} {
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.ID,yyline,yychar, yytext());
} 


//errores
. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}