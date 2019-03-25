package com.yukms.learn.testng.interview.impl;

import com.yukms.learn.testng.interview.IInterviewService;
import com.yukms.learn.testng.job.IJobService;
import com.yukms.learn.testng.job.entity.Job;
import com.yukms.learn.testng.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * yukms 763803382@qq.com 2019/3/25 15:09
 */
@Service
public class InterviewServiceImpl implements IInterviewService {

    @Autowired
    private IJobService jobService;

    @Override
    public void introduce(User user) {
        System.out.println(user.getName() + " " + user.getAge() + "岁 ");
    }

    @Override
    public void sayJob(User user) {
        Job job = jobService.getJobByUserId(user.getId());
        System.out.println(job.getName() + "desi");
    }

    @Override
    public void sayHobby(User user) {
        System.out.println(user.getHobby());
    }
}
