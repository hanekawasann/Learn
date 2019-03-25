package com.yukms.learn.testng.job;

import com.yukms.learn.testng.job.entity.Job;

/**
 * yukms 763803382@qq.com 2019/3/25 15:07
 */
public interface IJobService {

    Job getJobByUserId(int userId);

}
