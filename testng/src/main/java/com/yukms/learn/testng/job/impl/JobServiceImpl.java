package com.yukms.learn.testng.job.impl;

import com.yukms.learn.testng.job.IJobService;
import com.yukms.learn.testng.job.entity.Job;
import org.springframework.stereotype.Service;

/**
 * yukms 763803382@qq.com 2019/3/25 15:09
 */
@Service
public class JobServiceImpl implements IJobService {
    @Override
    public Job getJobByUserId(int userId) {
        if (userId == 0) {
            throw new RuntimeException();
        }
        Job job = new Job();
        job.setId(1);
        job.setName("学生得死");
        job.setAddress("Japan");
        return job;
    }
}
