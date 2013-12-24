/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.poo2.cih;

import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroDirector;
import ifes.edu.br.poo2.cgd.ControllerConnection;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class MenuView {

    public  void exibirMenuInicial() {
          
        System.out.println("MENU \n\t1) Iniciar Nova Partida\n\t"
                + "2) Dados das Partidas\n\t"
                + "3) Sair 3");
    }

    public void showOpcaoInvalida() {
        System.out.println("\nOpcao Invalida!!\n");
    }

    public void saindo() {
        System.out.println("Finalizando Programa...");
    }

    public void nomeJogadorBranco() {
        System.out.println("Insira o Nome do Jogador das Pecas Brancas: ");
    }

    public void nomeJogadorPreto() {
        System.out.println("Insira o Nome do Jogador das Pecas Pretas: ");
    }

    public void showMenuSecundario() {
        System.out.println("MENU \n\t1) Jogar Com um Amigo\n\t"
                + "2) Jogar Solo\n\t");
    }

}
