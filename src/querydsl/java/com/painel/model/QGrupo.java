package com.painel.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrupo is a Querydsl query type for Grupo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGrupo extends EntityPathBase<Grupo> {

    private static final long serialVersionUID = -1156158368L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGrupo grupo = new QGrupo("grupo");

    public final StringPath chave = createString("chave");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final QUsuario usuario;

    public QGrupo(String variable) {
        this(Grupo.class, forVariable(variable), INITS);
    }

    public QGrupo(Path<? extends Grupo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGrupo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGrupo(PathMetadata metadata, PathInits inits) {
        this(Grupo.class, metadata, inits);
    }

    public QGrupo(Class<? extends Grupo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usuario = inits.isInitialized("usuario") ? new QUsuario(forProperty("usuario"), inits.get("usuario")) : null;
    }

}

