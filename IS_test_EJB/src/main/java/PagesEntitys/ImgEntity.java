package PagesEntitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImgEntity
 *
 */
@Entity

public class ImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ImgEntity() {
	}
	@Id @GeneratedValue
	private Long imgEntityId;
	private String src;
	public Long getImgEntityId() {
		return imgEntityId;
	}
	public void setImgEntityId(Long imgEntityId) {
		this.imgEntityId = imgEntityId;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
