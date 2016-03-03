package org.aqua.domain;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xyqin on 16/3/3.
 */
public class LineItemTest {

    @Test
    public void testAmountValue() {
        Product product = new Product("饮料", "可口可乐", "ITEM000001", "瓶", new BigDecimal(3));
        LineItem item = new LineItem(product, 3);

        Assert.assertEquals(9, item.getAmount().intValue());
    }

}
