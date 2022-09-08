package com.ndav.pojos;

import com.ndav.pojos.Commentnews;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T23:50:08")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, String> image;
    public static volatile SingularAttribute<News, String> name;
    public static volatile SetAttribute<News, Commentnews> commentnewsSet;
    public static volatile SingularAttribute<News, Long> id;
    public static volatile SingularAttribute<News, String> describe;
    public static volatile SingularAttribute<News, String> title;

}