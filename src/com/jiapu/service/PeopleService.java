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
	public int addPeople(People p) throws Exception{
		return peopleDao.addPeople(p);
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
		return peopleDao.delPeople(p);
	}
	
	public List<People> queryAllPeople(People people) throws Exception{
		return peopleDao.queryAllPeople(people);
	}
	public List queryPeoplesForTree(People people) throws Exception{
		List<People> pl = this.queryAllPeople(people);
		People tempP = pl.get(0);
		List res = new ArrayList();
		Map pm = new HashMap();
		pm.put(DataConstant.name, tempP.getName());
		pm.put(DataConstant.value, tempP.getId());
		pm.put(DataConstant.symbolSize, new int[]{90,70});
		pm.put(DataConstant.children, new ArrayList());
//		res.add(pm);
		
		System.out.println("前=" + tempP);
		this.getSons(pl, tempP);
		System.out.println("后=" + tempP);
		TreeObj to = this.peopleToTreeObj(tempP);
		System.out.println("to="+to);
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
		to.value = p.getId();
		for(People tempP : p.getChildren()){
			to.children.add(this.peopleToTreeObj(tempP));
		}
		return to;
	}
}
