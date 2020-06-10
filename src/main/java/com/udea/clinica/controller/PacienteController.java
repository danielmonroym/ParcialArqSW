/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.clinica.controller;

import com.udea.clinica.exception.ModelNotFoundException;
import com.udea.clinica.model.Paciente;
import com.udea.clinica.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")
@Api(value = "Paciente Management System", description = "Operations pertaining to paciente in Clinica Management System")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @ApiOperation(value = "Add a paciente")
    @PostMapping("/save")
    public long save(@ApiParam(value = "Paciente object store in database table", required = true) @RequestBody Paciente paciente) {
        pacienteService.save(paciente);
        return paciente.getIdPerson();
    }

    @ApiOperation(value = "View a list of available pacientes", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list")
        ,
@ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/listAll")
    public Iterable<Paciente> listAllPersons() {
        return pacienteService.list();
    }

    @ApiOperation(value = "Get a paciente by Id")
    @GetMapping("/list/{id}")
    public Paciente listPacienteById(@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable("id") int id) {
        Optional<Paciente> paciente = pacienteService.listId(id);
        
        if (paciente.isPresent()) {
            return paciente.get();
        }
        throw new ModelNotFoundException("ID de paciente invalido");
    }
}
