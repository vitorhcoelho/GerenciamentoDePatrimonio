/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

/**
 *
 * @author gusta
 */
public class MovimentoAmbienteDAO {
    private MovimentoAmbiente [] movAmb = new MovimentoAmbiente[100];
    private int id = 0;
    
    
    public int geraId(){
        this.id++;
        return id;
    }
    
     public int vagaMovAmb() {
        for (int x = 0; x < movAmb.length; x++) {
            if (movAmb[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setMovAmb(MovimentoAmbiente mov) {
        int pos = vagaMovAmb();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            movAmb[pos] = mov;
            return true;
        }
    }
    
    public void insereMovAmb(){
        
    }
}
