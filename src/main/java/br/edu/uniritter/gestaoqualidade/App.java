package br.edu.uniritter.gestaoqualidade;

import br.edu.uniritter.gestaoqualidade.controllers.AppController;
import br.edu.uniritter.gestaoqualidade.exceptions.CPFIncompleteException;
import br.edu.uniritter.gestaoqualidade.exceptions.CPFMalFormedException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            AppController.checkCPF("123.456.789");
        } catch (CPFIncompleteException | CPFMalFormedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
