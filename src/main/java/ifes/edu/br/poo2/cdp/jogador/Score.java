/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.jogador;

/**
 *
 * @author tiago
 */
public class Score {
    Jogador jogadorBranco;
    Jogador jogadorPreto;
    int pontosbranco;
    int pontospreto;
    
    public Score(Jogador jogadorbranco, Jogador jogadorpreto)
    {
        this.jogadorBranco = jogadorbranco;
        this.jogadorPreto = jogadorpreto;
    }
//    public Score(Jogador jogador, int pontos){
//        this.jogadorBranco = jogador;
//        this.pontosbranco = pontos;
//    }
    
    public int getPontosBranco(){
        return this.pontosbranco;
    }
    
    public int getPontosPreto(){
        return this.pontosbranco;
    }
    
    public void setPontosBranco(int ponto){
        this.pontosbranco = ponto;
    }
    
    public void setPontosPreto(int ponto){
        this.pontosbranco = ponto;
    }
    
    public String getNomeJogadorBranco(){
        return this.jogadorBranco.getNome();
    }
    public String getNomeJogadorPreto(){
        return this.jogadorBranco.getNome();
    }
}
