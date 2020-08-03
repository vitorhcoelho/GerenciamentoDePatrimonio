/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import gerenciadordepatrimonio.Ambiente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelAmbientes extends AbstractTableModel {

    private List<Ambiente> listaDeAmbientes;
    private final String[] colunas = {"ID", "Descrição", "Campus pertencente", "Data de criação", "Data de alteração"};

    public TableModelAmbientes() {
        this.listaDeAmbientes = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public Ambiente get(int rowIndex) {
        return this.listaDeAmbientes.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(Ambiente serv) {
        this.listaDeAmbientes.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(Ambiente serv) {
        int position = 0;
        for (int i = 0; i < listaDeAmbientes.size(); i++) {
            Ambiente get = listaDeAmbientes.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeAmbientes.set(position, serv);
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
        this.listaDeAmbientes.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeAmbientes.size();
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
                return this.listaDeAmbientes.get(rowIndex).getId();

            case 1:
                return this.listaDeAmbientes.get(rowIndex).getDescricao();

            case 2:
                return this.listaDeAmbientes.get(rowIndex).getCodCamp();

            case 3:
                return this.listaDeAmbientes.get(rowIndex).getDatacriacao();

            case 4:
                return this.listaDeAmbientes.get(rowIndex).getDatamodificacao();

            default:
                return this.listaDeAmbientes.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
