/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.cdp.peca;

import java.lang.reflect.*;

/**
 *
 * @author tiago
 */
public class PecaPretaFactory extends PecaFactoryAbstract{

    
    public PecaPretaFactory() {
        this.manager = new PecaManager();
    }
    
    
    public Peca selectPeca(EnumPeca peca) {
        
        try{
            Class classe = manager.getClass();

            Method metodo = classe.getMethod("create"+peca.getNome(), EnumCor.class );

            return (Peca)metodo.invoke(this.manager, EnumCor.PRETO);
        
        }
        catch(Exception e){
            System.out.println("Erro no Reflection!!");
        }
        
        return null;
    }
    
}
