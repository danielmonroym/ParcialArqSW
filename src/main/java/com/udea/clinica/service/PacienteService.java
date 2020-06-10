/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.clinica.service;

import com.udea.clinica.dao.IPacienteDAO;
import com.udea.clinica.model.Paciente;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PacienteService {

@Autowired
private IPacienteDAO dao;
public Paciente save(Paciente t) {return dao.save(t);}
public Paciente update(Paciente t) {return dao.save(t);}

public void delete(Paciente t) {dao.delete(t);}
public Iterable<Paciente> list() {return dao.findAll();}
public Optional<Paciente> listId(long id) {return dao.findById(id);}
}