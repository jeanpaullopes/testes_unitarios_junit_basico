package br.edu.uniritter.gestaoqualidade.controllers;

import br.edu.uniritter.gestaoqualidade.exceptions.CPFMalFormedException;
import br.edu.uniritter.gestaoqualidade.exceptions.CPFIncompleteException;

public class AppController {
    public static boolean checkCPF(String cpf) throws CPFIncompleteException, CPFMalFormedException {
        //if (cpf.length() != 14) {
        //    throw new CPFIncompleteException();
        //}
        if (cpf.charAt(3) != '.' || cpf.charAt(7) != '.' || cpf.charAt(11) != '-') {
            throw new CPFMalFormedException();
        }
        return true;
    }

}
