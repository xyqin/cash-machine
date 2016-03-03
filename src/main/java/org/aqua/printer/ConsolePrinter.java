package org.aqua.printer;

import org.aqua.Printer;
import org.aqua.domain.Cart;
import org.aqua.domain.activity.DiscountActivity;
import org.aqua.domain.LineItem;
import org.aqua.domain.activity.ThreeForTwoActivity;

import java.math.BigDecimal;

/**
 * 控制台打印
 * Created by xyqin on 16/3/3.
 */
public class ConsolePrinter implements Printer {

    public void printReceipt(Cart cart) {
        this.printHead();

        for (LineItem item : cart.getItems()) {
            this.printItem(item);
        }

        this.printBreakLine();

        if (cart.getNumOfThreeForTwo() > 0) {
            this.printThreeForTwoHead();

            for (LineItem item : cart.getItems()) {
                this.printThreeForTwoItem(item);
            }

            this.printBreakLine();
        }

        System.out.printf("总计：%.2f(元)\n", cart.getTotalAfterDiscount());

        if (!cart.getTotalSaved().equals(BigDecimal.ZERO)) {
            System.out.printf("节省：%.2f(元)\n", cart.getTotalSaved());
        }

        this.printFoot();
    }

    private void printHead() {
        System.out.println("***<没钱赚商店>购物清单***");
    }

    private void printThreeForTwoHead() {
        System.out.println("买二赠一商品：");
    }

    private void printBreakLine() {
        System.out.println("----------------------");
    }

    private void printFoot() {
        System.out.println("**********************");
    }

    private void printItem(LineItem item) {
        if (item.getActivity() != null && item.getActivity() instanceof DiscountActivity) {
            System.out.printf("名称：%s，数量：%d%s，单价：%.2f(元)，小计：%.2f(元)，节省0.55(元)\n", item.getProduct().getName(),
                    item.getNum(), item.getProduct().getUnit(), item.getProduct().getUnitPrice(),
                    item.getAmountAfterDiscount(), item.getAmount().subtract(item.getAmountAfterDiscount()));
        } else {
            System.out.printf("名称：%s，数量：%d%s，单价：%.2f(元)，小计：%.2f(元)\n", item.getProduct().getName(),
                    item.getNum(), item.getProduct().getUnit(), item.getProduct().getUnitPrice(),
                    item.getAmountAfterDiscount() == null ? item.getAmount() : item.getAmountAfterDiscount());
        }
    }

    private void printThreeForTwoItem(LineItem item) {
        if (item.getActivity() != null && item.getActivity() instanceof ThreeForTwoActivity) {
            System.out.printf("名称：%s，数量：%d%s\n", item.getProduct().getName(), item.getNumOffered() ,item.getProduct().getUnit());
        }
    }

}
