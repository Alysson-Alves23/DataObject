package DataObject.database.utils;

import DataObject.database.notations.relationship.ManyToMany;
import DataObject.database.warnings.InvalidReferenceException;

import java.lang.reflect.Field;
import java.util.List;

public class RelationalMap {


    public static  Class<?> findRef(List<Class<?>> entities, String ref ) throws InvalidReferenceException {
        Class<?> res = null;
        for(Class<?> entity: entities){
            if(entity.getSimpleName().equals(ref)){
                res = entity;
                break;
            }
        }
        if(res == null){
            throw new InvalidReferenceException(ref);
        }
        return res;
    }

}
