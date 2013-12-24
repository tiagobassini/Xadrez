/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.movimento;

import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public class MovimentoPeaoPrimario extends MovimentoAbstract {

    @Override
    public boolean mover(Posicao origem, Posicao destino) {

        int diferencaLinha  = Util.diferencaAbsoluta(destino.getLinha(), origem.getLinha());
        int diferencaColuna = Util.diferencaAbsoluta(destino.getColuna(), origem.getColuna());
        
        return (diferencaLinha>0 && diferencaLinha<=2 && diferencaColuna==0);
    }
    
}
