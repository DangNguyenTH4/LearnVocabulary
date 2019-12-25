package LearnEnglish;

import org.apache.commons.lang3.StringUtils;

public class SaveWordFactory {
	private static SaveWordOffline swOffline;
	private static SaveWordOnline swOnline;
	private static SaveWord sw;
	
	private SaveWordFactory() {
		
	}
	
	public static SaveWord getInstance() {
		String placeFile = ReadProperties.getProperty("placeToStudy");
		if("online".equals(StringUtils.trim(placeFile))) {
			System.out.println("Online Saveword init");
			if(swOnline==null) {
				swOnline=new SaveWordOnline();
			}
			return swOnline;
		}
		else if("offline".equals(StringUtils.trim(placeFile))) {
			System.out.println("Offline Saveword init");
			if(swOffline==null) {
				swOffline=new SaveWordOffline();
			}
			return swOffline;
		}
		else {
			System.out.println("No on-off init");
			if(sw==null) {
				sw=new SaveWord() {
					
					@Override
					public String getMethodLearn() {
						// TODO Auto-generated method stub
						return "";
					}
				};
			}
			return sw;
		}
	}
}
