/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.clinica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ApiModel(description = "All details about the hitoria. ")
@Entity
/**
 *
 * @author Victor
 */
class Historia implements Serializable {
  @ApiModelProperty(notes = "The database generated historia clinica ID")
   @Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idhistoria")
private Long idhistoria;
@ApiModelProperty(notes = "El nombre del doctor")
@Column(name="nombreD", nullable=false, length=80)
private @NonNull String nombreD;

@ApiModelProperty(notes = "La cedula del paciente")
@ManyToOne
@JoinColumn(name="cedula")
private Paciente cedula;


@ApiModelProperty(notes = "La fecha del registro")
@Column(name="fecha", nullable=false, length=80)
private @NonNull String fecha;
    
}