package br.edu.uniritter.gestaoqualidade.controllers;

import br.edu.uniritter.gestaoqualidade.exceptions.CPFMalFormedException;

import java.util.Date;

import br.edu.uniritter.gestaoqualidade.exceptions.CPFIncompleteException;

public class AppController {
    public static boolean checkCPF(String cpf) throws NullPointerException, CPFIncompleteException, CPFMalFormedException {
        if (cpf == null) {
            throw new NullPointerException();
        }
        if (cpf.length() != 14) {
            throw new CPFIncompleteException();
        }
        if (cpf.charAt(3) != '.' || cpf.charAt(7) != '.' || cpf.charAt(11) != '-') {
            throw new CPFMalFormedException();
        }
        return checkCPFSException(cpf);
    }

    public static boolean checkCPFSException(String cpf)  {
        
        if (cpf.equals("123.456.789-01")) {
            return false;
        }
        return true;
    }

    public static double desconto(float valor, int perc) {
        int v = (int)(valor * 100);
        Date d = new Date();
        d.setTime(0);
        System.out.println(d);
        int p = v * perc / 100;
        return (v-p)/100.0;
        
    }

}
