package com.akademiakodu.blog.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AuditEntity {

    private Date added = new Date();
    private String addedBy;
    private Date modified;
    private String modifiedBy;



}
