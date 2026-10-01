package com.incidenciascore.incidenciascore.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;

import com.incidenciascore.incidenciascore.request.IncidenciasRequest;

@JsonPropertyOrder({ "codigo", "msj", "incidencia" })
public class IncidenciasResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IncidenciasRequest incidencia;

    public IncidenciasResponse() {
        super();
    }

    public IncidenciasResponse(IncidenciasRequest incidencia) {
        super();
        this.incidencia = incidencia;
    }

    public IncidenciasRequest getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(IncidenciasRequest incidencia) {
        this.incidencia = incidencia;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
