package learnenglish.model;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class ListManagerPlayer implements Closeable {
	private List<ManagerPlayer> list;

	public List<ManagerPlayer> getList() {
		return list;
	}

	public void setList(List<ManagerPlayer> list) {
		this.list = list;
	}

	@Override
	public void close() throws IOException {
		if(list!=null) {
			int size = list.size();
			for(int i=0;i<size;i++) {
				if(list.get(i)!=null) {
					list.get(i).close();
				}
			}
		}
		
	}
	
}
