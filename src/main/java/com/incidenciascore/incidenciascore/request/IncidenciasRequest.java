package com.incidenciascore.incidenciascore.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class IncidenciasRequest {

    private String codSucursal;
    private String nombreCliente;
    private LocalDateTime fechaRegistro;
    private String tipoClasificacion;
    private String marcaProducto;
    private String codCajero;
    private String codReferencia;
    private LocalDateTime fechaUltimaAct;
    private String datoExtra;
    private Long idReporte;
    private Integer estadoReporte;
    private Integer indCita;
    private Integer indAtencion;
    private LocalDateTime fechaCita;
    private Long codTipoEvento;
    private String observaciones;
    private LocalDateTime fechaResolucion;
    private Long idObservacion;

}
