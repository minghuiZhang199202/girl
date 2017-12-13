package com.zmh.girl.service;

import com.zmh.girl.model.Girl;
import com.zmh.girl.persistence.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>@author minghuiZhang.</p>
 * <p>description：</p>
 * <p>date: created in 8:43 2017/12/13</p>
 * <p>modified By: </p>
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * <p>description：插入两个girl</p>
     * <p>            </p>
     * @param
     * @author: minghuiZhang.
     * @date: created in 9:01 2017/12/13
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveTwo(){

        Girl girlA  = new Girl();
        girlA.setName("李艳");
        girlA.setAge(24);
        girlA.setCupSize("A");
        Girl girlB  = new Girl();
        girlB.setName("肖华");
        girlB.setAge(27);
        girlB.setCupSize("CC");
        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }
}
