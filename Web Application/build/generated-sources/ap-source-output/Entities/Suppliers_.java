package Entities;

import Entities.Equipment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-16T14:34:52")
@StaticMetamodel(Suppliers.class)
public class Suppliers_ { 

    public static volatile SingularAttribute<Suppliers, Integer> suppliersId;
    public static volatile SingularAttribute<Suppliers, String> citySuppliers;
    public static volatile SingularAttribute<Suppliers, String> suppiersName;
    public static volatile SingularAttribute<Suppliers, String> countrySupplier;
    public static volatile ListAttribute<Suppliers, Equipment> equipmentList;

}