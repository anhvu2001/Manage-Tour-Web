package com.ndav.pojos;

import com.ndav.pojos.Booktour;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(Pay.class)
public class Pay_ { 

    public static volatile SingularAttribute<Pay, Long> id;
    public static volatile SingularAttribute<Pay, Integer> totalmoney;
    public static volatile SingularAttribute<Pay, Booktour> idbooking;

}