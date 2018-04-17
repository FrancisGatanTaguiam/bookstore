/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.dao.exception;

/**
 * <p>
 * Standard Exception thrown by all DAOs.
 * </p>
 *
 * @since June 22, 2016
 */
public class DaoException extends Exception {
    private static final long serialVersionUID = 3794165852606546425L;
    
    private String errorCode;
    private String messageKey;

    public DaoException(String errorCode, String messageKey) {
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public DaoException(String errorCode, String messageKey, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public DaoException(String errorCode, String messageKey, String message) {
        super(message);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}
