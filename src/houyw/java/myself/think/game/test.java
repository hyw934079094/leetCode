package houyw.java.myself.think.game;

import houyw.java.myself.think.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/5/24 17:08
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u1 = new User(12,"helong");
        User u2 = new User(11,"lilei");
        User u3 = new User(18,"zengdt");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return 0;
            }
        });
        for(User u :list){
            System.out.println(u.getName()+":"+u.getAge());
        }
    }

}
