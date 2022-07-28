package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestbook.model.Message;
import guestbook.service.DeleteMessageService;
import guestbook.service.InvalidPassowrdException;
import guestbook.service.WriteMessageService;
import mvc.command.CommandHandler;

public class PassConDelHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/view/confirmDeletion.jsp";
	}

}
