/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Melanio
 */
public class deucli {
  Integer dcl_codigo;
  Integer dcl_numven;
  Double dcl_monto;
  Date dcl_fecha;
  Double dcl_pagado;
  Integer dcl_codcli;
  String dcl_descli;

    public deucli() {
    }

    public deucli(Integer dcl_codigo, Integer dcl_numven, Double dcl_monto, Date dcl_fecha, Double dcl_pagado, Integer dcl_codcli, String dcl_descli) {
        this.dcl_codigo = dcl_codigo;
        this.dcl_numven = dcl_numven;
        this.dcl_monto = dcl_monto;
        this.dcl_fecha = dcl_fecha;
        this.dcl_pagado = dcl_pagado;
        this.dcl_codcli = dcl_codcli;
        this.dcl_descli = dcl_descli;
        
    }

    public Integer getDcl_codigo() {
        return dcl_codigo;
    }

    public void setDcl_codigo(Integer dcl_codigo) {
        this.dcl_codigo = dcl_codigo;
    }

    public Integer getDcl_numven() {
        return dcl_numven;
    }

    public void setDcl_numven(Integer dcl_numven) {
        this.dcl_numven = dcl_numven;
    }

    public Double getDcl_monto() {
        return dcl_monto;
    }

    public void setDcl_monto(Double dcl_monto) {
        this.dcl_monto = dcl_monto;
    }

    public Date getDcl_fecha() {
        return dcl_fecha;
    }

    public void setDcl_fecha(Date dcl_fecha) {
        this.dcl_fecha = dcl_fecha;
    }

    public Double getDcl_pagado() {
        return dcl_pagado;
    }

    public void setDcl_pagado(Double dcl_pagado) {
        this.dcl_pagado = dcl_pagado;
    }

    public Integer getDcl_codcli() {
        return dcl_codcli;
    }

    public void setDcl_codcli(Integer dcl_codcli) {
        this.dcl_codcli = dcl_codcli;
    }

    public String getDcl_descli() {
        return dcl_descli;
    }

    public void setDcl_descli(String dcl_descli) {
        this.dcl_descli = dcl_descli;
    }
    
    

    @Override
    public String toString() {
        return "deucli{" + "dcl_codigo=" + dcl_codigo + ", dcl_numven=" + dcl_numven + ", dcl_monto=" + dcl_monto + ", dcl_fecha=" + dcl_fecha + ", dcl_pagado=" + dcl_pagado + ", dcl_codcli=" + dcl_codcli + '}';
    }
  
  
  
    
    
    
}
