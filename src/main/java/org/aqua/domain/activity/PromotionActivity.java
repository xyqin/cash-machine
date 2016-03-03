package org.aqua.domain.activity;

import org.aqua.domain.Cart;
import org.aqua.domain.Product;

import java.util.*;

/**
 * 优惠活动
 * Created by xyqin on 16/3/3.
 */
public abstract class PromotionActivity {

    /** 参与优惠的商品条形码列表 */
    private Map<String, Integer> barcodes;

    /** 同一商品参数多个活动时匹配的优先级, 默认0, 数值越大越优先 */
    private int priority;

    public PromotionActivity(String[] barcodes) {
        this.barcodes = new HashMap<String, Integer>();
        for (String code : barcodes) {
            this.barcodes.put(code, Integer.valueOf(1));
        }
    }

    public PromotionActivity(String[] barcodes, int priority) {
        this.barcodes = new HashMap<String, Integer>();

        for (String code : barcodes) {
            this.barcodes.put(code, Integer.valueOf(1));
        }

        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    /** 优惠活动应用于购物车商品列表 */
    public abstract void apply(Cart cart);

    public boolean matchProduct(Product product) {
        return this.barcodes.get(product.getBarcode()) != null;
    }

    public boolean isPriorTo(PromotionActivity activity) {
        if (activity == null) {
            return true;
        }

        return this.priority > activity.priority;
    }

}
