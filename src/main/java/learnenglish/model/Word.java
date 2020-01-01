package learnenglish.model;

public class Word {
	private String eng;
	private String vn;
	private String example;
	private String pronun;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPronun() {
		return pronun;
	}

	public void setPronun(String pronun) {
		this.pronun = pronun;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getVn() {
		return vn;
	}

	public void setVn(String vn) {
		this.vn = vn;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Word(String eng, String vn, String example, String pronun) {
		super();
		this.eng = eng;
		this.vn = vn;
		this.example = example;
		this.pronun = pronun;
	}

	public Word(String eng, String vn, String example, String pronun, String type) {
		super();
		this.eng = eng;
		this.vn = vn;
		this.example = example;
		this.pronun = pronun;
		this.type = type;
	}

	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Word [eng=" + eng + ", vn=" + vn + ", example=" + example + ", pronun=" + pronun + ", type=" + type
				+ "]";
	}
	

}
