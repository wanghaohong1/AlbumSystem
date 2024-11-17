package com.whh.controller;

import com.whh.domain.PageBean;
import com.whh.domain.Singer;
import com.whh.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singers")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize, @PathVariable String selectImfor) {
        PageBean<Singer> pageBean = singerService.selectSingerBypageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable int id){
        Singer singer = singerService.selectById(id);
        Integer code = singer != null ? Code.GET_OK : Code.GET_ERR;
        String msg = singer != null ? "" : "数据查询失败，请重试！";
        return new Result(code, singer, msg);
    }

    @PostMapping
    public Result add(@RequestBody Singer singer){
        boolean flag = singerService.add(singer);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/id/{id}")
    public Result deleteByChoose(@PathVariable int id){
        boolean flag = singerService.deleteByChoose(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/ids/{ids}")
    public Result deleteByIds(@PathVariable int[] ids){
        boolean flag = singerService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Singer singer){
        boolean flag = singerService.update(singer);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }
}
