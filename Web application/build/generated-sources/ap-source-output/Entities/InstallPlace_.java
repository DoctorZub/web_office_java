package Entities;

import Entities.Equipment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-02-23T15:26:28")
@StaticMetamodel(InstallPlace.class)
public class InstallPlace_ { 

    public static volatile SingularAttribute<InstallPlace, Short> peopleNumber;
    public static volatile SingularAttribute<InstallPlace, String> cabinetNumber;
    public static volatile SingularAttribute<InstallPlace, Integer> placeId;
    public static volatile ListAttribute<InstallPlace, Equipment> equipmentList;
    public static volatile SingularAttribute<InstallPlace, String> departmentPlace;

}