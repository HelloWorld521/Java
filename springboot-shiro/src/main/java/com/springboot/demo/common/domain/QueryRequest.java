package com.springboot.demo.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;

    private int pageSize;
    private int pageNum;

    private String sortField;
    private String sortOrder;
}