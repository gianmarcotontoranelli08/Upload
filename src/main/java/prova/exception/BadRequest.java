package prova.exception;


public class BadRequest extends Exception {
	
	
private static final long serialVersionUID = 2113763768423144660L;
	private String code;

	public BadRequest(String code,String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
