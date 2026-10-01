package com.incidenciascore.incidenciascore.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity @NamedStoredProcedureQuery(
        name = "parametria",
        procedureName = "DEVLAB.PKG_PARAMETRIA.SP_CONSULTAR_PARAMETRIA",
        resultClasses = { ParamDataResponse.class },
        parameters = { @StoredProcedureParameter(
                name = "P_CURSOR",
                mode = ParameterMode.REF_CURSOR,
                type = void.class) })
public class ParamDataResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @JsonIgnore @Column(
            name = "ID")
    private Integer id;

    @Column(
            name = "CODIGO")
    private Integer codigo;

    @Column(
            name = "MSJ")
    private String msj;

    @Column(
            name = "FECHA_Y_HORA")
    private LocalDateTime fechaYHora;

    public ParamDataResponse() {
        super();
    }

    public ParamDataResponse(Integer id, Integer codigo, String msj, LocalDateTime fechaYHora) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.msj = msj;
        this.fechaYHora = fechaYHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}