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
            + "\t`deal_price`=VALUES(`deal_price`),\n"//
            + "\t`pay_method`=VALUES(`pay_method`)\n"//
            + "</insert>";
        Assert.assertEquals(expectedSql, sqlBuilder.getSaveOrUpdateBatchSql());
    }

    @Test
    public void test_() {
        String ddl = "CREATE TABLE `order_action` (\n" +
            "  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水号ID',\n" +
            "  `order_status` varchar(50) DEFAULT NULL COMMENT '订单状态',\n" +
            "  `payment_status` int(10) unsigned DEFAULT NULL COMMENT '支付单状态',\n" +
            "  `reason` varchar(255) DEFAULT NULL,\n" + "  `action_note` varchar(255) DEFAULT NULL COMMENT '操作备注',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '操作时间',\n" +
            "  `order_id` varchar(50) DEFAULT NULL COMMENT '订单号',\n" +
            "  `handler_type` varchar(45) DEFAULT NULL COMMENT '处理人类型：系统，买家，各种角色',\n" +
            "  `handler_name` varchar(45) DEFAULT NULL COMMENT '处理人名称',\n" +
            "  `operator` varchar(255) DEFAULT NULL,\n" + "  `type` varchar(50) DEFAULT NULL COMMENT '操作类型',\n" +
            "  PRIMARY KEY (`id`),\n" + "  KEY `order_sn_index` (`order_id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1233281076369743874 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;";
        System.out.println(new SqlBuilder(ddl).getSaveOrUpdateBatchSql());
    }
}