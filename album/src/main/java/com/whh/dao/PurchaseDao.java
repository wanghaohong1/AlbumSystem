package com.whh.dao;

import com.whh.domain.Purchase;
import com.whh.domain.PurchaseView;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseDao {
    List<PurchaseView> selectPurchaseBypageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("selectImfor")String selectImfor);

    int selectTotalCountByCondition(@Param("selectImfor") String selectImfor);

    List<PurchaseView> selectByUserId(@Param("id") int id);

    PurchaseView selectByBuy(@Param("aId") int aId, @Param("uId") int uId);

    @Insert("INSERT into tb_purchase values (#{user_id},#{alb_id},#{pur_order},#{pur_number},#{pur_time})")
    int addPurchase(Purchase purchase);

    @Delete("delete from tb_purchase where user_id=#{uId} and alb_id=#{aId}")
    int deleteByChoose(@Param("uId") int uId, @Param("aId") int aId);

}
