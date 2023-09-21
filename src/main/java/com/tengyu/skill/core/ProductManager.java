package com.tengyu.skill.core;

import java.util.List;

// 1、监控秒杀类商品入库（获取秒杀类商品）
// 2、将商品打散至各集群节点，由单节点分别管理（使用zk 保证集群的稳定性）

// 3、秒杀服务对单节点管理库存进行扣减（前端也不用实时显示当前的库存，用户的关注点一般是是否还有库存。 ）
//  3.1  用户访问A节点，如果A节点库存耗尽，
//  3.2  用户立即重新发起请求，clb可能将请求路由到非A的节点,再重新3.1的步骤
public interface ProductManager<T> {

    List<T> getProduct();


}
