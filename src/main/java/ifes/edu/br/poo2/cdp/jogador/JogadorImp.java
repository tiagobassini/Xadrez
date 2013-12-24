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
public abstract class JogadorImp implements Jogador{
    protected EnumCor cor;
    protected String nome;
    public abstract String realizarJogada();
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
}
