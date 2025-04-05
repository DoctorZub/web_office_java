package Entities;

import Entities.InstallPlace;
import Entities.Responsibles;
import Entities.Suppliers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-16T14:34:52")
@StaticMetamodel(Equipment.class)
public class Equipment_ { 

    public static volatile SingularAttribute<Equipment, String> inventoryNumber;
    public static volatile SingularAttribute<Equipment, String> equipName;
    public static volatile SingularAttribute<Equipment, Float> price;
    public static volatile SingularAttribute<Equipment, InstallPlace> installPlace;
    public static volatile SingularAttribute<Equipment, Responsibles> responsible;
    public static volatile SingularAttribute<Equipment, Suppliers> supplier;
    public static volatile SingularAttribute<Equipment, Date> nextCheck;
    public static volatile SingularAttribute<Equipment, Short> productionYear;
    public static volatile SingularAttribute<Equipment, Integer> equipmentId;
    public static volatile SingularAttribute<Equipment, String> capacity;
    public static volatile SingularAttribute<Equipment, Date> laskCheck;

}