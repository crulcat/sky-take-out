package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from sky_take_out.employee where username = #{username}")
    Employee getByUsername(String username);
    @Insert("insert into sky_take_out.employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) values (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);

     Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    @Update("update sky_take_out.employee set status = case when employee.status = 1  then 0 ELSE 1 END where id = #{id}")
    void setStatus(Long id);
    @Select("select * from sky_take_out.employee where id = #{id}")
    Employee getById(Long id);

    void update(EmployeeDTO employeeDTO);
}
