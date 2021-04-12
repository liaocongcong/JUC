package com.example.demo.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Stream.Person;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.*;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/3/19 14:39
 */
public class JsonTest {

    public static void main(String[] args) {

        Person Person = new Person();
        Person.setAge(00);
        Person.setName("tom");
        Person.setSex("男");
        Person.setSalary(90);

        Person Person1 = new Person();
        Person1.setAge(00);
        Person1.setName("tom");
        Person1.setSex("男");
        Person1.setSalary(90);

       /* Map<String,Person> maps = new HashMap<>();
        maps.put("1",Person);
        maps.put("2",Person1);*/

        List<Person> PersonList = new ArrayList<>();
        //new JSONArray(PersonList);
       // parseObject(json,PersonList);
       String jsons= JSONObject.toJSONString(Person1);
       System.out.println(jsons);
        //System.out.println("maps: -"+ toJSONString(maps));

        Person o = parseObject(jsons, Person.class);
        System.out.println(o.toString());

        JSONObject jsonObject = parseObject(jsons);
        System.out.println(jsonObject);




        /**
         *   一.  将json数据解析，获得具体的值
         */

       // 解析多层嵌套数据：


        /*val str = "{\"error\":200,\"msg\":null,\"tianPerson_api_agentn_fenqiscorev10_response\":{\"tags\":{\"150\":0,\"151\":0,\"152\":0,\"153\":0,\"154\":0,\"110\":0,\"111\":0,\"112\":1,\"113\":0,\"114\":0,\"115\":0,\"116\":0,\"117\":0,\"118\":0,\"119\":3,\"161\":3,\"162\":1,\"120\":0,\"121\":5,\"122\":0,\"123\":0,\"124\":0,\"125\":2,\"5\":\"android\",\"126\":0,\"127\":4,\"128\":0,\"129\":0,\"130\":0,\"131\":0,\"132\":0,\"133\":0,\"134\":0,\"135\":0,\"136\":0,\"137\":0,\"138\":0,\"139\":0,\"140\":3,\"141\":0,\"142\":5,\"143\":3,\"144\":0,\"101\":0,\"145\":6,\"102\":1,\"146\":0,\"103\":1,\"147\":0,\"148\":0,\"104\":0,\"149\":0,\"105\":3,\"106\":5,\"107\":0,\"108\":2,\"109\":2,\"credit_score\":457},\"biz_id\":\"2589e393-004d-4b37-b0ab-23455c4bbde2\",\"req_id\":\"15422508480665693989\"},\"request_id\":\"15422508480517778031\"}"
        //将字符串转为jsonobject
        val json: JSONObject =JSON.parseObject(str)

        //根据key获得值并获得一个jsonobject
        val tj: JSONObject =json.getJSONObject("tianPerson_api_agentn_fenqiscorev10_response")

        //根据上一个jsonobject获得对应key的value
        val tag=tj.getJSONObject("tags")

        //获取多级嵌套json的具体key的value
        val result=tag.getString("150")

        println(result)*/


    }

   /* public static String setList(){

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        JSONArray.toJSONStringWithDateFormat(list);
        return ;
    }*/

}