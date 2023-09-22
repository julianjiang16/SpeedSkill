package com.tengyu.skill.core;

import com.google.common.collect.Maps;
import com.tengyu.skill.atomic.Stock;

import java.util.List;
import java.util.Map;

public class DefaultProductManager<P> implements ProductManager<P> {

    Map<P, Stock> manager = Maps.newHashMap();

    @Override
    public List getProduct() {
        return null;
    }

    @Override
    public long getProductCnt(P p) {
        return manager.get(p).getStock();
    }

    @Override
    public boolean saleProduct(P p) {
        final Stock stock = manager.get(p);
        if (stock.lock(1)) {
            // ...  stock.unlock()  or stock.increase()

            return true;
        }
        return false;
    }

    @Override
    public void applyProductStock(P p, long stock) {

        final Stock productStock = manager.get(p);

        if (productStock.decrease(stock)) {
            // ...
            return;
        }

    }
}
