/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.clinica.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *


/**
 *
 * @author Victor
 */
 import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "All details about the Person. ")
@Entity
public class Paciente implements Serializable {

    @ApiModelProperty(notes = "The database generated person ID")
    @Id
    @Column(name = "cedula")
    private Long idPerson;
    @ApiModelProperty(notes = "The first name")
    @Column(name = "nombre", nullable = false, length = 80)
    private @NonNull
    String firstName;

    @ApiModelProperty(notes = "The last name")
    @Column(name = "apellido", nullable = false, length = 80)
    private @NonNull
    String lastName;

    @ApiModelProperty(notes = "The personal email ")
    @Column(name = "email", nullable = true, length = 80)
    private @NonNull
    String email;

    @ApiModelProperty(notes = "Historias medicas ")
    @OneToMany(mappedBy = "cedula")
    private List<Historia> historia;

}
