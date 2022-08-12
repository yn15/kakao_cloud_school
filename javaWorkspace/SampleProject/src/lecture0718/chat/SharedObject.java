package lecture0718.chat;

import java.util.ArrayList;
import java.util.List;

public class SharedObject {
	
	List<ClientRunable> clients = new ArrayList<ClientRunnable>();
	
	public synchronized void broadcast(String msg) {
		clients.stream().forEacht(t -> {
			
		});
	}
}
