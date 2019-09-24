package PagesEntitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: txtEntity
 *
 */
@Entity

public class TxtEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public TxtEntity() {
	}
	@Id @GeneratedValue
	private Long txtEntityId;
	private String text;
	
	public Long getTxtEntityId() {
		return txtEntityId;
	}
	public void setTxtEntityId(Long txtEntityId) {
		this.txtEntityId = txtEntityId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
