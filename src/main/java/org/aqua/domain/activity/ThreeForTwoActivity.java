package org.aqua.domain.activity;

import org.aqua.domain.Cart;
import org.aqua.domain.LineItem;

import java.math.BigDecimal;

/**
 * 买二赠一活动
 * Created by xyqin on 16/3/3.
 */
public class ThreeForTwoActivity extends PromotionActivity {

    public ThreeForTwoActivity(String[] barcodes) {
        super(barcodes);
    }

    public ThreeForTwoActivity(String[] barcodes, int priority) {
        super(barcodes, priority);
    }

    @Override
    public void apply(Cart cart) {
        int numOfThreeForTwo = 0;

        for (LineItem item : cart.getItems()) {
            if (this.isPriorTo(item.getActivity()) && this.matchProduct(item.getProduct())) {
                int rest = item.getNum() % 3;
                int offered = (item.getNum() - rest) / 3;
                int paid = item.getNum() - offered;
                item.setActivity(this);
                item.setNumOffered(offered);
                item.setAmountAfterDiscount(item.getProduct().getUnitPrice().multiply(new BigDecimal(paid)));

                numOfThreeForTwo++;
            }
        }

        cart.setNumOfThreeForTwo(numOfThreeForTwo);
    }

}
