package com.whh.controller;

import com.whh.domain.Album;
import com.whh.domain.AlbumDetails;
import com.whh.domain.PageBean;
import com.whh.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize, @PathVariable String selectImfor) {
        // 方法逻辑
        PageBean<AlbumDetails> pageBean = albumService.selectAlbumBypageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable Integer id){
        AlbumDetails albumDetails = albumService.selectById(id);
        Integer code = albumDetails != null ? Code.GET_OK : Code.GET_ERR;
        String msg = albumDetails != null ? "" : "数据查询失败，请重试！";
        return new Result(code, albumDetails, msg);
    }

    @GetMapping("/singer/{id}")
    public Result getBydSingerId(@PathVariable Integer id){
        List<AlbumDetails> albumDetailsList = albumService.selectBySingerId(id);
        Integer code = albumDetailsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = albumDetailsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, albumDetailsList, msg);
    }

    @PostMapping
    public Result add(@RequestBody Album album){
        boolean flag = albumService.add(album);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/id/{id}")
    public Result deleteByChoose(@PathVariable Integer id){
        boolean flag = albumService.deleteByChoose(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/ids/{ids}")
    public Result deleteByIds(@PathVariable int[] ids){
        boolean flag = albumService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Album album){
        boolean flag = albumService.update(album);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }

    @PutMapping("/number/{aId}/{number}")
    public Result updateNumber(@PathVariable Integer aId, @PathVariable Integer number){
        boolean flag = albumService.updateNumber(aId, number);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }
}
