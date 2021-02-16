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
		String asid="ACa5ae9f83835dc30173012e6588b69a1c";
		String auth="d18826fa0ae4df3c9235ea5b47d188ad";
		Twilio.init(asid, auth);
		ResourceSet<Message> msgs=Message.reader().read();
		for(Message record:msgs)
		{
			System.out.println(record.getFrom()+"<------>"+record.getBody());
		}
		
	}

}
