#!/bin/bash
java -cp cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -dump_states -symbols ClaseLexica -nopositions Tiny.cup 
