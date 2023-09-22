package com.tengyu.skill.core;

import java.util.List;

// 1、监控秒杀类商品入库（获取秒杀类商品）
// 2、将商品打散至各集群节点，由单节点分别管理（使用zk 保证集群的稳定性）

// 3、秒杀服务对单节点管理库存进行扣减（前端也不用实时显示当前的库存，用户的关注点一般是是否还有库存。
//      注： 需要考虑偏移的问题，部分节点库存卖完，部分节点还未卖完，是否需要将请求路由到其他节点【zk会保存其他节点】）
//  3.1  用户访问A节点，如果A节点库存耗尽，
//  3.2  用户立即重新发起请求，clb可能将请求路由到非A的节点,再重新3.1的步骤
public interface ProductManager<P> {

    List<P> getProduct();


    long getProductCnt(P p);

    boolean saleProduct(P p);

    void applyProductStock(P p,long stock);
}
