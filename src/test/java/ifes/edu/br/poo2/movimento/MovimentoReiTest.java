/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.movimento;

import ifes.edu.br.poo2.cdp.movimento.Movimento;
import ifes.edu.br.poo2.cdp.movimento.Posicao;
import ifes.edu.br.poo2.cdp.movimento.MovimentoRei;
import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.cdp.tabuleiro.TabuleiroDirector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class MovimentoReiTest {
    Tabuleiro tabuleiro;
    public MovimentoReiTest() {
        tabuleiro = new Tabuleiro();
        
        TabuleiroBuilder tabuleiroBuilder = new TabuleiroBuilder(tabuleiro);
        TabuleiroDirector tabuleiroDirector = new TabuleiroDirector();
        
        tabuleiro = tabuleiroDirector.build(tabuleiroBuilder);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicializando teste Rei...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Encerrando teste Rei...");
    }

    /**
     * Test of mover method, of class MovimentoRei.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
        MovimentoRei instance = new MovimentoRei();
        boolean expResult = true;
        boolean result = instance.mover(origem, destino);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAnalisaTrajetoSucesso() throws Exception {
        System.out.println("analizaTrajetoSucesso");
        Posicao origem = new Posicao(0,3);
        Posicao destino = new Posicao(1,4);
        
        this.tabuleiro.getCasa(1,4).setPeca(null);
        
        Movimento instance = new MovimentoRei();
        boolean expResult = true;
        boolean result = instance.analisaTrajeto(origem, destino, tabuleiro);
        assertEquals(expResult, result);
        
    }
    
    
}
