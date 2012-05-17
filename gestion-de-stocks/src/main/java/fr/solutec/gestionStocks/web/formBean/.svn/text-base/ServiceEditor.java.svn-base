package fr.solutec.gestionStocks.web.formBean;

import java.beans.PropertyEditorSupport;

import fr.solutec.gestionStocks.bean.Service;
import fr.solutec.gestionStocks.service.IServiceManager;

/**
 * @author achankimponne
 * 
 */
public class ServiceEditor extends PropertyEditorSupport {

	private IServiceManager serviceManager;

	public ServiceEditor(IServiceManager serviceManager) {
		super();
		this.setServiceManager(serviceManager);
	}

	/**
	 * Format a String to a service
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		Integer id = null;
		Service service = null;

		this.setValue(null);

		if (text != null && text.length() > 0) {
			try {

				id = new Integer(text);
			} catch (NumberFormatException nfe) {
				throw new IllegalArgumentException(
						"wrong argument: id=" + text, nfe);
			}
			service = serviceManager.getServiceById(id);

			if (service != null) {
				this.setValue(new ServiceFormBean(service));
			}
		}

	}

	public String getAsText() {

		String id = null;

		Object value = getValue();

		if (value == null) {
			return null;
		}

		if (value instanceof ServiceFormBean) {
			ServiceFormBean serviceInfoData = (ServiceFormBean) this.getValue();
			if (serviceInfoData != null && serviceInfoData.getId() != null) {
				id = serviceInfoData.getId().toString();
			}

		} else if (value instanceof Integer) {

			return value.toString();
		}

		else {

			throw new java.lang.IllegalArgumentException("Expecting a "
					+ ServiceFormBean.class.getName() + " class, got "
					+ value.getClass().getName());
		}

		return id;
	}

	/**
	 * @return the serviceManager
	 */
	public IServiceManager getServiceManager() {
		return serviceManager;
	}

	/**
	 * @param serviceManager
	 *            the serviceManager to set
	 */
	public void setServiceManager(IServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

}