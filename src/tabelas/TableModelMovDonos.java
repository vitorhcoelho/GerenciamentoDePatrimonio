/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import gerenciadordepatrimonio.MovimentoDono;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelMovDonos extends AbstractTableModel {

    private List<MovimentoDono> listaDeMovDonos;
    private final String[] colunas = {"ID", "ID do item", "Dono de origem", "Dono de destino", "Motivo", "Data de criação", "Data de modificação"};

    public TableModelMovDonos() {
        this.listaDeMovDonos = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public MovimentoDono get(int rowIndex) {
        return this.listaDeMovDonos.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void add(MovimentoDono serv) {
        this.listaDeMovDonos.add(serv);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param cidade
     */
    public void edita(MovimentoDono serv) {
        int position = 0;
        for (int i = 0; i < listaDeMovDonos.size(); i++) {
            MovimentoDono get = listaDeMovDonos.get(i);
            if (get.getId() == (serv.getId())) {
                position = i;
                break;
            }
        }
        this.listaDeMovDonos.set(position, serv);
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
        this.listaDeMovDonos.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeMovDonos.size();
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
                return this.listaDeMovDonos.get(rowIndex).getId();

            case 1:
                return this.listaDeMovDonos.get(rowIndex).getIdItem();

            case 2:
                return this.listaDeMovDonos.get(rowIndex).getDonoOrigem();

            case 3:
                return this.listaDeMovDonos.get(rowIndex).getDonoDestino();

            case 4:
                return this.listaDeMovDonos.get(rowIndex).getMotivo();

            case 5:
                return this.listaDeMovDonos.get(rowIndex).getDataCriacao();

            case 6:
                return this.listaDeMovDonos.get(rowIndex).getDataModificacao();

            default:
                return this.listaDeMovDonos.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
