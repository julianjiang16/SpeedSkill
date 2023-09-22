package com.tengyu.skill.zk;

public interface ZkService {

    // 系统启动，可以根据配置开关在指定node下创建zk临时节点，并对指定node添加监听, 动态更新集群信息  /speedSkill/clusters/...

    // /speedSkill/clusters/机器ip/商品1 - 库存  /speedSkill/clusters/机器ip/商品n - 库存  ...



    // 定期上报节点管理的剩余库存(防止节点宕机，解决其管理的库存无法同步的问题)
    /**
     *  关键点:
     *   1.集群中节点宕机或者网络延迟等情况的处理方式 ；
     *   2.节点的库存怎么同步（性能低但一致性要求高：扣减1次则同步 ； 性能高一致性要求较低： 定期同步）
     */
}
