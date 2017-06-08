package Entity;

import Entity.Grade;
import Entity.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T17:32:32")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Boolean> isMarried;
    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile ListAttribute<Person, Person> supervises;
    public static volatile SingularAttribute<Person, Grade> grade;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, Date> birthsday;
    public static volatile SingularAttribute<Person, Integer> age;
    public static volatile SingularAttribute<Person, Person> supervisor;
    public static volatile SingularAttribute<Person, String> lastname;

}