import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.entity.Guestbook;
import org.easybuy.service.GuestbookService;
import org.easybuy.service.ManagerService;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
      ManagerService managerService = new ManagerService();
        boolean yuanzx = managerService.findUserByUsername("admin");
        System.out.println(yuanzx);


    }
    }

