/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cgt;

import ifes.edu.br.poo2.cdp.jogador.Score;
import ifes.edu.br.poo2.cgd.ControllerConnection;

/**
 *
 * @author tiago
 */
public class ScoreControle {
    ControllerConnection controle;
    
    public ScoreControle(){
        controle = new ControllerConnection();
        controle.OpenConnection();
    }
           
            
    public void consultarScores() {
        controle.MostrarHistorico();
    }

    public void guardarScore(Score score) {
        //controle.GuardarPontuacao(score.getNomeJogadorBranco(), score.getPontosBranco());
        controle.GuardarPontuacao(score.getNomeJogadorBranco(), score.getNomeJogadorPreto(), score.getPontosBranco(), score.getPontosPreto());
    }
    
}
