package com.gzj.express_transportation.controller;
import com.gzj.express_transportation.entity.Positions;
import com.gzj.express_transportation.service.PositionsService;
import com.gzj.express_transportation.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/positions")
public class PositionsController {
    @Autowired
    private PositionsService positionsService;

    /**
     * 根据主键删除
     * 要求转入 aId
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id) {
        try {

            return positionsService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象positions
     *
     * @param positions
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Positions positions) {
        try {
            return positionsService.insert(positions) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }

    }

    /**
     * 根据主键查找对象  最多只能返回一个对象
     *
     * @param id
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id) {
        try {
            Positions positions1 = positionsService.selectByPrimaryKey(id);
            if (positions1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(positions1);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        try {
            List<Positions> list = positionsService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 根据主键修改全部字段
     *
     * @param positions
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Positions positions) {
        try {
            return positionsService.updateByPrimaryKey(positions) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    
    
     /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String waybillNo) {
        try {
            PageHelper.startPage(page, limit);
            List<Positions> list = positionsService.selectPage(waybillNo);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, positionsService.count(waybillNo));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
