package com.lyd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class QueryVo {
    private Integer[] ids;
    private List<Integer> idList;
}
