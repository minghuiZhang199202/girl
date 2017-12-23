package com.girl;

import com.girl.model.Girl;
import com.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>@author minghuiZhang.</p>
 * <p>description：</p>
 * <p>date: created in 17:09 2017/12/13</p>
 * <p>modified By: </p>
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void FindOneTest(){
        Girl girl = girlService.findOne(2);
        Assert.assertEquals(new Integer(23),girl.getAge());
    }
}
