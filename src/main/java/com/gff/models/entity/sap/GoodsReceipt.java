package com.gff.models.entity.sap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*Representa tabla del sistema SAP. OIGN - Terminacion report, Entrada de mercancías*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "OIGN")
public class GoodsReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer docEntry;

    //Número de terminacion report.
    private Integer docNum;

    //Fecha de contabilización.
    private Date startDate;
    
    //Comentarios
    private String Comments;

}
