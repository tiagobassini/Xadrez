/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.poo2.cgd;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author daniel
 */
public class ControllerConnection {

    private Connection c;

    public Connection OpenConnection() {
        c = null;
        //Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "admin");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            return c;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
        //System.out.println("Operation done successfully"); 
    }

    public void GuardarPontuacao(String nomeBranco, String nomePreto, int pontuacaoBranco, int pontuacaoPreto) {
        
        Statement stmt = null;
        try {
            System.out.println("Opened database successfully");
           
            stmt = c.createStatement();
            String sql = "INSERT INTO TRABPOO2 (jogador1,jogador2,score_jogador1,score_jogador2) "
                    + "VALUES ('" + nomeBranco + "','"+nomePreto+"'," + pontuacaoBranco + ","+pontuacaoPreto+");";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public ResultSet MostrarHistorico() {
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TRABPOO2 order by id_partida;");
            while (rs.next()) {
                String jogadorbranco = rs.getString("jogador1");
                String jogadorpreto = rs.getString("jogador1");
                int scorebranco = rs.getInt("score_jogador1");
                int scorepreto = rs.getInt("score_jogador2");

                System.out.print("Nome jogador branco =" + jogadorbranco
                                 +"\tScore jogador branco = " + scorebranco+"\n");
                System.out.print("Nome jogador preto =" + jogadorpreto
                                 +"\tScore jogador preto = " + scorepreto+"\n");
                

            }
            return rs;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
}
