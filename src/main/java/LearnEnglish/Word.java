package LearnEnglish;

import org.apache.commons.lang3.StringUtils;

public class Word {
	private String eng;
	private String vn;
	private String example;
	private String pronun;

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
		this.eng = StringUtils.upperCase(eng);
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
		this.eng = StringUtils.upperCase(eng);
		this.vn = vn;
		this.example = example;
		this.pronun=pronun;
	}

	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}

}
