package Messages;

public class MessegeCallBack implements MessageCallBackIN {

    public void onMessageRecieved(String message)
    {
        System.out.println(message + " ");
    }
}
