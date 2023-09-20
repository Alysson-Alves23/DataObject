package DataObject.database.column;

import DataObject.database.datatype.Type;

public class Column{
    private String name;
    private String type;
    private boolean primaryKey;
    private boolean notNull;
    private boolean uniqueIndex;
    private boolean isBinaryColumn;
    private boolean zeroFill;
    private boolean autoIncrement;
    private boolean generatedColumn;

    public Column (String name, String type){
        this.name = name;
        this.type = type;

    }
    public Column(String name, String type, boolean primaryKey, boolean notNull, boolean uniqueIndex, boolean isBinaryColumn, boolean zeroFill, boolean autoIncrement) {
        this.name = name;
        this.type = type;
        this.primaryKey = primaryKey;
        this.notNull = notNull;
        this.uniqueIndex = uniqueIndex;
        this.isBinaryColumn = isBinaryColumn;
        this.zeroFill = zeroFill;
        this.autoIncrement = autoIncrement;
    }
    public  Column(String name, Type type){

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isUniqueIndex() {
        return uniqueIndex;
    }

    public void setUniqueIndex(boolean uniqueIndex) {
        this.uniqueIndex = uniqueIndex;
    }

    public boolean isBinaryColumn() {
        return isBinaryColumn;
    }

    public void setBinaryColumn(boolean binaryColumn) {
        isBinaryColumn = binaryColumn;
    }

    public boolean isZeroFill() {
        return zeroFill;
    }

    public void setZeroFill(boolean zeroFill) {
        this.zeroFill = zeroFill;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public boolean isGeneratedColumn() {
        return generatedColumn;
    }

    public void setGeneratedColumn(boolean generatedColumn) {
        this.generatedColumn = generatedColumn;
    }


}
