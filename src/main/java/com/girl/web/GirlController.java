package com.girl.web;

import com.girl.model.Girl;
import com.girl.persistence.GirlRepository;
import com.girl.service.GirlService;
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
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生 参数型
     * @param name
     * @param cupSize
     * @param age
     * @return
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
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlObject")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.debug(bindingResult.getFieldError());
            logger.error(""+bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * <p>按照年龄查询一个女生</p>
     * <p>自定义</p>
     * <p>minghuiZhang 2017-12-12 23:23:08</p>
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> FindOneByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * <p>更新一个女生</p>
     * <p>使用put方式，要使用x-www-form-urencoded方式，不能使用form-data方式</p>
     * <p>minghuiZhang 2017-12-12 23:15:27</p>
     * @param id
     * @param name
     * @param cupSize
     * @param age
     * @return
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

}

