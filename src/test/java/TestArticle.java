import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.article.service.ArticleService;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.Tarticle;
import com.zs.pms.vo.QueryArticle;


@RunWith(SpringJUnit4ClassRunner.class)//使用Spring测试框架
@ContextConfiguration("classpath:applicationcontext.xml")//引入配置文件
public class TestArticle {
	@Autowired
	ArticleService as;
	
	public void testDeleteById(){
		int id=5;
		try {
			as.deleteById(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDeleteByIds(){
		int[] ids={6,7,8};
		as.deleteByIds(ids);
	}
	
	public void insert(){
		Tarticle tarticle=new Tarticle();
		tarticle.setTitle("少儿节目");
		tarticle.setContent("没能坚持你就不会VB和层成是GV刚吃过翡翠城");
		tarticle.setAuthor("老舍");
		tarticle.setChannel(1);
		tarticle.setIsrecommend(0);
		tarticle.setIshot(1);
		tarticle.setCreatime(new Date());
		try {
			as.insert(tarticle);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testUpdate(){
		Tarticle tarticle=new Tarticle();
		tarticle.setId(102);
		tarticle.setChannel(0);
		tarticle.setAuthor("孔子");
		try {
			as.update(tarticle);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testQueryByCon(){
		QueryArticle query=new QueryArticle();
		query.setAuthor("孔子");
		query.setTitle("少儿节目");
		try {
			List<Tarticle> article = as.queryByCon(query);
			
			System.out.println(article.get(0).getContent());
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testQueryByPage(){
		QueryArticle query=new QueryArticle();
		try {
			System.out.println("当前总页数为"+as.queryByCount(query));
			for (Tarticle tarticle : as.queryByPage(query, 2)) {
				System.out.println(tarticle.getAuthor());
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
