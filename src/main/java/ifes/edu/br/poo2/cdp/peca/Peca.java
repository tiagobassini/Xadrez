/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.peca;

import ifes.edu.br.poo2.cdp.movimento.Movimento;
import ifes.edu.br.poo2.cdp.movimento.Posicao;
import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public interface Peca extends Cloneable{
    
    
    public  boolean movimento(Posicao origem, Posicao destino, Tabuleiro tabuleiro)throws Exception;
    public  boolean captura(Posicao origem, Posicao destino, Tabuleiro tabuleiro)throws Exception;
    public Object clone();

    public EnumCor getCor();
    public EnumPeca getTipo();
    public String getNome();
    public void setCor(EnumCor cor);

    
}
