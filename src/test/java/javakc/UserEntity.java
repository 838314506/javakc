package javakc;

import java.io.Serializable;
/**
 * 用于测试redis的对象
 * @author lzz
 *
 */
public class UserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6547962434759310702L;
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + "]";
	}
	
}
