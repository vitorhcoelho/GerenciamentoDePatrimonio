/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import gerenciadordepatrimonio.Revisao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelRevisao extends AbstractTableModel {

    private List<Revisao> listaDeRevisoes;
    private final String[] colunas = {"ID", "Ano", "ID do servidor", "ID do ambiente", "Estado", "Data de criação", "Data de modificação"};

    public TableModelRevisao() {
        this.listaDeRevisoes = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public Revisao get(int rowIndex) {
        return this.listaDeRevisoes.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(Revisao serv) {
        this.listaDeRevisoes.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(Revisao serv) {
        int position = 0;
        for (int i = 0; i < listaDeRevisoes.size(); i++) {
            Revisao get = listaDeRevisoes.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeRevisoes.set(position, serv);
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
        this.listaDeRevisoes.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeRevisoes.size();
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
                return this.listaDeRevisoes.get(rowIndex).getId();

            case 1:
                return this.listaDeRevisoes.get(rowIndex).getAno();

            case 2:
                return this.listaDeRevisoes.get(rowIndex).getIdServ();

            case 3:
                return this.listaDeRevisoes.get(rowIndex).getIdAmb();

            case 4:
                return this.listaDeRevisoes.get(rowIndex).getEstado();

            case 5:
                return this.listaDeRevisoes.get(rowIndex).getDataCriacao();

            case 6:
                return this.listaDeRevisoes.get(rowIndex).getDataModificacao();

            default:
                return this.listaDeRevisoes.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
