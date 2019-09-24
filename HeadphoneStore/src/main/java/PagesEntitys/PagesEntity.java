package PagesEntitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import Entitys.OrderEntity;

/**
 * Entity implementation class for Entity: Pages
 *
 */
@Entity
public class PagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public PagesEntity() {
	}

	@Id @GeneratedValue
	private Long pagesEntityId;
	@OneToMany
	Set<PageEntity> pageset;
	
	public Long getPagesEntityId() {
		return pagesEntityId;
	}
	public Set<PageEntity> getPageset() {
 	    return pageset;
 	}

	public void setPageset(Set<PageEntity> pageset) {
	    this.pageset = pageset;
	}
	public PageEntity addPageEntity(PageEntity pageEntity) {
	      if (pageset == null) {
	    	  pageset = new HashSet<PageEntity>();
	      }
	      pageset.add(pageEntity);
	      return pageEntity;
	}
   
}
