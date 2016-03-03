package org.aqua;

import org.aqua.domain.Cart;
import org.aqua.domain.activity.PromotionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 收银机
 * Created by xyqin on 16/3/3.
 */
public class CashRegister {

    private Printer printer;

    private List<PromotionActivity> activities = new ArrayList<PromotionActivity>();

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void addActivity(PromotionActivity activity) {
        this.activities.add(activity);
    }

    /** 结算购物车商品 */
    public void checkout(Cart cart) {
        for (PromotionActivity activity : this.activities) {
            activity.apply(cart);
        }

        this.printer.printReceipt(cart);
    }

}
