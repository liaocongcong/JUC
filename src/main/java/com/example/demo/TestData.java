package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/8 15:01
 */
public class TestData {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("A");
        list.add("B");
        list.add("C");

        StringBuilder sql = new StringBuilder();
        sql.append("select log.activity_config_no,log.department_id,");
        // 下发业务员数量 2
        sql.append("(select count(a.id)  from marketing_task_push_salesman_log a where a.activity_config_no=log.activity_config_no and a.department_id=log.department_id) sendSalesman,");
        // 业务员处理数量 3
        sql.append("(select count(distinct a.user_id) from marketing_salesman_generate_poster a where a.department_id = log.department_id and a.activity_config_no = log.activity_config_no and a.create_time>=?1 and a.create_time<=?2) salesmanHandle,");
        // 经销商浏览数 4
        sql.append("(select count(distinct a.open_id) from marketing_dealer_access_log a where a.activity_config_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2) dealerVisit,");
        // 经销商海报数量 5
        sql.append("(select count(distinct a.open_id) from marketing_dealer a where a.activity_config_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2) dealerPoster,");
        // 访问用户数 6
        sql.append("(select count(distinct a.open_id) from um_marketing_activity_request_log a where a.ac_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2) userAccess,");
        // 参与用户数 7
        sql.append("(select count(*) from marketing_user_join_record a where a.channel='1' and  a.activity_config_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2) userJoin,");
        // 领取卡券人数 8
        sql.append("(select count(distinct a.open_id) from marketing_activity_card_receive_record a where a.success = '1'and a.channel='1' and a.activity_config_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2 ) receiveCoupon,");
        // 卡券核销数量 9
        sql.append("(select count(a.open_id) from marketing_activity_card_use_record a where a.channel='1' and a.activity_config_no=log.activity_config_no and a.department_id=log.department_id and a.create_time>=?1 and a.create_time<=?2) couponVerify ");
        sql.append("from ");
        sql.append("(select tk.activity_config_no,tk.department_id from marketing_task_push_salesman_log tk where");
        getIdInCondition(sql,list,"ji");
        System.out.println(sql);
    }

    private static void  getIdInCondition(StringBuilder sql, List<String> objects, String field) {
        if (objects != null && !objects.isEmpty()) {
            sql.append(" ").append(field).append(" in (");
            int size = objects.size();
            for (int i = 0; i < size; i++) {
                if (i < size - 1) {
                    sql.append("'").append(objects.get(i)).append("'").append(",");
                } else {
                    sql.append("'").append(objects.get(i)).append("'").append(") ");
                }
            }
        }
    }
}