package com.incidenciascore.incidenciascore.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.incidenciascore.incidenciascore.entity.IncidenciasEntity;

@JsonPropertyOrder({ "codigo", "msj", "incidencia" })
public class ContadoresIncidenciasResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("contadores")
    private int totalIncidencias;

    private List<IncidenciasEntity> incidencias;

    public ContadoresIncidenciasResponse() {
        super();
    }

    public ContadoresIncidenciasResponse(int totalIncidencias, List<IncidenciasEntity> incidencias) {
        super();
        this.totalIncidencias = totalIncidencias;
        this.incidencias = incidencias;
    }

    public int getTotalIncidencias() {
        return totalIncidencias;
    }

    public void setTotalIncidencias(int totalIncidencias) {
        this.totalIncidencias = totalIncidencias;
    }

    public List<IncidenciasEntity> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<IncidenciasEntity> incidencias) {
        this.incidencias = incidencias;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {

        return "ContadoresIncidenciasResponse [" + "codigo="
                + getCodigo()
                + ", msj="
                + getMsj()
                + ", totalIncidencias="
                + totalIncidencias
                + ", incidencias="
                + (incidencias != null ? incidencias.size() : 0)
                + "]";
    }

}
