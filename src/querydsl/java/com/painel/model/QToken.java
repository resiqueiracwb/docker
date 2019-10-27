package com.painel.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QToken is a Querydsl query type for Token
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QToken extends EntityPathBase<Token> {

    private static final long serialVersionUID = -1144251920L;

    public static final QToken token1 = new QToken("token1");

    public final BooleanPath active = createBoolean("active");

    public final DateTimePath<java.util.Date> dtExpiracao = createDateTime("dtExpiracao", java.util.Date.class);

    public final DateTimePath<java.util.Date> dtInsercao = createDateTime("dtInsercao", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath token = createString("token");

    public QToken(String variable) {
        super(Token.class, forVariable(variable));
    }

    public QToken(Path<? extends Token> path) {
        super(path.getType(), path.getMetadata());
    }

    public QToken(PathMetadata metadata) {
        super(Token.class, metadata);
    }

}

