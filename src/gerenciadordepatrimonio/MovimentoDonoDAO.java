/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordepatrimonio;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class MovimentoDonoDAO {

    private MovimentoDono[] movDono = new MovimentoDono[221];
    private int qtdMovDono;
    private int id = 0;
    Scanner in = new Scanner(System.in);

    public int geraId() {
        this.id++;
        return id;
    }

    public void insereMov(Item i, Servidor s1, Servidor s2) {
        String dado;
        double valor;
        int x;
        MovimentoDono m = new MovimentoDono();

        System.out.println("\nID do item em movimento: ");
        x = Integer.parseInt(in.nextLine());
        if (x == i.getId()) {
            m.setItem(i);
        }

        System.out.println("\nO item esta sendo transferido do servidor de ID (origem): ");
        x = Integer.parseInt(in.nextLine());
        if (x == s1.getId()) {
            s1.toString();
            System.out.println("\nPara o servidor (destino): ");
            x = Integer.parseInt(in.nextLine());
            if (x == s2.getId()) {
                s2.toString();
                
                m.setDonoOrigem(s1);
                m.setDonoDestino(s2);
            } else {
                System.out.println("\nServidor nao encontrado!");
            }
        } else {
            System.out.println("\nServidor nao encontrado!");
        }
        
        System.out.println("\nInforme o motivo da transferencia: ");
        dado = in.nextLine();
        m.setMotivo(dado);

        LocalDate hoje = LocalDate.now();
        m.setDataCriacao(hoje);

        m.setId(geraId());
        this.setMovDono(m);

        System.out.println(i.toString() + "\nMovimentacao realizada com sucesso!\n");
    }

    public int vagaMovDono() {
        for (int x = 0; x < movDono.length; x++) {
            if (movDono[x] == null) {
                return x;
            } else {

            }
        }
        return -1;
    }

    public boolean setMovDono(MovimentoDono movimentacoes) {
        int pos = vagaMovDono();
        if (pos == -1) {
            System.out.println("\nLista de Campus Cheia\n");
            return false;
        } else {
            movDono[pos] = movimentacoes;
            this.qtdMovDono++;
            return true;
        }
    }
}
