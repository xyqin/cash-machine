package org.aqua.domain.activity;

import org.aqua.domain.Cart;
import org.aqua.domain.LineItem;
import org.aqua.domain.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xyqin on 16/3/4.
 */
public class ThreeForTwoActivityTest {

    @Test
    public void testApplyNonProduct() {
        ThreeForTwoActivity activity = new ThreeForTwoActivity(new String[]{"ITEM000001", "ITEM000002"});
        Product product = new Product("饮料", "可口可乐", "ITEM000003", "瓶", new BigDecimal(3));
        LineItem item = new LineItem(product, 3);
        Cart cart = new Cart();
        cart.addLineItem(item);
        activity.apply(cart);

        Assert.assertNull(item.getActivity());
    }

    @Test
    public void testApplyProduct() {
        ThreeForTwoActivity activity = new ThreeForTwoActivity(new String[]{"ITEM000001", "ITEM000002"});
        Product product = new Product("饮料", "可口可乐", "ITEM000002", "瓶", new BigDecimal(3));
        LineItem item = new LineItem(product, 4);
        Cart cart = new Cart();
        cart.addLineItem(item);
        activity.apply(cart);

        int rest = item.getNum() % 3;

        Assert.assertNotNull(item.getActivity());
        Assert.assertEquals((item.getNum() - rest) / 3, item.getNumOffered());
    }

}
