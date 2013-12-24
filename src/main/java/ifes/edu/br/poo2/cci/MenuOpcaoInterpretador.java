/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cci;



import ifes.edu.br.poo2.cdp.jogador.Score;
import ifes.edu.br.poo2.cdp.partida.Partida;
import ifes.edu.br.poo2.cgt.PartidaControle;
import ifes.edu.br.poo2.cgt.ScoreControle;
import ifes.edu.br.poo2.cih.MenuView;

import java.util.Scanner;


/**
 *
 * @author tiago
 */
public class MenuOpcaoInterpretador {
    
    
    public void menuIncialInterpreter() throws Exception{
        int opcao=0;
        PartidaControle controlePartida;
        Partida partida;
        Score score;
        ScoreControle controleScore = new ScoreControle();
        Scanner in = new Scanner(System.in);
        MenuView menu = new MenuView();
        
        
        //opcao = in.nextInt();
        while (opcao!=4) // repeat until valid selection made
        {
                String nomeJogadorBranco, nomeJogadorPreto;
            
                menu.exibirMenuInicial();
                opcao = in.nextInt();
                switch (opcao) {
                    case 1:
                        menu.showMenuSecundario();
                        opcao = in.nextInt();
                        switch (opcao){
                            case 1:
                                controlePartida = new PartidaControle();
                                menu.nomeJogadorBranco();
                                nomeJogadorBranco = in.next();
                                menu.nomeJogadorPreto();
                                nomeJogadorPreto = in.next();
                                partida = controlePartida.iniciarPartidaAmigos(nomeJogadorBranco,nomeJogadorPreto);
                                score = controlePartida.playGame(partida);
                                controleScore.guardarScore(score);
                                break;
                            case 2:
                                System.out.println("Opcão ainda não ativada!\n");
                                /*
                                controlePartida = new PartidaControle();
                                menu.nomeJogadorBranco();
                                nomeJogadorBranco = in.next();
                                partida = controlePartida.iniciarPartidaSolo(nomeJogadorBranco);
                                score = controlePartida.playGame(partida);
                                controleScore.guardarScore(score);
                                        */
                                break;
                            
                            default:
                                menu.showOpcaoInvalida();
                                break;
                        }
                       
                        break;
                   
                        
                    case 2:
                        controleScore.consultarScores();
                        break;
                    case 3:
                        menu.saindo();
                        break;
                    default:
                        menu.showOpcaoInvalida();
                        break;
 
                }
                
        }
    }
      
}
