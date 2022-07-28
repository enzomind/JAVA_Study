package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestbook.model.Message;
import guestbook.service.DeleteMessageService;
import guestbook.service.InvalidPassowrdException;
import guestbook.service.WriteMessageService;
import mvc.command.CommandHandler;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

		int messageId = Integer.parseInt(req.getParameter("messageId"));
		String password = req.getParameter("password");
		boolean invalidPassword = false;
		try {
			DeleteMessageService deleteService = DeleteMessageService.getInstance();
			deleteService.deleteMessage(messageId, password);
		} catch (InvalidPassowrdException ex) {
			invalidPassword = true;
		}

		if (!invalidPassword) {
			req.setAttribute("invalidPassword", invalidPassword);

			return "/WEB-INF/view/deleteMessage.jsp";
		} else {
			return "/WEB-INF/view/delFailMessage.jsp";
		}
	}

}
