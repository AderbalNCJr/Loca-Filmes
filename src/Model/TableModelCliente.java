package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import miscellaneous.Database;

/**
 * @author Higor Alves
 */
public class TableModelCliente extends AbstractTableModel {
    private List<Cliente> clientes;
    private final String[] colunas = {"ID","Nome","Idade"};
    
    public TableModelCliente(List<Cliente> clientes){
        this.clientes = clientes;
    }
    
    public void updateTable(){
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return Database.getInstancia().getClientes().get(linha).getId();
            case 1:
                return Database.getInstancia().getClientes().get(linha).getNome();
            case 2:
                return Database.getInstancia().getClientes().get(linha).getIdade();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                Database.getInstancia().getClientes().get(linha).setId(Integer.parseInt((String)valor));
                break;
            case 1:
                Database.getInstancia().getClientes().get(linha).setNome((String)valor);
                break;
            case 2:
                Database.getInstancia().getClientes().get(linha).setIdade(Integer.parseInt((String)valor));
                break;
            default:  
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
}