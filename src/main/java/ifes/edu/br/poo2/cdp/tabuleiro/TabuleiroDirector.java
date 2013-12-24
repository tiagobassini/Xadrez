/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.tabuleiro;

/**
 *
 * @author tiago
 */
public class TabuleiroDirector {
    
    public Tabuleiro build( TabuleiroBuilder builder){
        
        builder.buildCasas();
        builder.buildPecasPretas();
        builder.buildPecasBrancas();
        
        
        return builder.getTabuleiro();
    }
    
}
