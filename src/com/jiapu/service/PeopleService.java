package com.jiapu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiapu.dao.PeopleDao;
import com.jiapu.entity.DataConstant;
import com.jiapu.entity.People;
import com.jiapu.entity.TreeObj;
import com.utils.StrUtil;
@Transactional
@Service
public class PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	/**
	 * @Description:新增一个用户 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public int addPeople(People p, String addType) throws Exception{
		if(addType.equals("up")){
			String id_fid = p.getFid();
			String id = StrUtil.getUUID();
			//新增父节点
			p.setFid(id_fid.substring(id_fid.indexOf("_")+1));
			p.setId(id);
			peopleDao.addPeople(p);
			//更新当前节点
			People tempP = new People();
			tempP.setId(id_fid.substring(0, id_fid.indexOf("_")));
			tempP.setFid(id);
			return peopleDao.upPeople(tempP);
		}else{
			p.setId(StrUtil.getUUID());
			p.setFid(p.getFid().substring(0, p.getFid().indexOf("_")));
			return peopleDao.addPeople(p);
		}
	}
	/**
	 * @Description:删除 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public int delPeople(People p) throws Exception{
		p.setId(p.getId().substring(0, p.getId().indexOf("_")));
		return peopleDao.delPeople(p);
	}
	/**
	 * @Description:查询一个people 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return People  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public People queryOnePeople(People p) throws Exception{
		return peopleDao.queryOnePeople(p);
	}
	
	public List<People> queryAllPeople(People people) throws Exception{
		return peopleDao.queryAllPeople(people);
	}
	public List queryPeoplesForTree(People people) throws Exception{
		List<People> pl = this.queryAllPeople(people);
		People tempP = pl.get(0);
		List res = new ArrayList();
//		System.out.println("前=" + tempP);
		this.getSons(pl, tempP);
//		System.out.println("后=" + tempP);
		TreeObj to = this.peopleToTreeObj(tempP);
//		System.out.println("to="+to);
		res.add(to);
		return res;
	}
	private void getSons(List<People> pl, People p) throws Exception{
		List res = new ArrayList();
		for(People tp:pl){
			if(tp.getFid()!=null && tp.getFid().equals(p.getId())){
				this.getSons(pl, tp);
				p.getChildren().add(tp);
//				pl.remove(tp);//这里有错，不能遍历的同时又修改这个链表
			}
		}
	}
	private TreeObj peopleToTreeObj(People p) throws Exception{
		TreeObj to = new TreeObj();
		to.name = p.getName();
		to.value = p.getId() + "_" + p.getFid();
		for(People tempP : p.getChildren()){
			to.children.add(this.peopleToTreeObj(tempP));
		}
		return to;
	}
	/**
	* 基本功能：更新
	* 编    者：潘宜奎
	* 完成日期：2015年11月14日
	* 修改内容：
	* @param 
	* @return 
	* @throws
	 */
	public int upPeople(People p, String upType) throws Exception{
		return peopleDao.upPeople(p, upType);
	}
}
