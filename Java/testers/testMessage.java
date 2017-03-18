package testers;
import messages.*;

class testMessage
{
    public static void main(String args[])
    {
	Message m = new Message("./messages/message.txt");
	m.centre();
	m.frame('+');
	m.display();
	Message m2 = new Message("./messages/prefixedScaleOptions.txt");
	m2.display();
    }
}