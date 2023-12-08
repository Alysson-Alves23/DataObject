package DataObject.database.entities;

import DataObject.database.notations.Entity;
import DataObject.database.session.ConnectionFactory;
import DataObject.database.warnings.InvalidReferenceException;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EntityManager {

    public static String packageName;
    private final Schema schema;



    public EntityManager(Schema schema, String packageName) {
        this.schema = schema;
        EntityManager.packageName = packageName;
    }

    public static List<Class<?>> getEntities() {
        List<Class<?>> classesWithEntityAnnotation = new ArrayList<>();


        ConfigurationBuilder configuration = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(EntityManager.packageName ))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner());
        Reflections reflections = new Reflections(configuration);


        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);

        classesWithEntityAnnotation.addAll(entities);

        return classesWithEntityAnnotation;
    }

    public void load() {
        List<Class<?>> classesWithEntityAnnotation = getEntities();

        for (Class<?> c : classesWithEntityAnnotation) {
           Entity notation = c.getAnnotation(Entity.class);

           if(notation.type().equalsIgnoreCase("TABLE")){
               try {


                schema.createTable(c);

               }catch (InvalidReferenceException e){
                   System.out.println(e);
               }
           }
        }
    }
}
