package com.cdkj.loan.dto.res;

import java.util.List;
import lombok.Data;

@Data
public class ProvinceRes {

    //键
    private String key;

    //值
    private String value;

    //城市列表
    private List<CityRes> cityResList;


}
