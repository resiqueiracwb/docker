/**
 * 
 */
package com.painel.exception;

import com.painel.enums.ErrorCode;
import com.painel.vo.ErrorVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



/**
 * @author A0051460
 *
 */
@ControllerAdvice
public class PrumaGlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({UsernameNotFoundException.class,CertificacaoNotFoundException.class, ObraExternaNotFoundException.class, PredioNotFoundException.class, DocumentNotFoundException.class, DocumentNotFoundPrumaException.class , AgendamentoNotFoundException.class, VistoriaNotFoundException.class, ProjetoNotFoundException.class})
	public ResponseEntity<Object> handleErrorNotFound(PainelException prumaException, WebRequest request) {
		return handleExceptionInternal(prumaException, new ErrorVO(prumaException), this.getHttpHeaders(),
				HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<Object> handleErrorUnauthorized(PainelException prumaException, WebRequest request) {
		return handleExceptionInternal(prumaException, new ErrorVO(prumaException), this.getHttpHeaders(),
				HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler({EsteiraInicialMaiorException.class, ReplicaPredioException.class, ErrorSaveAgendamentoException.class, FormatUFException.class, FormatMunicipioException.class, FormatBairroException.class})
	public ResponseEntity<Object> handleErrorNotAcceptable(PainelException prumaException, WebRequest request) {
		return handleExceptionInternal(prumaException, new ErrorVO(prumaException), this.getHttpHeaders(),
				HttpStatus.NOT_ACCEPTABLE, request);
	}

	@ExceptionHandler({UploadDocumentManagerException.class, ErrorReadFilePrumaLegacyException.class})
	public ResponseEntity<Object> handleErrorActivitiErrorException(PainelException prumaException, WebRequest request) {
		return handleExceptionInternal(prumaException,
				new ErrorVO(prumaException.getActivitiErrorCode(), prumaException.getMessage()), this.getHttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	public ResponseEntity<Object> handleErrorRedirect(PainelException businessException, WebRequest request) {
		return handleExceptionInternal(businessException, new ErrorVO(businessException), this.getHttpHeaders(),
				HttpStatus.TEMPORARY_REDIRECT, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleErrorDefault(Exception exception, WebRequest request) {
		ErrorVO errorVO = new ErrorVO();
		errorVO.setCode(ErrorCode.GENERIC.getCode());
		errorVO.setDescription(ErrorCode.GENERIC.getDescription());
		errorVO.setComments(ErrorCode.GENERIC.getComments());

		logger.error(errorVO.toString(), exception);

		return handleExceptionInternal(exception, errorVO, this.getHttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}
}