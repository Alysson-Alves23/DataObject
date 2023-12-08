package DataObject.database.entities.table;



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
    public void insert(T element) {

    }

    @Override
    public void update(T element) {

    }

    @Override
    public void drop() {

    }

    @Override
    public T select(String field, Long value) {

        return null;
    }

    @Override
    public T select(String field, String value) {

        return null;
    }

    @Override
    public T select(String field, Double value) {

        return null;
    }

    @Override
    public void delete(String where) {

    }
}
