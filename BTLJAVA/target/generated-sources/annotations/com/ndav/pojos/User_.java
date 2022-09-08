package com.ndav.pojos;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.Comment;
import com.ndav.pojos.Commentnews;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SetAttribute<User, Booktour> booktourSet;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Comment> commentSet;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SetAttribute<User, Commentnews> commentnewsSet;
    public static volatile SingularAttribute<User, Boolean> isActive;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}