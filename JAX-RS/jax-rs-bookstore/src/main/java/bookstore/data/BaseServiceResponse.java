/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package bookstore.data;

import bookstore.data.enums.ServiceStatus;

/**
 *
 * @since June 16, 2016
 */
public class BaseServiceResponse {
    private ServiceStatus status;
    private String message;
    
    public BaseServiceResponse() {}

    public BaseServiceResponse(ServiceStatus status) {
        this.status = status;
    }

    public BaseServiceResponse(ServiceStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
