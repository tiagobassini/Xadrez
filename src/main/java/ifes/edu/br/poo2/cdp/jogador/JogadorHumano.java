/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.jogador;

import ifes.edu.br.poo2.cdp.peca.EnumCor;

/**
 *
 * @author tiago
 */
public class JogadorHumano extends JogadorImp{
    
    public JogadorHumano(EnumCor cor){
        this.cor = cor;
    }

    @Override
    public String realizarJogada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
