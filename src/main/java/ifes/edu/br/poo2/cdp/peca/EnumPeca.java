/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.peca;

/**
 *
 * @author tiago
 */
public enum EnumPeca {
    PEAO("Peao"), CAVALO("Cavalo"), BISPO("Bispo"),
    TORRE("Torre"), REI("Rei"), RAINHA("Rainha");

    private final String nome;
    
    EnumPeca(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
}
