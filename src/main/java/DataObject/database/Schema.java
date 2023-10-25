package DataObject.database;
import DataObject.database.table.Table;
import java.util.ArrayList;
import java.util.List;

public class Schema {
    private List<Table> tables;

    public Schema() {
        this.tables = new ArrayList<>();
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public void removeTable(String tableName) {
        this.tables.removeIf(table -> table.getTableName().equals(tableName));
    }

    public Table getTable(String tableName){
        for(Table table : tables) {
            if(table.getTableName().equals(tableName)) {
                return table;
            }
        }
        return null; //Depois pode ser substituido por uma exceção
    }
    public void clearSchema() {
        this.tables.clear();

    }
    public List<Table> getAllTables() {
        return tables;
    }


}