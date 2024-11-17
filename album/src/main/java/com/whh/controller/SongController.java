package com.whh.controller;

import com.whh.domain.PageBean;
import com.whh.domain.Song;
import com.whh.domain.SongDetails;
import com.whh.domain.User;
import com.whh.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize,
                         @PathVariable(required = false) String selectImfor) {
        PageBean<SongDetails> pageBean = songService.selectSongBypageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }

    @GetMapping("/singer/{id}")
    public Result getBySingerId(@PathVariable Integer id, HttpServletRequest request){
        List<SongDetails> songDetailsList = songService.selectBySingerId(id);
        Integer code = songDetailsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = songDetailsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, songDetailsList, msg);
    }

    @GetMapping("/album/{id}")
    public Result getByAlbumId(@PathVariable Integer id, HttpServletRequest request){
        List<SongDetails> songDetailsList = songService.selectByAlbumId(id);
        Integer code = songDetailsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = songDetailsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, songDetailsList, msg);
    }

    @GetMapping("/song/{id}")
    public Result getBySongId(@PathVariable Integer id){
        SongDetails songDetails = songService.selectSongById(id);
        Integer code = songDetails != null ? Code.GET_OK : Code.GET_ERR;
        String msg = songDetails != null ? "" : "数据查询失败，请重试！";
        return new Result(code, songDetails, msg);
    }


    @GetMapping("/songids/{ids}")
    public Result getByIds(@PathVariable int[] ids, HttpServletRequest request){
        List<SongDetails> songDetailsList = songService.selectByIds(ids);
        Integer code = songDetailsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = songDetailsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, songDetailsList, msg);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Song song){
        boolean flag = songService.add(song);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }


    @DeleteMapping("/id/{id}")
    public Result deleteByChoose(@PathVariable Integer id){
        boolean flag = songService.deleteByChoose(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/ids/{ids}")
    public Result deleteByIds(@PathVariable int[] ids){
        boolean flag = songService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Song song){
        boolean flag = songService.update(song);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }

}
