package DataObject.database.notations;

import DataObject.database.datatype.Type;

import java.lang.annotation.*;
import java.sql.JDBCType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String name() default ""; // Column name in database
    Type type();
    int size() default 0;
    boolean primaryKey() default false; // If is primaryKey
    boolean notNull() default false; // its nullable value
    boolean uniqueIndex() default false; // No repeat in table
    boolean isBinaryColumn() default false; //If is Binary value
    boolean zeroFill() default false; // Fill with zero if this field is empty
    boolean autoIncrement() default false; // auto generate value
    boolean generatedColumn() default false; //



    //Relationships


}
