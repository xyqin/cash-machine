package org.aqua.domain;

import java.math.BigDecimal;

/**
 * 商品
 * Created by xyqin on 16/3/3.
 */
public class Product {

    /**
     * 类别
     */
    private String category;

    /**
     * 名称
     */
    private String name;

    /**
     * 条形码
     */
    private String barcode;

    /**
     * 数量单位
     */
    private String unit;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    public Product(String category, String name, String barcode, String unit , BigDecimal unitPrice) {
        this.category = category;
        this.name = name;
        this.barcode = barcode;
        this.unit = unit;
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getUnit() {
        return unit;
    }
}
