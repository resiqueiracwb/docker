/**
 * 
 */
package com.painel.util;


public abstract class SwaggerDocumentation {

	/**
	 * Documentação para @ApiResponses
	 */
	public static final String ESTEIRA_FILTRO = "****ATENÇÃO**** Retorna os Filtros padrões para a tela Inicial";
	public static final String ESTEIRA_PREDIOS_FILTRO_OP = "Retorna uma lista de filtros para a tela de Predios por esteira";
	public static final String ESTEIRA_LIST = "****ATENÇÃO**** Para retornar esteiras de Fibra o param rede = 0 para cobre rede = 1";
	public static final String ESTEIRA_LIST_BY_USER = "Retorna esteiras de acordo ao usuário logado";
	public static final String ESTEIRA_MUNICIPIOS = "Retorna o(s)municipios da(s) UF(s) selecionada(s)";
	public static final String ESTEIRA_PREDIOS = "Retorna Lista de predios da esteira selecionada. Recebendo o Id da esteira e o objeto de filtros *** (FIBRA) => filter.tipoBuscaEsteira == 0  || *** (COBRE) => filter.tipoBuscaEsteira*** == 1";
	public static final String PREDIOS_PAGINA_RESULTADOS = "Lista os Prédios na banco de dados com base nos filtros informados";
	public static final String LIST_MATERIAIS = "Retorna a lista de materiais disponíveis";
	public static final String LIST_MATERIAIS_BY_ESTEIRA = "Retorna Lista de materiais pela esteira selecionada";
	public static final String LIST_DTH_MATERIAIS = "Retorna Lista de Materiais DTH(TV)";
	public static final String SAVE = "salva lista de materiais Telecom";
	public static final String SAVE_DTH = "salva lista de materiais DTH(TV)";
	public static final String TIPO_PRIORIZACAO_PREDIO = "Tipo Priorização prédios";
	public static final String LIST_HISTORICO = "Lista de Histórico de replicações";
	public static final String LIST_MATERIAIS_BY_PREDIO = "Lista de Histórico de replicações por prédios";
	public static final String EMPRESA_LIST = "Lista de Empresas";
	public static final String CONTRATADA_LIST = "Lista de Empresas";
	public static final String LIST_PROSPECTOR = "Recupera lista de prospecção disponíveis";
	public static final String LIST_PROSPECTOR_BY_EMPRESA = "Lista os prospectores pela empresa";
	public static final String LIST_TIPO_PRIORIZACAO_PREDIO = "Lista tipo de priorizações disponiveis";
	public static final String DELETE_MOTIVO = "Deletando motivos suspensaão pelo ID solicitado";
	public static final String LIST_MOTIVO = "Lista dos Motivos Suspensão através da esteira solicitada";
	public static final String ENDERECO_LIST = "Lista de Endereços";
	public static final String SAVE_CEP = "salva novo Cep";
	public static final String SAVE_MUNICIPIO = "Salva novo Municipio";
	public static final String SAVE_BAIRRO = "salva novo Bairro";
	public static final String SEND_EMAIL = "Envio de email para reset de senha";
	public static final String ATUALIZA_SENHA = "Atualiza senha quando utilizado servico esqueci minha senha";
	public static final String LIST_USER_BY_EMAIL = "Busca usuário(s) por nome ou email";
	public static final String LIST_USER = "Busca a Lista de todos os usuários";
	public static final String SAVE_USER = "Salva novo usuário";
	public static final String DELETE_USER = "Deleta usuário";
	public static final String PREDIO_DETALHE = "Carrega os combos para detalhes dos predios";
	public static final String LIST_USER_BY_ID = "Busca usuário";
	public static final String GET_GROUPS = "Busca todos grupos disponíveis";
	public static final String ENDERECO_LISTMUNICIPIOBYUF = "Busca lista de municípios cadastrados de acordo com UF selecionada";
	public static final String ENDERECO_LISTBAIRROBYMUNICIPIO = "Busca lista de bairros cadastrados de acordo com Municipio selecionado";
	public static final String ENDERECO_LIST_BY_CEP = "Busca lista de bairros cadastrados de acordo com cep informado";
	public static final String LIST_PREDIOREP_BYID = "Busca todas replicações de prédios pelo ID informado";
	public static final String REPLICA_PREDIO = "Replica o prédio pelo ID";
	public static final String AJUSTE_CONTRATA_LIST = "Retorna Lista com histórico de ajustes de contrata por esteira. \n Recebendo o Id do prédio.";
	public static final String PREDIO_LOAD_COMBO = "Carrega os combos esteira, contratada e contratada gestão para ajuste de contratada";
	public static final String SAVE_AJUSTE_CONTRATADA = "Salva ajuste de contratada por esteira";
	public static final String RECUSA_DRAFT = "Recusa draft para obra externa";
	public static final String APROVA_DRAFT = "Aprova draft para obra externa";
	public static final String OBRA_EXTERNA = "Aba ***OBRA EXTERNA*** do predio";
	public static final String RETROAGIR_PREDIOS = "Retroagir Predios";
	public static final String PROJETO_COMBOS = "Carrega os combos para a tela de projeto ***ABA PROJETO*** " ;
	public static final String LIBERA_PROJETO_EXTERNA = "Aba Projeto depois que passa a etapa de Vistoria - ***LIBERACAO DE PROJETO***";
	public static final String FINALIZA_AGENDAMENTO_VISTORIA = "Aba VISTORIA ao clicar no botão ***FINALIZAR***";
	public static final String REALIZA_AGENDAMENTO_VISTORIA = "Salva um novo agendamento de vistoria - ***ABA - VISTORIA*** ";
	public static final String HISTORICO_PREDIO = "Aba ***HISTORICO*** do predio";
	public static final String ASSOCIAR_PREDIOS = "Associar Prédios";
	public static final String DESASSOCIAR_PREDIOS = "Desassociar Predios";
	public static final String ATUALIZAR_SATURADOS = "Atualizar saturados Predios";
	public static final String GERENCIAR_PREDIO = "Gerenciamento de prédios";
	public static final String GET_TOKEN_UPLOAD = "Gerar token de upload";
	public static final String GET_TOKEN_DOWNLOAD = "Gerar token de download";
	public static final String DEFINIR_OU_REMOVER_PRIORIDADE_IMPLANTACAO = "Atualizar condomínio para ter ou não prioridade de implantação";


	/**
	 * Documentação para @ApiOperation
	 */

	public static final String LIST_MATERIAIS_OP = "Retorna a lista de materiais disponíveis";
	public static final String ESTEIRA_BY_USER = "Retorna a lista de Esteira por usuário logado";
	public static final String ESTEIRA_FILTRO_OP = "Retorna uma lista de filtros para a tela de Esteira";
	public static final String ESTEIRA_LIST_OP = "Lista todas as esteiras de prédios  ***FIBRA***  E ***COBRE***";
	public static final String ESTEIRA_MUNICIPIOS_OP = "Lista de ***Municipios*** pelas UFs ";
	public static final String ESTEIRA_PREDIOS_OP = "Lista de Predios da Esteira ***FIBRA*** e ***COBRE***";
	public static final String LIST_MATERIAIS_BY_ESTEIRA_OP = "Lista Materiais pelo código da esteira selecionada";
	public static final String LIST_DTH_MATERIAIS_OP = "Lsita de Materiais DTH";
	public static final String SAVE_OP = "salva lista de materiais Telecom";
	public static final String SAVE_DTH_OP = "salva lista de materiais DTH(TV)";
	public static final String TIPO_PRIORIZACAO_PREDIO_OP = "salva priorizacão prédios";
	public static final String LIST_HISTORICO_OP = "Lista histórico de replicações";
	public static final String LIST_HISTORICO_BY_PREDIO_OP = "Lista histórico de replicações por prédios";
	public static final String EMPRESA_LIST_OP = "Busca de lisata de empresa cadastrada para a tela de cadastro de Prospector";
	public static final String CONTRATADA_LIST_OP = "Busca de lisata de contratadas";
	public static final String LIST_PROSPECTOR_OP = "Busca a Lista de Prospecções";
	public static final String LIST_PROSPECTOR_BY_EMPRESA_OP = "Lista pela empresas";
	public static final String LIST_TIPO_PRIORIZACAO_PREDIO_OP = "lista tipo de priorizacões";
	public static final String DELETE_MOTIVO_OP = "Delete motivos suspensão";
	public static final String LIST_MOTIVO_OP = "Lista motivos suspensão";
	public static final String ESTEIRA_LIST_BY_USER_OP = "Busca Esteiras por usuário";
	public static final String ENDERECO_LIST_OP = "Busca de lista de endereços cadastrados para a tela de Endereços e Cadastro de Cep";
	public static final String SAVE_CEP_OP = "salva novo Cep";
	public static final String SAVE_MUNICIPIO_OP = "Salva novo Municipio";
	public static final String SAVE_BAIRRO_OP = "salva novo Bairro";
	public static final String SEND_EMAIL_OP = "Enviar email quando clicado em esqueci minha senha";
	public static final String ATUALIZA_SENHA_OP = "Atualiza senha quando utilizado servico esqueci minha senha";
	public static final String LIST_USER_BY_EMAIL_OP = "Busca usuário(s) por nome ou email";
	public static final String LIST_USER_OP = "Busca a Lista de todos os usuários";
	public static final String SAVE_USER_OP = "Salva novo usuário";
	public static final String DELETE_USER_OP = "Deleta usuário";
	public static final String PREDIO_DETALHE_OP = "Carrega os combos para detalhes dos predios para preencher as opcoes";
	public static final String PREDIO_LOAD_COMBO_OP = "Carrega os combos esteira, contratada e contratada gestão para ajuste de contratada";
	public static final String LIST_USER_BY_ID_OP = "Busca um usuário pelo ID";
	public static final String ENDERECO_LISTMUNICIPIOBYUF_OP = "Busca lista de municípios cadastrados de acordo com UF selecionada";
	public static final String ENDERECO_LISTBAIRROBYMUNICIPIO_OP = "Busca lista de bairros cadastrados de acordo com Municipio selecionado";
	public static final String GET_GROUPS_OP = "Busca todos grupos";
	public static final String LIST_PREDIOREP_BYID_OP = "Busca todas replicações";
	public static final String AJUSTE_CONTRATA_LIST_OP = "Retorna Lista com histórico de ajustes de contrata por esteira. \n Recebendo o Id do prédio.";
	public static final String REPLICA_PREDIO_OP = "Replica o prédio pelo ID";
	public static final String SAVE_AJUSTE_CONTRATADA_OP = "Salva ajuste de contratada por esteira";
	public static final String APROVA_DRAFT_OP = "Aprova draft para obra externa";
	public static final String RECUSA_DRAFT_OP = "Recusa draft para obra externa";
	public static final String HISTORICO_PREDIO_OP = "Aba Historico do predio";
	public static final String OBRA_EXTERNA_OP = "Aba obra externa";
	public static final String RETROAGIR_PREDIOS_OP = "***Menu Back-ofice -> Gerenciar Predios***";
	public static final String DESASSOCIAR_PREDIOS_OP = "***Menu Back-ofice -> Gerenciar Predios***";
	public static final String REALIZA_AGENDAMENTO_VISTORIA_OP = "Editando prédio adicionando um novo agendamento vistoria  - ***ABA - VISTORIA*** ";
	public static final String FINALIZA_AGENDAMENTO_VISTORIA_OP = "Finaliza a aba VISTORIA ao clicar no botão ***FINALIZAR***";
	public static final String LIBERA_PROJETO_EXTERNA_OP = "Aba Projeto depois que passa a etapa de Vistoria - ***LIBERACAO DE PROJETO*** nesse caso a telá terá somente poucos combos e um campo observacao";
	public static final String PROJETO_COMBOS_OP = "Carrega os combos para a tela de projeto";
	public static final String ASSOCIAR_PREDIOS_OP = "***Menu Back-ofice -> Gerenciar Predios***";
	public static final String ATUALIZAR_SATURADOS_OP = "***Menu Back-ofice -> Gerenciar Predios***";
	public static final String GERENCIAR_PREDIO_OP = "***Menu Back-ofice -> Gerenciar Predios -> Gerenciar Prédio***";
	public static final String ARMARIO_PESQUISA = "Pesquisa de armários por chave";
	public static final String ARMARIO_PESQUISA_CODIGO = "Pesquisa de armário por codigo";
	public static final String ARMARIO_LISTAGEM = "Pesquisa de armários por chave";
	public static final String ARMARIO_PESQUISA_RESULTADO = "Armários pertencentes a chave buscada e dados relacionados a páginação da busca";
	public static final String ARMARIO_PESQUISA_CODIGO_RESULTADO = "Armários pertencente ao codigo informado";
	public static final String ARMARIO_LISTAGEM_RESULTADO = "Armários existentes na base com info de regional e municipio";
	public static final String ARMARIO_INSERCAO = "Inserir armario";
	public static final String ARMARIO_ALTERACAO = "Alterar armario";
	public static final String ARMARIO_DELECAO = "Deletar armario";
	public static final String ARMARIO_DELECAO_RELACIONAMENTO_MUNICIPIO = "Deletar relacionamento com municipio";
	public static final String PREDIO_ALTERAR_ARMARIO = "Alterar o armário do prédio";

}
