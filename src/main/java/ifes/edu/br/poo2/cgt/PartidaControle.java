/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.poo2.cgt;

import ifes.edu.br.poo2.cdp.jogador.AbstractJogadorFactory;
import ifes.edu.br.poo2.cdp.jogador.Jogador;
import ifes.edu.br.poo2.cdp.jogador.JogadorHumanoFactory;
import ifes.edu.br.poo2.cdp.jogador.JogadorIAFactory;
import ifes.edu.br.poo2.cdp.jogador.Score;
import ifes.edu.br.poo2.cdp.movimento.Posicao;
import ifes.edu.br.poo2.cdp.partida.Partida;
import ifes.edu.br.poo2.cdp.peca.EnumCor;
import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;
//import ifes.edu.br.poo2.xadrez.cgd.ControllerConnection;
import ifes.edu.br.poo2.cdp.movimento.MovimentosEspeciais;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.regex.*;

/**
 *
 * @author tiago
 */
public class PartidaControle {

    public Partida iniciarPartidaAmigos(String nomeJogadorBranco, String nomeJogadorPreto) {
        AbstractJogadorFactory factory = new JogadorHumanoFactory();
        Partida partida = new Partida();
        Jogador jogador = factory.createJogador(EnumCor.BRANCO);
        jogador.setNome(nomeJogadorBranco);
        partida.setJogadorBranco(jogador);
        jogador = factory.createJogador(EnumCor.PRETO);
        jogador.setNome(nomeJogadorPreto);
        partida.setJogadorPreto(jogador);

        return partida;

    }

    public Partida iniciarPartidaSolo(String nomeJogadorBranco) {
        AbstractJogadorFactory jogadorHumanoFactory = new JogadorHumanoFactory();
        AbstractJogadorFactory jogadorIAFactory = new JogadorIAFactory();
        Partida partida = new Partida();
        Jogador jogador = jogadorHumanoFactory.createJogador(EnumCor.BRANCO);
        jogador.setNome(nomeJogadorBranco);
        partida.setJogadorBranco(jogador);
        jogador = jogadorIAFactory.createJogador(EnumCor.PRETO);
        jogador.setNome("ZEUS");
        partida.setJogadorPreto(jogador);

        return partida;
    }

    public boolean VerificarEntrada(String jogada) {
        int teste;
        try {
            teste = Integer.parseInt(jogada);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String[] ConverteEntrada(String entrada) {
        String[] valorconvertido;
        valorconvertido = entrada.split("");
        return valorconvertido;
    }

    public Score playGame(Partida partida) throws Exception {
        boolean chequeBranco = false;
        boolean chequePreto = false;
        boolean movimentocorreto = true;

        Tabuleiro tabuleiro;
        tabuleiro = partida.getTabuleiro();
        Jogador jogadorBranco = partida.getJogadorBranco();
        Jogador jogadorPreto = partida.getJogadorPreto();
        Scanner in = new Scanner(System.in);
        String jogada;
        String[] jogadaValor;
        Posicao posSaida = new Posicao();
        Posicao posEntrada = new Posicao();
        int PosInicialLinha;
        int PosInicialColuna;
        int PosFinalLinha;
        int PosFinalColuna;
        int PosLinha;
        int PosColuna;
        Score ScorePartida = new Score(jogadorBranco, jogadorPreto);
//        Score ScorejogadorBranco = new Score(jogadorBranco,0);
//        Score ScorejogadorPreto = new Score(jogadorPreto,0);

        MovimentosEspeciais MovimentoEspecial = new MovimentosEspeciais();

        while ((!chequeBranco) || (!chequePreto)) {
            movimentocorreto = true;
            while (movimentocorreto) {
                try {
                    System.out.println("Jogada branco /n");
                    jogada = in.nextLine();

                    if (VerificarEntrada(jogada)) {
                        jogadaValor = jogada.split("");

                        PosInicialLinha = Integer.parseInt(jogadaValor[1]);
                        PosInicialColuna = Integer.parseInt(jogadaValor[2]);
                        PosFinalLinha = Integer.parseInt(jogadaValor[3]);
                        PosFinalColuna = Integer.parseInt(jogadaValor[4]);

                        posSaida.setPosicao(PosInicialLinha, PosInicialColuna);
                        posEntrada.setPosicao(PosFinalLinha, PosFinalColuna);

                        tabuleiro.moverPeca(posSaida, posEntrada);

                        if (MovimentoEspecial.VerificarChequeBranco(tabuleiro)) {

                        }
                    } else {
                        jogadaValor = ConverteEntrada(jogada);
                        if (jogada == "O-O-O") {
                            tabuleiro = MovimentoEspecial.RoqueGrandeBranco(tabuleiro);
                        }
                        if (jogada == "O-O") {
                            tabuleiro = MovimentoEspecial.RoquePequenoBranco(tabuleiro);
                        }
                        if (jogadaValor[4] == "=") {

                            PosLinha = Integer.parseInt(jogadaValor[1]);
                            PosColuna = Integer.parseInt(jogadaValor[2]);
                            if (PosLinha == 8) {
                                posSaida.setPosicao(PosLinha, PosColuna);
                                tabuleiro = MovimentoEspecial.PromoverPeca(posSaida, tabuleiro);
                            }
                              else
                            {
                                movimentocorreto = true;
                            }

                        } else {
                            jogada = jogada.replace("X", "");

                            jogadaValor = jogada.split("");
                            PosInicialLinha = Integer.parseInt(jogadaValor[1]);
                            PosInicialColuna = Integer.parseInt(jogadaValor[2]);
                            PosFinalLinha = Integer.parseInt(jogadaValor[3]);
                            PosFinalColuna = Integer.parseInt(jogadaValor[4]);

                            posSaida.setPosicao(PosInicialLinha, PosInicialColuna);
                            posEntrada.setPosicao(PosFinalLinha, PosFinalColuna);

                            tabuleiro.capturarPeca(posSaida, posEntrada);
                            if (MovimentoEspecial.VerificarChequeBranco(tabuleiro)) {
                                //ScorejogadorBranco.setPontosBranco(tabuleiro.CalcularScoreBranco());
                                ScorePartida.setPontosBranco(tabuleiro.CalcularScoreBranco());
                                ScorePartida.setPontosPreto(tabuleiro.CalcularScorePreto());
                                return ScorePartida;
                            }

                        }
                    }
                    movimentocorreto = false;
                } catch (Exception e) {
                    movimentocorreto = true;
                }
            }
            movimentocorreto = true;
            while (movimentocorreto) {
                try {
                    System.out.println("Jogada preto /n");
                    jogada = in.nextLine();

                    if (VerificarEntrada(jogada)) {
                        jogadaValor = jogada.split("");

                        PosInicialLinha = Integer.parseInt(jogadaValor[1]);
                        PosInicialColuna = Integer.parseInt(jogadaValor[2]);
                        PosFinalLinha = Integer.parseInt(jogadaValor[3]);
                        PosFinalColuna = Integer.parseInt(jogadaValor[4]);

                        posSaida.setPosicao(PosInicialLinha, PosInicialColuna);
                        posEntrada.setPosicao(PosFinalLinha, PosFinalColuna);

                        tabuleiro.moverPeca(posSaida, posEntrada);

                        if (MovimentoEspecial.VerificarChequePreto(tabuleiro)) {
                            return null;
                        }
                    } else {
                        jogadaValor = ConverteEntrada(jogada);
                        if (jogada == "O-O-O") {
                            tabuleiro = MovimentoEspecial.RoqueGrandePreto(tabuleiro);
                        }
                        if (jogada == "O-O") {
                            tabuleiro = MovimentoEspecial.RoquePequenoPreto(tabuleiro);
                        }
                        if (jogadaValor[4] == "=") {

                            PosLinha = Integer.parseInt(jogadaValor[1]);
                            PosColuna = Integer.parseInt(jogadaValor[2]);
                            if (PosLinha == 8) {
                                posSaida.setPosicao(PosLinha, PosColuna);
                                tabuleiro = MovimentoEspecial.PromoverPeca(posSaida, tabuleiro);
                            }
                            else
                            {
                                movimentocorreto = true;
                            }

                        }  else {
                            jogada = jogada.replace("X", "");

                            jogadaValor = jogada.split("");
                            PosInicialLinha = Integer.parseInt(jogadaValor[1]);
                            PosInicialColuna = Integer.parseInt(jogadaValor[2]);
                            PosFinalLinha = Integer.parseInt(jogadaValor[3]);
                            PosFinalColuna = Integer.parseInt(jogadaValor[4]);

                            posSaida.setPosicao(PosInicialLinha, PosInicialColuna);
                            posEntrada.setPosicao(PosFinalLinha, PosFinalColuna);

                            tabuleiro.capturarPeca(posSaida, posEntrada);
                            if (MovimentoEspecial.VerificarChequePreto(tabuleiro)) {
                                ScorePartida.setPontosBranco(tabuleiro.CalcularScoreBranco());
                                ScorePartida.setPontosPreto(tabuleiro.CalcularScorePreto());

                                return ScorePartida;
                            }

                        }
                    }
                    movimentocorreto = false;
                } catch (Exception e1) {
                    movimentocorreto = true;
                }
            }
        }
        return null;
    }

}
