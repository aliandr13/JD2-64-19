package by.it.academy.offer;

public class SenderService {

    private ISender sender;

    public SenderService() {
    }

    public SenderService(ISender sender) {
        this.sender = sender;
    }

    public void Message(Message message) {
        sender.send(message);
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }


}
