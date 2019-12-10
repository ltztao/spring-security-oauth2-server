package com.example.oauth2.mapper;

import com.example.oauth2.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {


    @Select("select permission_abbr from xb_permission as xp "
            + " left join role_relation_permission as rrp on xp.permission_id = rrp.permission_id"
            + " left join user_relation_role as urr on urr.role_id=rrp.role_id"
            + " where urr.user_id = #{userId};")
    List<Permission> findPermissionByUserId(int userId);

}
