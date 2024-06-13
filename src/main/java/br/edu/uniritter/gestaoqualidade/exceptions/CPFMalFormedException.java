package br.edu.uniritter.gestaoqualidade.exceptions;



public class CPFMalFormedException extends Exception{
    public CPFMalFormedException() {
        super(  "CPF mal formado");
    }
}