/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cgt;

import ifes.edu.br.poo2.cci.MenuOpcaoInterpretador;


/**
 *
 * @author tiago
 */
public class JogoControle {
    public void start()throws Exception{
        MenuOpcaoInterpretador menuInterpretador = new MenuOpcaoInterpretador();
        menuInterpretador.menuIncialInterpreter();
    }
}
