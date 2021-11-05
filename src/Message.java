
public class Message {
	private User to;
	private User from;
	private String dateSent;
	
	public Message(User _to, User _from, String _sendDate) {
		this.to = _to;
		this.from = _from;
		this.dateSent = _sendDate;
	}
	
	public User getTo() {
		return to;
	}
	
	public User getFrom() {
		return from;
	}
	
	public String getDateSent() {
		return dateSent;
	}
	
	public void respond(String response) {
		
	}
	
	public void deleteMessage() {
		
	}
	
	public void newMessage() {
		
	}
}
