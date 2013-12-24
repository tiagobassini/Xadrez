/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.partida;

import ifes.edu.br.poo2.cdp.jogador.Jogador;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroDirector;

/**
 *
 * @author tiago
 */
public class Partida {
    
    Jogador jogadorBranco, jogadorPreto;
    Tabuleiro tabuleiro;
    
    public Partida(){
        
        TabuleiroBuilder builder = new TabuleiroBuilder(new Tabuleiro());
        TabuleiroDirector director = new TabuleiroDirector();
        
        this.tabuleiro = director.build(builder);
        
    }
    

    public Jogador getJogadorBranco() {
        return jogadorBranco;
    }

    public void setJogadorBranco(Jogador jogadorBranco) {
        this.jogadorBranco = jogadorBranco;
    }

    public Jogador getJogadorPreto() {
        return jogadorPreto;
    }

    public void setJogadorPreto(Jogador jogadorPreto) {
        this.jogadorPreto = jogadorPreto;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    
    
}
