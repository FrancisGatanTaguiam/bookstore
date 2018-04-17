/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package bookstore.services;

import bookstore.data.BaseServiceResponse;
import bookstore.data.enums.ServiceStatus;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * <p>
 * Class that handles the return of all Errors as JSON object.
 * </p>
 * 
 * @since June 18, 2016
 */
@Provider
public class StandardErrorMapper implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception exception) {
        BaseServiceResponse response = new BaseServiceResponse();
        response.setStatus(ServiceStatus.ERROR);
        response.setMessage(exception.getMessage());
        
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }
    
}
