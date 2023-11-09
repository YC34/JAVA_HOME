package com.example.demo.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Page<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totlaElements;

}
