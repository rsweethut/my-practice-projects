package com.ravi.user.service;

import com.ravi.user.VO.Department;
import com.ravi.user.VO.ResponseTemplateVO;
import com.ravi.user.entity.User;
import com.ravi.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        log.info("Inside Service - save User details");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserDetailsWithDeptId(Long userId) {
        log.info("Inside Service - ResponseTemplateVO");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/alldepartments/"+user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
