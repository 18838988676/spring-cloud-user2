package cn.com.controller;


import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;







import cn.com.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
	 //服务发现客户端
	 @Autowired
	 private DiscoveryClient discoveryClient=null;
	 
	 //获取用户信息
	 @GetMapping("/user/{id}")
	 public User getUserPo(@PathVariable("id") Integer id) {
		 	ServiceInstance serviceInstance= discoveryClient.getInstances("WMCUSER").get(0);
		 	logger.error("serviceInstance.getUri():"+serviceInstance.getUri());
		 	logger.error("serviceInstance.getUri():"+serviceInstance.getHost());
		 	logger.error("serviceInstance.getUri():"+serviceInstance.getUri());
		 	User userPo=new User();
		 	userPo.setId(id);
		 	userPo.setLevel((int) (id%2+1));
		 	userPo.setUserName("user_name_"+id);
		 	userPo.setNote("note_"+id);
		 	return userPo;
	 }
	 
	
	 @PostMapping("/addUser")
	 public Map<String, Object> addUser(@RequestBody User user){
		 Map<String, Object> map=new HashedMap();
		 map.put("msg2", "添加用户信息详情如下："+user+"，添加成功");
		 return map;
	 }
	 
	 //获取用户信息
	 @GetMapping("/user333")
	 public Map<String, Object> findById() {
		 Integer id=000;
		 Map<String, Object> map=new HashedMap();
		 	User userPo=new User();
		 	userPo.setId(id);
		 	userPo.setLevel((int) (id%2+1));
		 	userPo.setUserName("利用feign提供的声明是方法调用，并根据用户id："+id);
		 	userPo.setNote("note_"+id);
		 	map.put("msg", "根据用户id，获得用户信息如下："+userPo);
		 	return map;
	 }

}
