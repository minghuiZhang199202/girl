package com.girl.web;

import com.girl.model.Girl;
import com.girl.model.Result;
import com.girl.persistence.GirlRepository;
import com.girl.service.GirlService;
import com.sun.javafx.iio.gif.GIFDescriptor;
import com.zmh.utils.ResultUtil;
import com.zmh.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>@author minghui_zhang </p>
 * <p>description   </p>
 * <p>date  created in  22:41 / 2017/12/12</p>
 * <p>modified by   </p>
 */
@RestController
public class GirlController extends BaseController{
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生
     * minghuiZhang 2017-12-12 22:56:10
     * @return 返回所有女生
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生 参数型
     * @param name 姓名
     * @param cupSize 罩杯大小
     * @param age 年龄
     * @return 返回一个女生
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("name")String name,@RequestParam("cupSize")String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setName(name);
        return girlRepository.save(girl);
    }

    /**
     * 添加一个女生 对象型
     * <p>加入表单验证功能，年龄不能小于18岁</p>
     * @param girl 女生对象
     * @return 返回添加后的女生
     */
    @PostMapping(value = "/girlObject")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            this.logger.info(bindingResult.getFieldError().toString());
            return ResultUtil.failure(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return  ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找一个女生
     * @param id 女生id
     * @return 返回查询女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * <p>按照年龄查询一个女生</p>
     * <p>自定义</p>
     * <p>minghuiZhang 2017-12-12 23:23:08</p>
     * @param age 年龄
     * @return 返回age年龄下的所有女生
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findOneByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * <p>更新一个女生</p>
     * <p>使用put方式，要使用x-www-form-urencoded方式，不能使用form-data方式</p>
     * <p>minghuiZhang 2017-12-12 23:15:27</p>
     * @param id 女生id
     * @param name 姓名
     * @param cupSize 罩杯大小
     * @param age 年龄
     * @return 返回修改之后的女生
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name")String name,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
         girlRepository.delete(id);
    }

    @PostMapping(value = "/girls/two")
    public void girlAddTwo(){
        girlService.saveTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }
}

