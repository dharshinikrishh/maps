package maps2;

public  class Certificates implements Comparable<Certificates>{
	private String certificateName;
	private String domain;
	
	public Certificates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificates(String certificateName, String domain) {
		super();
		this.certificateName = certificateName;
		this.domain = domain;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificateName == null) ? 0 : certificateName.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificates other = (Certificates) obj;
		if (certificateName == null) {
			if (other.certificateName != null)
				return false;
		} else if (!certificateName.equals(other.certificateName))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		return true;
	}
   
 
	@Override
	public String toString() {
		return "Certificates [certificateName=" + certificateName + ", domain=" + domain + "]";
	}

	@Override
	public int compareTo(Certificates o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
