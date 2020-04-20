/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author Vitor Hugo
 */
public class Main {
    
    public void start() {
        ServidorDAO servDAO = new ServidorDAO();
        CampusDAO campDAO = new CampusDAO();
        AmbienteDAO ambDAO = new AmbienteDAO();
        ItemDAO iDAO = new ItemDAO();

        FazTudo inicia = new FazTudo();
        inicia.login(servDAO, campDAO, ambDAO, iDAO);
    }
    public static void main(String[] args) {
        Main boost = new Main();
        boost.start();
    }
    
}
