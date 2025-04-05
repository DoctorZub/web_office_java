package Entities;

import Entities.Equipment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-16T14:34:52")
@StaticMetamodel(Responsibles.class)
public class Responsibles_ { 

    public static volatile SingularAttribute<Responsibles, String> departmentRespons;
    public static volatile SingularAttribute<Responsibles, String> lastName;
    public static volatile SingularAttribute<Responsibles, String> firstName;
    public static volatile SingularAttribute<Responsibles, String> post;
    public static volatile SingularAttribute<Responsibles, String> countryRespons;
    public static volatile SingularAttribute<Responsibles, Integer> responsiblesId;
    public static volatile SingularAttribute<Responsibles, String> middleName;
    public static volatile SingularAttribute<Responsibles, String> cityRespons;
    public static volatile ListAttribute<Responsibles, Equipment> equipmentList;

}