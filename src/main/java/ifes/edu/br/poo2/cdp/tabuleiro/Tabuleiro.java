/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.poo2.cdp.tabuleiro;

import ifes.edu.br.poo2.cdp.jogador.Score;
import ifes.edu.br.poo2.cdp.movimento.Posicao;
import ifes.edu.br.poo2.cdp.peca.EnumCor;
import ifes.edu.br.poo2.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.cdp.peca.Peca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiago
 */
public class Tabuleiro extends Item {

    final int QUANTIDADELINHAS = 8;
    final int QUANTIDADECOLUNAS = 8;
    private Casa[][] casas;

    //List cemiterio;
    ArrayList<Peca> cemiterio;

    public ArrayList<Peca> GetCemiterio() {
        return this.cemiterio;
    }

    public Tabuleiro() {

        casas = new Casa[this.QUANTIDADELINHAS][this.QUANTIDADECOLUNAS];
        cemiterio = new ArrayList();
    }

    public int CalcularScoreBranco() {
        int interador = 0;
        int score=0;
        Peca peca;
        while (interador < this.cemiterio.size()) {
            peca = cemiterio.get(interador);
            if(peca.getCor()==EnumCor.PRETO)
            {
                if(peca.getTipo()== EnumPeca.BISPO)
                {
                    score = score + 3;
                }
                if(peca.getTipo()==EnumPeca.CAVALO)
                {
                    score = score + 3;
                }
                if(peca.getTipo() == EnumPeca.PEAO)
                {
                    score = score + 1;
                }
                if(peca.getTipo() == EnumPeca.RAINHA)
                {
                    score = score + 9;
                }
                if(peca.getTipo() == EnumPeca.TORRE)
                {
                    score = score + 5;
                }   
            }
        }
        return score;
    }
    
    public int CalcularScorePreto() {
        int interador = 0;
        int score=0;
        Peca peca;
        while (interador < this.cemiterio.size()) {
            peca = cemiterio.get(interador);
            if(peca.getCor()==EnumCor.BRANCO)
            {
                if(peca.getTipo()== EnumPeca.BISPO)
                {
                    score = score + 3;
                }
                if(peca.getTipo()==EnumPeca.CAVALO)
                {
                    score = score + 3;
                }
                if(peca.getTipo() == EnumPeca.PEAO)
                {
                    score = score + 1;
                }
                if(peca.getTipo() == EnumPeca.RAINHA)
                {
                    score = score + 9;
                }
                if(peca.getTipo() == EnumPeca.TORRE)
                {
                    score = score + 5;
                }   
            }
        }
        return score;
    }

    public Tabuleiro(int linha, int coluna) {

        casas = new Casa[linha][coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                casas[i][j] = new Casa(GeradorCorCasa.INSTANCE.proximaCor());
            }
        }
        cemiterio = new ArrayList();
    }

    public Score CalcularScore() {
        return null;

    }

    public Casa getCasa(int linha, int coluna) {
        return this.casas[linha][coluna];
    }

    public void setCasa(Casa casa, int linha, int coluna) {
        this.casas[linha][coluna] = casa;
    }

    public void moverPeca(Posicao origem, Posicao destino) throws Exception {
        Peca peca;
        this.validaPosicao(origem);
        this.validaPosicao(destino);

        Casa casaOrigem = getCasa(origem.getLinha(), origem.getColuna());
        Casa casaDestino = getCasa(destino.getLinha(), destino.getColuna());

        if (!this.casaEstaVazia(origem)) {
            peca = casaOrigem.getPeca();

            if (peca.movimento(origem, destino, this)) {
                //System.out.println("Movimento Realizado!");

                casaDestino.setPeca(casaOrigem.removePeca());

            } else {
                throw new Exception("Movimento Nao pode ser Executado!");
            }
        } else {
            throw new Exception("A casa de origem esta vazia!");
        }
    }

    private void validaPosicao(Posicao posicao) throws Exception {

        if ((posicao.getLinha() <= 0 && posicao.getLinha() >= this.QUANTIDADELINHAS)
                && (posicao.getColuna() <= 0 && posicao.getColuna() >= this.QUANTIDADECOLUNAS)) {
            throw new Exception("Posicao Inserida Invalida!!.");
        }
    }

    public void capturarPeca(Posicao origem, Posicao destino) throws Exception {

        Peca peca;
        this.validaPosicao(origem);
        this.validaPosicao(destino);

        Casa casaOrigem = getCasa(origem.getLinha(), origem.getColuna());
        Casa casaDestino = getCasa(destino.getLinha(), destino.getColuna());

        if (!this.casaEstaVazia(origem)) {

            peca = casaOrigem.getPeca();
            if (!this.casaEstaVazia(destino)) {
                if (peca.captura(origem, destino, this)) {
                    System.out.println("Captura Realizada");

                    Peca descarte = casaDestino.removePeca();

                    this.cemiterio.add(descarte);

                    casaDestino.setPeca(casaOrigem.removePeca());

                }
            } else {
                if (peca.getTipo() == EnumPeca.PEAO) {
                    int linhaPassant, colunaPassant;
                    linhaPassant = origem.getLinha();
                    colunaPassant = destino.getColuna();
                    if (!this.casaEstaVazia(new Posicao(linhaPassant, colunaPassant))) {
                        Casa casaPassant = getCasa(linhaPassant, colunaPassant);
                        Peca pecaPassant = casaPassant.getPeca();
                        if (pecaPassant.getTipo() == EnumPeca.PEAO) {

                            this.cemiterio.add(casaPassant.removePeca());
                            peca = casaOrigem.removePeca();
                            casaDestino.setPeca(peca);
                        } else {
                            throw new Exception("En Passant Invalido!");
                        }
                    }
                }

            }

        } else {
            throw new Exception("A casa de origem esta vazia!");
        }
    }

    public boolean casaEstaVazia(Posicao posicao) {

        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        return (casas[linha][coluna].getPeca() == null);
    }

    public int quantidadeColunas() {
        return this.QUANTIDADECOLUNAS;
    }

    public int quantidadeLinhas() {
        return this.QUANTIDADELINHAS;
    }

}
