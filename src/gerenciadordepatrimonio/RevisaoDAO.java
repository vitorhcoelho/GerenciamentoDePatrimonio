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
public class RevisaoDAO {
    private Revisao [] revs = new Revisao[30];
    private int id = 0;
    Scanner in = new Scanner(System.in);
    
    public int geraId(){
        this.id++;
        return id;
    }
    
    public void criaRevisao(ItemDAO iDAO){
        Revisao rev = new Revisao();
        
        System.out.println("\nDigite o Ano Referente a Revisão: ");
        int aux = Integer.parseInt(in.nextLine());
        rev.setAno(aux);
        
        System.out.println("\nDigite o ID ");
        
        
    }
}
