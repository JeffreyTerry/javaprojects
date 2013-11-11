package Daniel;

import java.io.Serializable;

public class AcademicOutlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private String organizationName;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
}
