/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import gerenciadordepatrimonio.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelItens extends AbstractTableModel {

    private List<Item> listaDeItens;
    private final String[] colunas = {"ID", "Especificação", "Código", "Estado", "Data de compra", "Valor de compra", "ID do dono", "ID do ambiente", "Data de criação", "Data de modificação"};

    public TableModelItens() {
        this.listaDeItens = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public Item get(int rowIndex) {
        return this.listaDeItens.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(Item serv) {
        this.listaDeItens.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(Item serv) {
        int position = 0;
        for (int i = 0; i < listaDeItens.size(); i++) {
            Item get = listaDeItens.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeItens.set(position, serv);
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
        this.listaDeItens.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeItens.size();
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
                return this.listaDeItens.get(rowIndex).getId();

            case 1:
                return this.listaDeItens.get(rowIndex).getEspecificacao();

            case 2:
                return this.listaDeItens.get(rowIndex).getCodigo();

            case 3:
                return this.listaDeItens.get(rowIndex).getEstado();

            case 4:
                return this.listaDeItens.get(rowIndex).getDatacompra();

            case 5:
                return this.listaDeItens.get(rowIndex).getValorcompra();

            case 6:
                return this.listaDeItens.get(rowIndex).getIdDono();

            case 7:
                return this.listaDeItens.get(rowIndex).getAmbienteId();

            case 8:
                return this.listaDeItens.get(rowIndex).getDatacriacao();

            case 9:
                return this.listaDeItens.get(rowIndex).getDatamodificacao();

            default:
                return this.listaDeItens.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
