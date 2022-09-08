package com.ndav.pojos;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.Comment;
import com.ndav.pojos.Image;
import com.ndav.pojos.Pricetour;
import com.ndav.pojos.Typetour;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, Date> daystart;
    public static volatile SetAttribute<Tour, Booktour> booktourSet;
    public static volatile SingularAttribute<Tour, Integer> numbersofday;
    public static volatile SetAttribute<Tour, Image> imageSet;
    public static volatile SetAttribute<Tour, Comment> commentSet;
    public static volatile SingularAttribute<Tour, String> iamge;
    public static volatile SingularAttribute<Tour, String> name;
    public static volatile SingularAttribute<Tour, Typetour> typeidId;
    public static volatile SingularAttribute<Tour, Long> id;
    public static volatile SetAttribute<Tour, Pricetour> pricetourSet;

}