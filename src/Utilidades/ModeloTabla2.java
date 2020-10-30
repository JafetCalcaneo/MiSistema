
package Utilidades;

import javax.swing.table.AbstractTableModel;


    public class ModeloTabla2 extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
    
}
