package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestbook.model.Message;
import guestbook.service.WriteMessageService;
import mvc.command.CommandHandler;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		
		String name = req.getParameter("studentName");
		String pw = req.getParameter("password");
		int kor = Integer.parseInt(req.getParameter("korScore"));
		int math = Integer.parseInt(req.getParameter("mathScore"));
		int eng = Integer.parseInt(req.getParameter("engScore"));
		String msg = req.getParameter("message");
		
		Message mg = new Message();
		
		mg.setStudentName(name);
		mg.setPassword(pw);
		mg.setKorScore(kor);
		mg.setMathScore(math);
		mg.setEngScore(eng);
		mg.setMessage(msg);
		
		WriteMessageService writeService = WriteMessageService.getInstance();
		writeService.write(mg);
		
		req.setAttribute("mg", mg);
		return "/WEB-INF/view/writeMessage.jsp";
	
	
	}

}
