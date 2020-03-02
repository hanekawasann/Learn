package com.yukms.learn.tool;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/2 16:30
 */
public class SqlBuilderTest {

    @Test
    public void test_getSaveOrUpdateBatchSql() {
        String ddl = "CREATE TABLE `order` (\n"//
            + "  `id` varchar(50) NOT NULL,\n"//
            + "  `deal_price` decimal(20,4) DEFAULT NULL COMMENT '成交价（货币，元）',\n"//
            + "  `pay_method` varchar(255) DEFAULT NULL COMMENT '付款方式（单选）',\n"//
            + "  PRIMARY KEY (`id`)\n"//
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';";
        SqlBuilder sqlBuilder = new SqlBuilder(ddl);
        String expectedSql = "<insert id=\"saveOrUpdateBatch\" parameterType=\"java.util.List\" keyColumn=\"id\">\n" //
            + "\tINSERT INTO `order`\n" //
            + "\t(\n" //
            + "\t`id`,\n"//
            + "\t`deal_price`,\n"//
            + "\t`pay_method`\n"//
            + "\t)\n"//
            + "\tVALUES\n"//
            + "\t<foreach collection=\"list\" item=\"item\" separator=\",\">\n"//
            + "\t\t(\n" //
            + "\t\t#{item.id},\n"//
            + "\t\t#{item.dealPrice},\n"//
            + "\t\t#{item.payMethod}\n" //
            + "\t\t)\n"//
            + "\t</foreach>\n"//
            + "\tON DUPLICATE KEY UPDATE\n"//
            + "\tdeal_price=VALUES(dealPrice),\n"//
            + "\tpay_method=VALUES(payMethod)\n"//
            + "</insert>";
        Assert.assertEquals(expectedSql, sqlBuilder.getSaveOrUpdateBatchSql());
    }
}