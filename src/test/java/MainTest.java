import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.entity.Guestbook;
import org.easybuy.entity.User;
import org.easybuy.service.*;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int i = orderService.insertOrder("yuanzx", 1, "15812937040", "爱丁堡",1,"小米su7");
        System.out.println(i);

    }
    }

