package hibernate.tables;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String msgToStu;
	private String msgToTea;
	private String msgToAll;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String msgToStu, String msgToTea, String msgToAll) {
		this.msgToStu = msgToStu;
		this.msgToTea = msgToTea;
		this.msgToAll = msgToAll;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsgToStu() {
		return this.msgToStu;
	}

	public void setMsgToStu(String msgToStu) {
		this.msgToStu = msgToStu;
	}

	public String getMsgToTea() {
		return this.msgToTea;
	}

	public void setMsgToTea(String msgToTea) {
		this.msgToTea = msgToTea;
	}

	public String getMsgToAll() {
		return this.msgToAll;
	}

	public void setMsgToAll(String msgToAll) {
		this.msgToAll = msgToAll;
	}

}