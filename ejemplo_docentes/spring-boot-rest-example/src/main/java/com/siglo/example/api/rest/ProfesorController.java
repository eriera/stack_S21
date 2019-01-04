package com.siglo.example.api.rest;

import com.siglo.example.domain.Profesor;
import com.siglo.example.exception.DataFormatException;
import com.siglo.example.service.ProfesorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */
@RestController
@RequestMapping(value = "/example/v1/profesores")
@Api(tags = {"profesores"})
public class ProfesorController extends AbstractRestHandler {


    @Autowired
    private ProfesorService profesorService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un nuevo registro de profesor.", notes = "Returns the URL of the new resource in the Location header.")
    public void createProfesor(@RequestBody Profesor profesor,
                            HttpServletRequest request, HttpServletResponse response) {
        Profesor createdprofesor = this.profesorService.createProfesor(profesor);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdprofesor.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna todos los profesores en una lista paginada.", notes = "La lista es paginada. Puedes indicar el numero de pagina (default 0) y el tamaño de la pagina (default 100)")
    public
    @ResponseBody
    Page<Profesor> getAllProfesores(@ApiParam(value = "The page number (zero-based)", required = true)
                            @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                            @ApiParam(value = "Tha page size", required = true)
                            @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                            HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        return this.profesorService.getAllProfesores(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna un Profesor.", notes = "Debes indicar el Id del profesor.")
    public
    @ResponseBody
    Profesor getProfesor(@ApiParam(value = "El ID del profesor.", required = true)
                   @PathVariable("id") Long id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        Profesor profesor = this.profesorService.getProfesor(id);
        checkResourceFound(profesor);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        return profesor;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualizar datos de un Profesor.", notes = "Debes ingresar un ID valido y el cuerpo con la informacion.")
    public void updateProfesor(@ApiParam(value = "ID de un profesor existente.", required = true)
                            @PathVariable("id") Long id, @RequestBody Profesor profesor,
                            HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.profesorService.getProfesor(id));
        if (id != profesor.getId()) throw new DataFormatException("El ID no existe!");
        this.profesorService.updateProfesor(profesor);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Eliminar Profesor.", notes = "Debes ingresar un ID valido en la URL. Realiza una eliminacion fisica del mismo.")
    public void deleteProfesor(@ApiParam(value = "ID de un profesor existente.", required = true)
                            @PathVariable("id") Long id, HttpServletRequest request,
                            HttpServletResponse response) {
        checkResourceFound(this.profesorService.getProfesor(id));
        this.profesorService.deleteProfesor(id);
    }

}
