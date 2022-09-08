package com.ndav.pojos;

import com.ndav.pojos.Tour;
import com.ndav.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> createddate;
    public static volatile SingularAttribute<Comment, Tour> tourid;
    public static volatile SingularAttribute<Comment, Long> id;
    public static volatile SingularAttribute<Comment, User> userid;
    public static volatile SingularAttribute<Comment, String> content;

}