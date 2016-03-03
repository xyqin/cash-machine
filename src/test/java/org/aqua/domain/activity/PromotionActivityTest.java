package org.aqua.domain.activity;

import org.aqua.domain.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xyqin on 16/3/4.
 */
public class PromotionActivityTest {

    @Test
    public void testPriorToNull() {
        PromotionActivity activity = new DiscountActivity(new String[0]);
        Assert.assertTrue(activity.isPriorTo(null));
    }

    @Test
    public void testPriorToHigh() {
        PromotionActivity activity = new DiscountActivity(new String[0]);
        PromotionActivity activity1 = new DiscountActivity(new String[0], 1);
        Assert.assertFalse(activity.isPriorTo(activity1));
    }

    @Test
    public void testPriorToLow() {
        PromotionActivity activity = new DiscountActivity(new String[0], 2);
        PromotionActivity activity1 = new DiscountActivity(new String[0], 1);
        Assert.assertTrue(activity.isPriorTo(activity1));
    }

    @Test
    public void testMatchNonProduct() {
        Product product = new Product("饮料", "可口可乐", "ITEM000003", "瓶", new BigDecimal(3));
        PromotionActivity activity = new DiscountActivity(new String[]{"ITEM000001", "ITEM000002"});
        Assert.assertFalse(activity.matchProduct(product));
    }

    @Test
    public void testMatchProduct() {
        Product product = new Product("饮料", "可口可乐", "ITEM000001", "瓶", new BigDecimal(3));
        PromotionActivity activity = new DiscountActivity(new String[]{"ITEM000001", "ITEM000002"});
        Assert.assertTrue(activity.matchProduct(product));
    }

}
