package ifes.edu.br.poo2.cih;


import ifes.edu.br.poo2.cdp.movimento.Posicao;
import ifes.edu.br.poo2.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public class TabuleiroView {
    

    public static void exibirTabuleiro(Tabuleiro tabuleiro){
        
        for(int i=0;i<tabuleiro.quantidadeColunas();i++)
            System.out.print("\t"+(i+1)+"\t|");
        System.out.println();
        
        for(int i=0;i<tabuleiro.quantidadeColunas();i++)
            System.out.print("________________");
        
        System.out.println();
        for(int i=0;i<tabuleiro.quantidadeLinhas(); i++){
            //System.out.println();
            System.out.print((i+1)+" |");
            for(int j=0;j<tabuleiro.quantidadeColunas();j++){
                if(tabuleiro.casaEstaVazia(new Posicao(i,j))){
                    
                    System.out.print("\t\t|");
                }
                else{
                    System.out.print(" "+tabuleiro.getCasa(i, j).getPeca().getNome()+"\t|");
                }
                
            }
            System.out.println();
            for(int k=0;k<tabuleiro.quantidadeColunas();k++)
                System.out.print("________________");
            System.out.println();
        }
        //for(int i=0;i<tabuleiro.quantidadeColunas();i++)
        //    System.out.print("________________");
        
        System.out.println();
    }
   
}
