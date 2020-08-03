/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import gerenciadordepatrimonio.MovimentoAmbiente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelMovAmb extends AbstractTableModel {

    private List<MovimentoAmbiente> listaDeMovAmbs;
    private final String[] colunas = {"ID", "ID do item", "Ambiente de origem", "Ambiente de destino", "Motivo", "Data de criação", "Data de modificação"};

    public TableModelMovAmb() {
        this.listaDeMovAmbs = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public MovimentoAmbiente get(int rowIndex) {
        return this.listaDeMovAmbs.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(MovimentoAmbiente serv) {
        this.listaDeMovAmbs.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(MovimentoAmbiente serv) {
        int position = 0;
        for (int i = 0; i < listaDeMovAmbs.size(); i++) {
            MovimentoAmbiente get = listaDeMovAmbs.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeMovAmbs.set(position, serv);
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
        this.listaDeMovAmbs.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeMovAmbs.size();
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
                return this.listaDeMovAmbs.get(rowIndex).getId();

            case 1:
                return this.listaDeMovAmbs.get(rowIndex).getIdItem();

            case 2:
                return this.listaDeMovAmbs.get(rowIndex).getAmbienteOrigem();

            case 3:
                return this.listaDeMovAmbs.get(rowIndex).getAmbienteDestino();

            case 4:
                return this.listaDeMovAmbs.get(rowIndex).getMotivo();

            case 5:
                return this.listaDeMovAmbs.get(rowIndex).getDataCriacao();

            case 6:
                return this.listaDeMovAmbs.get(rowIndex).getDataModificacao();

            default:
                return this.listaDeMovAmbs.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
