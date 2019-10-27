package com.painel.enums;

public enum ErrorCode {
	USER_INVALID_EMAIL_OR_PASSWORD("1000", "Usuário ou senha inválida",	"Verifique se os dados de login estão corretos"),
	GENERIC("1500", "Ocorreu um erro interno", "Tente fazer a operação novamente em instantes"),
	SEM_DISPONIBILIDADE("2500", "Sem disponibilidade", "Contratada sem disponibilidade na data selecionada."),
	PREDIO_NOT_FOUND("2000" , "Prédio não encontrado", "Tente um outro ID"),
	ARQUIVO_NOT_FOUND("2002","Arquivo ou caminho não Encontrado","Arquivo ou caminho não Encontrado"),
	ESTEIRA_INICIAL_MAIOR("2003", "Esteira inicial maior", "Esteira inicial maior"),
	USUARIO_NOT_FOUND("2004", "Usuário não foi localizado", "Usuário não foi localizado"), 
	REPLICA_PREDIO("2005", "Não é possivel replicar esse prédio", "Não é possivel replicar esse prédio"),
	ERRO_SAVE_AGENDAMENTO("2006", "Não foi possivel salvar agendamento", "Não foi possivel salvar agendamento"),
	DOCUMENTO_NAO_ENCONTRADO("2007", "Documento não encontrado no repositório de documentos", "Não foi possivel recuperar o arquivo no repositório de documentos"),
	DOCUMENTO_NAO_ENCONTRADO_PRUMA("2008", "Documento não encontrado na base histórica do PRUMA", "Documento não encontrado na base histórica do PRUMA"),
	UPLOAD_REPLICA_PREDIO("2009", "Problema ao replicar arquivo no Repositório", "Problema ao replicar arquivo no Repositório"),
	CAMPO_INVALIDO("3000", "Campo inválido", "Não é possível prosseguir"), 
	ERRO_LER_ARQUIVO_LEGADO("2010", "Problema ao ler arquivo do disco Legado", "Não é possível ler Arquivo apartir do Legado"), 
	AGENDAMENTO_NOT_FOUND("2011", "Agendamento não encontrado", "Não foi possível recuperar o agendamento"), 
	VISTORIA_NOT_FOUND("2012", "Não foi encontrado vistoria para o Prédio", "Vistoria não encontrada"), 
	PROJETO_NOT_FOUND("2013", "Projeto não encontrado", "Não foi possível encontrar o Projeto"),
	OBRA_NOT_FOUND("2014", "Obra Externa não Encontrada", "Não encontrada Obra para esse Prédio"),
	CERTIFICACAO_NOT_FOUND("2015", "Certificação não encontrada", "Não Foi Possivel recuperar a Certificação"), 
	FORMAT_COD_MUNICPIO("2016", "Campo Codigo do Município está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais ", "Campo Codigo do Município está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais"), 
	FORMAT_UF("2017", "Campo UF está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais ", "Campo UF está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais "), 
	FORMAT_BAIRRO_MUNICPIO("2018" , "Campo Codigo do Bairro está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais" , "Campo Codigo do Bairro está com formato errado deve ser do tipo ***NUMERO*** na planilha , e não pode conter caracteres especiais");

	private String code;
	private String description;
	private String comments;

	private ErrorCode(String code, String description, String comments) {
		this.code = code;
		this.description = description;
		this.comments = comments;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	public String getComments() {
		return comments;
	}
}