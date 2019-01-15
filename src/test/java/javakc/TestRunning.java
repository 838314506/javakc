package javakc;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhg.javakc.modules.test.entity.EmpEntity;
import com.zhg.javakc.modules.test.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestRunning {
	
	@Autowired
	private TestService testService;
	
	@Test
	public void tests()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("dpt", 10);
		map.put("result",Types.REF_CURSOR);
		List<EmpEntity> list = testService.select(map);
		for (EmpEntity li : list) {
			System.out.println(li);
		}
	}
	
//	@Autowired
//	private RedisTemplate<String,Serializable> redisTemplate;
	
//	@Test
//	public void tests() 
//	{
		//操作redis中string的对象
//		ValueOperations<String, Serializable> value = redisTemplate.opsForValue();
		//字符串截取
//		System.out.println(value.get("user", 0, 4));
		//value.set("user", "users");
//		 value.append("user", "users");
//		System.out.println(obj.toString());
		
		
//		 Long size = value.size("user");
//		 System.out.println(size);
		//操作redis中hash的对象
//		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		//写入时作为对象写入
//		hash.put("userEntity", "name", "001");
//		List<Object> lists = hash.multiGet();
		
		
		//获取对象中的value值
//		List<Object> values = hash.values("userEntity");
//		values.forEach(x->System.out.println(x));
//		lists.forEach(x->System.out.println(x));
		
		
		//使用获取方法时必须是一个实现了序列化接口的对象
//		Object entity = hash.get("userEntity", "id");
//		System.out.println(entity);
		
		
//		List<Object> list2 = hash.multiGet("userEntity", list);
//		list2.forEach(x->System.out.println(x));
		
		
//		UserEntity entity = new UserEntity();
//		entity.setId("002");
//		entity.setName("002");
//		hash.put("entity", "key1", entity);
		
		
//		Object obj = hash.get("entity", "key1");
//		System.out.println(obj);
		
		
		//此方法是将结果封装到提供给它的集合中，并且按照集合中设置的属性值进行封装与get方法的区别为，可以取出多条
		//集合中可以封装多个类型的数据
//		Collection coll = new ArrayList();
//		coll.add("key1");
//		List list = hash.multiGet("entity", coll);
//		list.forEach(x->System.out.println(x));
//		hash.delete("entity", "key1");
		
		
//		Map<String,Object> map = new HashMap<>();
//		map.put("key1", "001");
//		map.put("key2", "002");
//		hash.putAll("entity", map);
//		System.out.println(hash.size("entity"));
//	}
	
	
	
	
//	@Autowired
//	private ThreadPoolTaskExecutor taskExecutor;
//	
//	@Test
//	public void thread()
//	{
//		
//		taskExecutor.execute( new Runnable()
//		{
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("编号");
//			}
//		});
		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@Autowired
//	private RedisTemplate<Serializable, Serializable> redisTemplate;
//	
//	
//	
//	
//	@Test
//	public void test() {
		// TODO Auto-generated method stub
		//spring-data 获取操作redis的string对象
//		ValueOperations<Serializable, Serializable> string = redisTemplate.opsForValue();
//		string.set("key1", "value1"); 向redis中写入值
		
//		Serializable value = string.get("key1");
//		System.out.println( value ); 从redis中获取值
		
		
//		HashOperations<Serializable, Serializable, Serializable> hash = redisTemplate.opsForHash();
//		Set<Object> set = hash.keys("user");
//		set.forEach( field -> 
//		{
//			System.out.println( field );
//		});  获取所有的key
		
//		List<Object> list = hash.values("user");
//		list.forEach( val ->
//		{
//			System.out.println(val);
//		});
		
//		hash.delete("user", "age");
		
//		Set<Serializable> set = hash.keys("user");
//		set.forEach( field -> 
//		{
//			Serializable o = hash.get("user", field);
//			System.out.println( field+":"+o );
//		});  
		
		
//		ListOperations<Serializable, Serializable>  list = redisTemplate.opsForList();
//		
//		SetOperations<Serializable, Serializable>  set = redisTemplate.opsForSet();
//		
//		ZSetOperations<Serializable, Serializable> zset = redisTemplate.opsForZSet();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//通过模板获取操作 String对象
//		ValueOperations<Serializable, Serializable> value = redisTemplate.opsForValue();
		
		//向String中添加值
		//value.set("userName", "admin");
		
		//从String中获取值
		//Serializable val = value.get("userName");
		//System.out.println( val );
		
//		Collection<Serializable> collection = new ArrayList<Serializable>();
//		collection.add("userName");
//		collection.add("name");
//		
//		List<Serializable> list = value.multiGet(collection);
//		list.forEach( l ->
//		{
//			System.out.println(l);
//		});
		
//		value.setBit(key, offset, value)
//		value.getBit(key, offset)
		
		
		//通过模板获取操作 Hash对象
//		HashOperations<Serializable, Object, Object> hash = redisTemplate.opsForHash();
		
		//通过模板获取操作 List对象
		//ListOperations<Serializable, Serializable> list = redisTemplate.opsForList();
		
		//通过模板获取操作 Set对象
		//SetOperations<Serializable, Serializable> set = redisTemplate.opsForSet();
		
		//通过模板获取操作 ZSet对象
		//ZSetOperations<Serializable, Serializable>  zset = redisTemplate.opsForZSet();
		
//	}

}
