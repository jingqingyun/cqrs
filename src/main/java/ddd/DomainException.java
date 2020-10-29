package ddd;

/**
 * DomainException
 *
 * @author jingqingyun
 * @date 2020/10/10
 */
public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 2793443794579613111L;

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }

}
