package com.blyx.fs.domain.testService.impl;

import com.blyx.fs.domain.testRepository.TestRepos;
import com.blyx.fs.domain.testService.TestDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
@Service
public class TestDomainImpl implements TestDomain {

    @Autowired
    private TestRepos testRepos;


    @Override
    public void test() {
        testRepos.test();
    }
}
