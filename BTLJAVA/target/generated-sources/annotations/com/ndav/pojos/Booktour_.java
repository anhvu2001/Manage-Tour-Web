package com.ndav.pojos;

import com.ndav.pojos.Tour;
import com.ndav.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(Booktour.class)
public class Booktour_ { 

    public static volatile SingularAttribute<Booktour, Integer> numberofadults;
    public static volatile SingularAttribute<Booktour, Tour> tourid;
    public static volatile SingularAttribute<Booktour, Long> id;
    public static volatile SingularAttribute<Booktour, Date> bookingdate;
    public static volatile SingularAttribute<Booktour, User> userid;
    public static volatile SingularAttribute<Booktour, Integer> numberofchildren;

}