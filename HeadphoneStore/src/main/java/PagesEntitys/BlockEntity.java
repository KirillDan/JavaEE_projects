package PagesEntitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BlockEntity
 *
 */
@Entity

public class BlockEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public BlockEntity() {
	}
	@Id @GeneratedValue
	private Long blockEntityId;
	private String number;
	@OneToMany
	Set<BlockEntity> blockEntitySet;
	@OneToMany
	Set<ElementEntity> elementEntitySet;
	
	public Long getBlockEntityId() {
		return blockEntityId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	///////////////element
	public Set<ElementEntity> getElementEntitySet() {
 	    return elementEntitySet;
 	}

	public void setElementEntitySet(Set<ElementEntity> elementEntitySet) {
	    this.elementEntitySet = elementEntitySet;
	}
	public ElementEntity addElementEntity(ElementEntity elementEntity) {
	      if (elementEntitySet == null) {
	    	  elementEntitySet = new LinkedHashSet<ElementEntity>();
	      }
	      elementEntitySet.add(elementEntity);
	      return elementEntity;
	}
   /////////////////////block
	public Set<BlockEntity> getBlockEntitySet() {
 	    return blockEntitySet;
 	}

	public void setBlockEntitySet(Set<BlockEntity> blockEntitySet) {
	    this.blockEntitySet = blockEntitySet;
	}
	public BlockEntity addBlockEntity(BlockEntity blockEntity) {
	      if (blockEntitySet == null) {
	    	  blockEntitySet = new LinkedHashSet<BlockEntity>();
	      }
	      blockEntitySet.add(blockEntity);
	      return blockEntity;
	}
	////////////////Block
	public BlockEntity getBlockEntity(String number) {
		//return this.blockEntitySet.stream().filter((n) -> (n.getNumber() == number));
		for(BlockEntity be : this.blockEntitySet) {
			if(be.getNumber().equals(number)) {return be;}
		}
		return null;
	}
	/////////////////Element
	public ElementEntity getElementEntity(String number) {
		//return this.blockEntitySet.stream().filter((n) -> (n.getNumber() == number));
		for(ElementEntity ee : this.elementEntitySet) {
			if(ee.getNumber().equals(number)) {return ee;}
		}
		return null;
	}
}
