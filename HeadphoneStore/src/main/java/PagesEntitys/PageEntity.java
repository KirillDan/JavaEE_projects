package PagesEntitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PageEntity
 *
 */
@Entity

public class PageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public PageEntity() {
	}
	@Id @GeneratedValue
	private Long pageEntityId;
	private String name;
	@OneToMany
	Set<BlockEntity> blockEntitySet;
	
	public Long getPageEntityId() {
		return pageEntityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	////////////////
	public Set<BlockEntity> getBlockEntitySet() {
 	    return blockEntitySet;
 	}
	public void setBlockEntitySet(Set<BlockEntity> blockEntitySet) {
	    this.blockEntitySet = blockEntitySet;
	}
	public BlockEntity addBlockEntity(BlockEntity blockEntity) {
	      if (blockEntitySet == null) {
	    	  blockEntitySet = new HashSet<BlockEntity>();
	      }
	      blockEntitySet.add(blockEntity);
	      return blockEntity;
	}
	public BlockEntity getBlockEntity(String number) {
		//return this.blockEntitySet.stream().filter((n) -> (n.getNumber() == number));
		for(BlockEntity be : this.blockEntitySet) {
			if(be.getNumber().equals(number)) {return be;}
		}
		return null;
	}
}
