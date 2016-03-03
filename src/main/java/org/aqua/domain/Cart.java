package org.aqua.domain;

import org.aqua.domain.activity.PromotionActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * Created by xyqin on 16/3/3.
 */
public class Cart {

    /** 结算商品列表 */
    private List<LineItem> items = new ArrayList<LineItem>();

    private int numOfThreeForTwo;

    public List<LineItem> getItems() {
        return items;
    }

    public int getNumOfThreeForTwo() {
        return numOfThreeForTwo;
    }

    public void setNumOfThreeForTwo(int numOfThreeForTwo) {
        this.numOfThreeForTwo = numOfThreeForTwo;
    }

    public void addLineItem(LineItem item) {
        this.items.add(item);
    }

    public BigDecimal getTotalAfterDiscount() {
        BigDecimal total = new BigDecimal(0);

        for (LineItem item : this.items) {
            if (item.getAmountAfterDiscount() != null) {
                total = total.add(item.getAmountAfterDiscount());
            } else {
                total = total.add(item.getAmount());
            }
        }

        return total;
    }

    public BigDecimal getTotalSaved() {
        BigDecimal saved = new BigDecimal(0);

        for (LineItem item : this.items) {
            if (item.getActivity() != null && item.getActivity() instanceof PromotionActivity) {
                BigDecimal subSaved = item.getAmount().subtract(item.getAmountAfterDiscount());
                saved = saved.add(subSaved);
            }
        }

        return saved;
    }

}
