package com.whh.service;

import com.whh.domain.*;

import java.util.List;

public interface PurchaseService {
    /**
     * 查询评论视图
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<PurchaseView> selectPurchaseBypageAndCondition(int current, int pageSize, String selectImfor);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    public List<PurchaseView> selectByUserId(int id);

    public PurchaseView selectByBug(int aId, int uId);

    /**
     * 新增订单信息
     * @param purchase
     * @return
     */
    public boolean addPurchase(Purchase purchase);

    /**
     * 删除订单信息
     * @param uId
     * @param aId
     * @return
     */
    public boolean deleteByChoose(int uId, int aId);
}
