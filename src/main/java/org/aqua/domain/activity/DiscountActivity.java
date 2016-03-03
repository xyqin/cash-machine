package org.aqua.domain.activity;

import org.aqua.domain.Cart;
import org.aqua.domain.LineItem;

import java.math.BigDecimal;

/**
 * 折扣活动
 * Created by xyqin on 16/3/3.
 */
public class DiscountActivity extends PromotionActivity {

    public DiscountActivity(String[] barcodes) {
        super(barcodes);
    }

    public DiscountActivity(String[] barcodes, int priority) {
        super(barcodes, priority);
    }

    @Override
    public void apply(Cart cart) {
        for (LineItem item : cart.getItems()) {
            if (this.isPriorTo(item.getActivity()) && this.matchProduct(item.getProduct())) {
                item.setActivity(this);
                item.setAmountAfterDiscount(item.getAmount().multiply(new BigDecimal(0.95)));
            }
        }
    }

}
