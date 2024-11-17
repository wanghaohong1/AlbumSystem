package com.whh.service.impl;

import com.whh.dao.AlbumDao;
import com.whh.dao.PurchaseDao;
import com.whh.domain.*;
import com.whh.service.AlbumService;
import com.whh.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public PageBean<PurchaseView> selectPurchaseBypageAndCondition(int current, int pageSize, String selectImfor) {
        if(selectImfor.equals("null")){
            selectImfor = "";
        }
        if(selectImfor != null && selectImfor.length()>0){
            selectImfor = "%"+selectImfor+"%";
        }
        //计算开始索引
        int begin = (current-1)*pageSize;
        //计算查询条目数
        int size = pageSize;
        List<PurchaseView> rows = purchaseDao.selectPurchaseBypageAndCondition(begin, size, selectImfor);
        System.out.println(rows);
        //查询总记录数
        int totalCount = purchaseDao.selectTotalCountByCondition(selectImfor);

        PageBean<PurchaseView> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public List<PurchaseView> selectByUserId(int id){
        return purchaseDao.selectByUserId(id);
    }

    @Override
    public PurchaseView selectByBug(int aId, int uId) {
        return purchaseDao.selectByBuy(aId, uId);
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        return purchaseDao.addPurchase(purchase)>0;
    }

    @Override
    public boolean deleteByChoose(int uId, int aId) {
        return purchaseDao.deleteByChoose(uId, aId)>0;
    }

}
