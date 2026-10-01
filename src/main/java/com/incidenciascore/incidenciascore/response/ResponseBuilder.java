package com.incidenciascore.incidenciascore.response;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {

    public static final String CODIGO = "400.cajeros-automatica-aclaraciones.4000";
    public static final String MENSAJE = "Solicitud mal formada, favor de valida";
    public static final String FOLIO = "N/A";
    public static final String INFO = "N/A";

    public static IncidenciasResponse buildErrorResponse(String mensaje, HttpStatus status) {
        IncidenciasResponse responseData = new IncidenciasResponse();
        responseData.setCodigo(status.value());
        responseData.setMsj(mensaje);
        responseData.setIncidencia(null);
        return responseData;
    }

    public static ContadoresIncidenciasResponse buildErrorContadoresResponse(String mensaje, HttpStatus status) {
        ContadoresIncidenciasResponse responseData = new ContadoresIncidenciasResponse();
        responseData.setCodigo(status.value());
        responseData.setMsj(mensaje);
        responseData.setIncidencias(null);
        responseData.setTotalIncidencias(0);
        return responseData;
    }

}
