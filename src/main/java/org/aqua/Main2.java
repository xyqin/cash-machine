package org.aqua;

import org.aqua.domain.*;
import org.aqua.domain.activity.DiscountActivity;
import org.aqua.printer.ConsolePrinter;

import java.math.BigDecimal;

/**
 * 当购买的商品中，有符合“95折”优惠条件的商品时
 * Created by xyqin on 16/3/4.
 */
public class Main2 {

    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        register.setPrinter(new ConsolePrinter());

        DiscountActivity activity = new DiscountActivity(new String[]{"ITEM000003", "ITEM000004"});
        register.addActivity(activity);

        Product cola = new Product("饮料", "可口可乐", "ITEM000001", "瓶", new BigDecimal(3));
        LineItem item1 = new LineItem(cola, 3);
        Product badminton = new Product("体育用品", "羽毛球", "ITEM000002", "个", new BigDecimal(1));
        LineItem item2 = new LineItem(badminton, 5);
        Product apple = new Product("水果", "苹果", "ITEM000003", "斤", new BigDecimal(5.5));
        LineItem item3 = new LineItem(apple, 2);
        Cart cart = new Cart();
        cart.addLineItem(item1);
        cart.addLineItem(item2);
        cart.addLineItem(item3);

        register.checkout(cart);
    }

}
