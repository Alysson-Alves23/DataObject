package DataObject.database.entities.table;



import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ViewTable<T> extends AbstractTable<T> {

    List<T> elements;

    public ViewTable() {
        super();
        this.elements = elements;
        List<Integer> elementos;
        ViewTable<Integer> list;


    }


    @Override
    public void insert(Connection con, T element) {
        elements.add(element);
     //   System.out.println(teste.intValue());
    }

    @Override
    public void insert(T element) {

    }

    @Override
    public void update() {

    }

    @Override
    public void drop() {

    }

    @Override
    public void delete() {

    }
}
