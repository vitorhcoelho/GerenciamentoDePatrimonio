/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class AmbienteDAO {

    private Ambiente[] ambs = new Ambiente[100];
    private int qtdAmb = 0;
    private int id = 0;
    Scanner in = new Scanner(System.in);
    
    public void insereAmbiente(){
        
    }

    public int vagaAmbiente() {
        for (int x = 0; x < ambs.length; x++) {
            if (ambs[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setAmbiente(Ambiente amb) {
        int pos = vagaAmbiente();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            ambs[pos] = amb;
            this.qtdAmb++;
            return true;
        }
    }
}
