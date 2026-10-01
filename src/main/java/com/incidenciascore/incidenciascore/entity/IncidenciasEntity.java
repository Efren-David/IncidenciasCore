package com.incidenciascore.incidenciascore.entity;

import java.time.LocalDateTime;

import com.google.gson.Gson;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;

@Entity @NamedStoredProcedureQueries({

        @NamedStoredProcedureQuery(
                name = "evntIncidencias",
                procedureName = "DEVLAB.PKG_INCIDENCIAS.SP_REGISTRAR_INCIDENCIA",
                resultClasses = { IncidenciasEntity.class }),

        @NamedStoredProcedureQuery(
                name = "consultarIncidenciasPorTipo",
                procedureName = "DEVLAB.PKG_CONTADORES_INCIDENCIAS.SP_CONSULTAR_POR_TIPO",
                resultClasses = { IncidenciasEntity.class }),

        @NamedStoredProcedureQuery(
                name = "consultarIncidenciasCsv",
                procedureName = "DEVLAB.PKG_CSV_INCIDENCIAS.SP_CONSULTAR_INCIDENCIAS",
                resultClasses = { IncidenciasEntity.class })

})
public class IncidenciasEntity {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long idEvento;

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

    public IncidenciasEntity() {
        super();
    }

    public IncidenciasEntity(Long idEvento, String codSucursal, String nombreCliente, LocalDateTime fechaRegistro,
            String tipoClasificacion, String marcaProducto, String codCajero, String codReferencia,
            LocalDateTime fechaUltimaAct, String datoExtra, Long idReporte, Integer estadoReporte, Integer indCita,
            Integer indAtencion, LocalDateTime fechaCita, Long codTipoEvento, String observaciones,
            LocalDateTime fechaResolucion, Long idObservacion) {
        super();
        this.idEvento = idEvento;
        this.codSucursal = codSucursal;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.tipoClasificacion = tipoClasificacion;
        this.marcaProducto = marcaProducto;
        this.codCajero = codCajero;
        this.codReferencia = codReferencia;
        this.fechaUltimaAct = fechaUltimaAct;
        this.datoExtra = datoExtra;
        this.idReporte = idReporte;
        this.estadoReporte = estadoReporte;
        this.indCita = indCita;
        this.indAtencion = indAtencion;
        this.fechaCita = fechaCita;
        this.codTipoEvento = codTipoEvento;
        this.observaciones = observaciones;
        this.fechaResolucion = fechaResolucion;
        this.idObservacion = idObservacion;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(String tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getCodCajero() {
        return codCajero;
    }

    public void setCodCajero(String codCajero) {
        this.codCajero = codCajero;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    public LocalDateTime getFechaUltimaAct() {
        return fechaUltimaAct;
    }

    public void setFechaUltimaAct(LocalDateTime fechaUltimaAct) {
        this.fechaUltimaAct = fechaUltimaAct;
    }

    public String getDatoExtra() {
        return datoExtra;
    }

    public void setDatoExtra(String datoExtra) {
        this.datoExtra = datoExtra;
    }

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(Integer estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public Integer getIndCita() {
        return indCita;
    }

    public void setIndCita(Integer indCita) {
        this.indCita = indCita;
    }

    public Integer getIndAtencion() {
        return indAtencion;
    }

    public void setIndAtencion(Integer indAtencion) {
        this.indAtencion = indAtencion;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Long getCodTipoEvento() {
        return codTipoEvento;
    }

    public void setCodTipoEvento(Long codTipoEvento) {
        this.codTipoEvento = codTipoEvento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Long getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Long idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Override
    public String toString() {
        return "IncidenciasEntity [idEvento=" + idEvento
                + ", codSucursal="
                + codSucursal
                + ", nombreCliente="
                + nombreCliente
                + ", fechaRegistro="
                + fechaRegistro
                + ", tipoClasificacion="
                + tipoClasificacion
                + ", marcaProducto="
                + marcaProducto
                + ", codCajero="
                + codCajero
                + ", codReferencia="
                + codReferencia
                + ", fechaUltimaAct="
                + fechaUltimaAct
                + ", datoExtra="
                + datoExtra
                + ", idReporte="
                + idReporte
                + ", estadoReporte="
                + estadoReporte
                + ", indCita="
                + indCita
                + ", indAtencion="
                + indAtencion
                + ", fechaCita="
                + fechaCita
                + ", codTipoEvento="
                + codTipoEvento
                + ", observaciones="
                + observaciones
                + ", fechaResolucion="
                + fechaResolucion
                + ", idObservacion="
                + idObservacion
                + "]";
    }

}
