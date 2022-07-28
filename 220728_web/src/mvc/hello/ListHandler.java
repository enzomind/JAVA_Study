package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.GetMessageListService;
import guestbook.service.MessageListView;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

		String pageNumberStr = req.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}

		GetMessageListService messageListService = GetMessageListService.getInstance();
		MessageListView viewData = messageListService.getMessageList(pageNumber);

		req.setAttribute("viewData", viewData);
		return "/WEB-INF/view/list.jsp";
		
	}

}
