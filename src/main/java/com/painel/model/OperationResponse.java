
package com.painel.model;

import io.swagger.annotations.*;
import lombok.*;

/**
 * Essa é a estrutura para respostas caso a requisição tenha uma lista como
 * resposta retorna, items caso contrário retorna item
 */
@Data
public class OperationResponse {
    public enum ResponseStatusEnum {
        SUCCESS, ERROR, WARNING, NO_ACCESS
    }

    ;

    @ApiModelProperty(required = true)
    private ResponseStatusEnum operationStatus;
    private String operationMessage;
}
