package DataObject.database.notations.relationship;

public @interface ManyToMany {
    String ref();
    String TableName()default "";
}
