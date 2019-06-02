package mx.com.blueharvest.commons.exception;

/**
 * Tipo de excepción particular para los errores propios del componente de ejecución de transacciones.
 *
 * @author Adesis
 *
 */
public class BusinessServiceException extends RuntimeException {

	private static final long serialVersionUID = 4539779395474270321L;

	/**
	 *
	 * @param message
	 */
	public BusinessServiceException(final String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */
	public BusinessServiceException(final Throwable cause) {
		super(cause);
	}

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public BusinessServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
