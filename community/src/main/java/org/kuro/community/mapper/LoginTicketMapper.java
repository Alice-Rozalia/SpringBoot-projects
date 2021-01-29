package org.kuro.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kuro.community.entity.LoginTicket;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/29 20:21
 */
public interface LoginTicketMapper extends Mapper<LoginTicket> {

    @Select({"select id,user_id,ticket,status,expired from login_ticket where ticket=#{ticket}"})
    LoginTicket findLoginTicketByTicket(@Param("ticket") String ticket);

    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    Integer updateStatus(String ticket, Integer status);

}
