package org.aqua;

import org.aqua.domain.Cart;

/**
 * 打印接口
 * Created by xyqin on 16/3/3.
 */
public interface Printer {

    /** 打印小票 */
    void printReceipt(Cart cart);

}
