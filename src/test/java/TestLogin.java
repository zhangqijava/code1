import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TdeptPO;
import com.zs.pms.po.Tpermission;
import com.zs.pms.po.TuserPO;
import com.zs.pms.service.UserService;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryPage;
import com.zs.pms.vo.queryUser;

@RunWith(SpringJUnit4ClassRunner.class)//使用Spring测试框架
@ContextConfiguration("classpath:applicationcontext.xml")//引入配置文件
public class TestLogin {
@Autowired
UserService us;

	public void testlogin(){
		queryUser query=new queryUser();
		query.setLoginname("test1");
		query.setPassword("123");
		try {
			TuserPO user = us.chkLogin(query);
			System.out.println(user.getRealname()+","+user.getDep().getDname());
			
			
			for (Tpermission permission : user.getPermissions()) {
				System.out.println(permission.getPname());
				
				
			}
			System.out.println("---------------整理好的----------------------");
			for (Tpermission per1 : user.getMenu()) {
				System.out.println(per1.getPname());
				for (Tpermission per2 : per1.getChildren()) {
					System.out.println("\t\t"+per2.getPname());
				}
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void testdeleteIds(){
		int[] ids={1234,1235,1236};
		us.deleteByIds(ids);
	}
	
	public void testupdate(){
		TuserPO user=new TuserPO();
		user.setId(1237);
		user.setEmail("qwe123@163.com");
		TdeptPO dep=new TdeptPO();
		try {
			us.update(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testQueryByCon(){
		queryUser query=new queryUser();
		query.setPage(2);
	
		try {
			us.queryByCon(query);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testInsert(){
		TuserPO user=new TuserPO();
		user.setBirthday(new Date());
		TdeptPO dep=new TdeptPO();
		dep.setId(6);
		user.setDep(dep);
		user.setLoginname("test12345");
		user.setCreator(1003);
		user.setCreatime(new Date());
		user.setEmail("12345345@qq.com");
		user.setPassword("4312");
		user.setSex("女");
		user.setPic("123.jpg");
		user.setRealname("测试员12");
		try {
			us.insert(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testDelete(){
		int id=103;
		try {
			us.deleteById(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void queryByPage(){
		queryUser query=new queryUser();
		
		System.out.println("当前总页数为"+us.queryByCount(query));
		for (TuserPO user : us.queryByPage(query, 2)) {
			System.out.println(user.getRealname());
		}
	}
}
