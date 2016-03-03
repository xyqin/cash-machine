package org.aqua.domain;

import org.aqua.domain.activity.PromotionActivity;

import java.math.BigDecimal;

/**
 * 购物车条目
 * Created by xyqin on 16/3/3.
 */
public class LineItem {

    private Product product;

    /** 购买数量*/
    private int num;

    /** 赠送的数量 */
    private int numOffered;

    /** 商品金额小计 */
    private BigDecimal amount;

    /** 优惠后的金额小计 */
    private BigDecimal amountAfterDiscount;

    /** 应用的优惠活动 */
    private PromotionActivity activity;

    public LineItem(Product product, int num) {
        this.product = product;
        this.num = num;

        this.amount = this.product.getUnitPrice().multiply(new BigDecimal(this.num));
    }

    public Product getProduct() {
        return product;
    }

    public int getNum() {
        return num;
    }

    public int getNumOffered() {
        return numOffered;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getAmountAfterDiscount() {
        return this.amountAfterDiscount;
    }

    public PromotionActivity getActivity() {
        return activity;
    }

    public void setAmountAfterDiscount(BigDecimal amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public void setNumOffered(int numOffered) {
        this.numOffered = numOffered;
    }

    public void setActivity(PromotionActivity activity) {
        this.activity = activity;
    }

}
