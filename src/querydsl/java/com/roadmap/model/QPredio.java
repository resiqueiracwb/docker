package com.roadmap.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPredio is a Querydsl query type for Predio
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPredio extends EntityPathBase<Predio> {

    private static final long serialVersionUID = -473845173L;

    public static final QPredio predio = new QPredio("predio");

    public final StringPath cor = createString("cor");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isPortaria = createBoolean("isPortaria");

    public final BooleanPath isSalaoFestas = createBoolean("isSalaoFestas");

    public final StringPath name = createString("name");

    public final StringPath nomeSindico = createString("nomeSindico");

    public final NumberPath<Integer> qtdeAndares = createNumber("qtdeAndares", Integer.class);

    public final NumberPath<Integer> qtdeApartamentos = createNumber("qtdeApartamentos", Integer.class);

    public final NumberPath<Integer> qtdeElevadores = createNumber("qtdeElevadores", Integer.class);

    public final StringPath tipoPadrao = createString("tipoPadrao");

    public final BooleanPath vagasCobertas = createBoolean("vagasCobertas");

    public QPredio(String variable) {
        super(Predio.class, forVariable(variable));
    }

    public QPredio(Path<? extends Predio> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPredio(PathMetadata metadata) {
        super(Predio.class, metadata);
    }

}

