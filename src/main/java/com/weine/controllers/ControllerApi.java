package com.weine.controllers;

import com.weine.exception.ApiRequestException;
import com.weine.model.criteria.PageProp;
import com.weine.model.dtos.CategoryDto;
import com.weine.services.IServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Abstract class to manage the request of the clients in a generic form and works as template for a <b>Controller Class</b>,<br>
 * As the <b>GET</b> to get a page, a page with filters and find one object. {@link #getPage(Pageable)}, {@link #getPage(PageProp, Object)}, {@link #findObject(int)}.<br>
 * <b>POST</b> to save one object. {@link #saveObject(Object)}.<br>
 * <b>PUT</b> to update one object. {@link #updateObject(Object)}.<br>
 * <b>DELETE</b> to delete one object. {@link #deleteObject(int)}.<br>
 * Also to use those methods and appears in the controllers must to override, add the correct beans and in the constructor must to call the super
 * constructor and initialize the logger e.g.<br>
 * <pre>{@code
 *      //The controller beans
 *      @RestController
 *      @RequestMapping("/example")
 *      public class ExampleController extends ControllerApi<ExampleDto, ExampleCriteria, ExampleService>{
 *          public ExampleController(IServiceApi<ExampleDto, ExampleCriteria> service) {
 *              super(service);
 *              //The initialization of the logger
 *              this.logger = LoggerFactory.getLogger(ExampleController.class);
 *          }
 *          //The get mapping bean
 *          @GetMapping
 *          @Override
 *          public ResponseEntity<Page<ExampleDto>> getPage(PageProp pageProp, ExampleCriteria criteria) {
 *              return super.getPage(pageProp, criteria);
 *          }
 *     }
 * }</pr>
 * @param <D> The Data dto type
 * @param <C> The CriteriaSearch type
 * @param <S> The Service type with the previous types
 * @author Luis
 * @since BACKEND_BD-0.1
 * @version 1.0
 */
@RequiredArgsConstructor
public abstract class ControllerApi<D,C, S extends IServiceApi<D,C>> {
    protected Logger logger;
    private final IServiceApi<D,C> service;

    /**
     * Function to get the request of the client in a <b>GET</b> form.<br>
     * This request is to obtain the objects in a page with the filters applied.
     * @param pageProp The page properties
     * @param criteria The search criteria properties
     * @return The page obtained
     */
    public ResponseEntity<Page<D>> getPage(PageProp pageProp, C criteria)
    {
        logger.info("Obtaining "+ getEntityPluralName()+ "...");
        ResponseEntity<Page<D>> response = ResponseEntity.ok(this.service.getPage(pageProp, criteria));
        logger.info(getEntityName()+"s obtained...");
        return response;
    }

    /**
     * Function to get the request of the client in a <b>GET</b> form.<br>
     * This request is to obtain the objects in a page.
     * @param pageProp The page properties
     * @return The page obtained
     */
    public ResponseEntity<Page<D>> getPage(Pageable pageProp)    {
        logger.info("Obtaining "+ getEntityPluralName()+ "...");
        ResponseEntity<Page<D>> response = ResponseEntity.ok(this.service.getPage(pageProp));
        logger.info(getEntityName()+"s obtained...");
        return response;
    }
    /**
     * Function to get the request of the client in a <b>GET</b> form.<br>
     * This request is to obtain all the objects in a list.
     * @return The list obtained
     */
    public ResponseEntity<List<D>> getObjects()
    {
        logger.info("Obtaining "+ getEntityPluralName()+ "...");
        ResponseEntity<List<D>> response = ResponseEntity.ok(this.service.getObjects());
        logger.info(getEntityName()+"s obtained...");
        return response;
    }
    /**
     * Function to get the request of the client in a <b>GET</b> form.<br>
     * This request is to obtain the object with their own id.
     * @param id The id of the object
     * @return The object obtained
     */
    public ResponseEntity<D> findObject(int id)
    {
        logger.info("Find " + getEntityName() + " "+ id +"...");
        D response = this.service.find(id);
        if(response == null)
        {
            logger.info(getEntityName() + " " + id + " not found...");
            throw new ApiRequestException("No " + getEntityName() + " " + id + " exist", HttpStatus.NOT_FOUND);
        }
        logger.info(getEntityName() + " found...");
        return ResponseEntity.ok(response);
    }

    /**
     * Function to get the request of the client in a <b>POST</b> form.<br>
     * This request is to <b>save</b> the object in the database.
     * @param requestObject The object to save
     * @return The result and the returned object of the database
     */
    public ResponseEntity<D> saveObject(@RequestBody D requestObject)
    {
        logger.info("Save " + getEntityName() + "...");
        try{
            D response = this.service.save(requestObject);
            if(response == null)
            {
                logger.warn(getEntityName() + " " + requestObject + " has not been saved");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info(getEntityName() + " saved...");
            return ResponseEntity.ok(response);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * Function to get the request of the client in a <b>PUT</b> form.<br>
     * This request is to <b>update</b> the object in the database.
     * @param requestObject The object to update
     * @return The result and the returned object of the database
     */
    public ResponseEntity<D> updateObject(@RequestBody D requestObject)
    {
        logger.info("Update " + getEntityName() + "...");
        try{
            D response = this.service.update(requestObject);
            if(response == null)
            {
                logger.warn(getEntityName() + " " + requestObject + "has not been updated");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info(getEntityName() + " updated...");
            return ResponseEntity.ok(response);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * Function to get the request of the client in a <b>DELETE</b> form.<br>
     * This request is to <b>delete</b> the object in the database.
     * @param id The id of the obeject to delete
     * @return The result of the request EITHER was deleted or not
     */
    public ResponseEntity<?> deleteObject(int id)
    {
        logger.info("Delete" + getEntityName() + "...");
        try {
            this.service.delete(id);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("No " + getEntityName() + " " + id + " exist", HttpStatus.NOT_FOUND);
        }
        logger.info(getEntityName() + " deleted...");
        return ResponseEntity.ok().build();
    }

    /**
     * Function to get the name of the entity
     * @return The Entity name
     */
    protected abstract String getEntityName();
    /**
     * Function to get the name of the entity in plural form
     * @return The Entity plural name
     */
    protected abstract String getEntityPluralName();
}
