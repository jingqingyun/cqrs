package cqrs;

/**
 * CqrsException
 *
 * @author jingqingyun
 * @date 2020/10/10
 */
public class CqrsException extends RuntimeException {

    private static final long serialVersionUID = -5871555382679649664L;

    public CqrsException(String message) {
        super(message);
    }

    public CqrsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CqrsException(Throwable cause) {
        super(cause);
    }

}
