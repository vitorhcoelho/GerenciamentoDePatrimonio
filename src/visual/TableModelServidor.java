/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import gerenciadordepatrimonio.Servidor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelServidor extends AbstractTableModel {

    private List<Servidor> listaDeServidores;
    private final String[] colunas = {"ID", "Nome", "E-mail", "Campus", "Cargo", "Papel", "Administrador"};

    public TableModelServidor() {
        this.listaDeServidores = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public Servidor get(int rowIndex) {
        return this.listaDeServidores.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(Servidor serv) {
        this.listaDeServidores.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(Servidor serv) {
        int position = 0;
        for (int i = 0; i < listaDeServidores.size(); i++) {
            Servidor get = listaDeServidores.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeServidores.set(position, serv);
        /*
        Iterator<Cidade> it = this.listaDeCidades.iterator();
        while (it.hasNext()) {
            Cidade next = it.next();
            if (next.getCodigo().equals(cidade.getco))
            
        }*/

        fireTableDataChanged();
    }

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.listaDeServidores.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeServidores.size();
    }

    /**
     * Retorna o numero de colunas da tabela
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o valor especifico de uma celula
     *
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //switch na coluna
        switch (columnIndex) {

            case 0:
                return this.listaDeServidores.get(rowIndex).getId();

            case 1:
                return this.listaDeServidores.get(rowIndex).getNome();

            case 2:
                return this.listaDeServidores.get(rowIndex).getEmail();

            case 3:
                return this.listaDeServidores.get(rowIndex).getCampus();

            case 4:
                return this.listaDeServidores.get(rowIndex).getCargo();

            case 5:
                return this.listaDeServidores.get(rowIndex).getPapel();

            case 6:
                return this.listaDeServidores.get(rowIndex).isAdm();

            default:
                return this.listaDeServidores.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
