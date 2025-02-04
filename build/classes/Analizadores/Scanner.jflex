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
%ignorecase
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

//Palabras reservadas
%%
"AND" {    
    return new Symbol(sym.AND,yyline,yychar,yytext());
}

//Simbolos
"&&" {    
    return new Symbol(sym.AND,yyline,yychar,yytext());
}
"||" {
    return new Symbol(sym.OR,yyline,yychar,yytext());
} 

{BLANCOS} {}
{BOOL} {System.out.println("Reconocio BOOL: "+yytext());  
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.BOOLEANO,yyline,yychar, yytext());
} 

//errores
. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}