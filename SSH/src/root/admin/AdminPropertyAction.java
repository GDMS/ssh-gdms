package root.admin;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hibernate.tables.Property;
import hibernate.tables.PropertyDAO;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPropertyAction extends ActionSupport {

	@Autowired
	private PropertyDAO propertyDao;

	private List<Property> properties;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		Iterator<Property> it = properties.iterator();
		while (it.hasNext()) {
			Property p = it.next();
			String key = p.getKey();
			Property p_ = propertyDao.findByKey(key);
			if (p.getValueB() != null) {
				p_.setValueB(p.getValueB());
			} else if (p.getValueD() != null) {
				p_.setValueD(p.getValueD());
			} else {
				p_.setValue(p.getValue());
			}
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String query() throws Exception {
		properties = propertyDao.findAll();
		return SUCCESS;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public void setPropertyDao(PropertyDAO propertyDao) {
		this.propertyDao = propertyDao;
	}
}
