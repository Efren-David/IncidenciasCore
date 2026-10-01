package com.incidenciascore.incidenciascore.response;

import java.io.Serializable;

import com.google.gson.Gson;

public class BaseResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer codigo;

    private String msj;

    public BaseResponse() {
        super();
    }

    public BaseResponse(Integer codigo, String msj) {
        super();
        this.codigo = codigo;
        this.msj = msj;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
