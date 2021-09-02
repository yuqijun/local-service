package com.yuqijun.localservice.model.dao.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 商店联系人 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreContact {

    private String name;

    private String phone;

    /* 职位 */
    private String title;
}
