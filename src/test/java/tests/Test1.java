package tests;

import org.testng.annotations.Test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class Test1 
{
	@Test
	public void method()
	{
		//connet Twilio cloud for sms service
		String asid="";
		String auth="";
		Twilio.init(asid, auth);
		ResourceSet<Message> msgs=Message.reader().read();
		for(Message record:msgs)
		{
			System.out.println(record.getFrom()+"<------>"+record.getBody());
		}
		
	}

}
