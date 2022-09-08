package com.ndav.pojos;

import com.ndav.pojos.Pricetour;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(Typecustomer.class)
public class Typecustomer_ { 

    public static volatile SingularAttribute<Typecustomer, String> name;
    public static volatile SingularAttribute<Typecustomer, Long> id;
    public static volatile SetAttribute<Typecustomer, Pricetour> pricetourSet;

}