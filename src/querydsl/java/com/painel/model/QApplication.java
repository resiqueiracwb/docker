package com.painel.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApplication is a Querydsl query type for Application
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplication extends EntityPathBase<Application> {

    private static final long serialVersionUID = 272191495L;

    public static final QApplication application = new QApplication("application");

    public final StringPath emailResponsavel = createString("emailResponsavel");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nomeResponsavel = createString("nomeResponsavel");

    public QApplication(String variable) {
        super(Application.class, forVariable(variable));
    }

    public QApplication(Path<? extends Application> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApplication(PathMetadata metadata) {
        super(Application.class, metadata);
    }

}

