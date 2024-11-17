package com.whh.controller;

import com.whh.domain.*;
import com.whh.service.CommentService;
import com.whh.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize,
                         @PathVariable(required = false) String selectImfor){
        PageBean<PurchaseView> pageBean = purchaseService.selectPurchaseBypageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }

    @GetMapping("/user/{id}")
    public Result getByUserId(@PathVariable int id, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<PurchaseView> purchaseViewList = purchaseService.selectByUserId(user.getUser_id());
        Integer code = purchaseViewList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = purchaseViewList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, purchaseViewList, msg);
    }

    @GetMapping("/buy/{aId}")
    public Result getByBuy(@PathVariable int aId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        PurchaseView purchase = purchaseService.selectByBug(aId, user.getUser_id());
        Integer code = purchase != null ? Code.GET_OK : Code.GET_ERR;
        String msg = purchase != null ? "" : "数据查询失败，请重试！";
        return new Result(code, purchase, msg);
    }

    @PostMapping
    public Result addPurchase(@RequestBody Purchase purchase){
        boolean flag = purchaseService.addPurchase(purchase);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @PostMapping("/user")
    public Result UseraddPurchase(@RequestBody Purchase purchase, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        purchase.setUser_id(user.getUser_id());
        String order = user.getUser_id() + "" + purchase.getAlb_id();
        purchase.setPur_order(order);
        boolean flag = purchaseService.addPurchase(purchase);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/id/{uId}/{aId}")
    public Result deleteByChoose(@PathVariable Integer uId, @PathVariable Integer aId){
        boolean flag = purchaseService.deleteByChoose(uId, aId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }
}
