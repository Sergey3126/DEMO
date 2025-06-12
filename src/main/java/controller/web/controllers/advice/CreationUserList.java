package controller.web.controllers.advice;

import com.example.demo.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreationUserList {

    public void SaveUser(User user, boolean bol) {
        try (FileWriter writer = new FileWriter("Users.txt", bol)) {
            writer.write(user.toString());
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Map<String, User> GiveUser() {
        try (FileReader reader = new FileReader("Users.txt")) {
            Map<String, User> map = new HashMap<>();
            int c;
            StringBuilder txt = new StringBuilder();
            while ((c = reader.read()) != -1) {
                txt.append((char) c);
            }
            String[] userStrings = txt.toString().split("(?=User\\{)");
            Pattern pattern = Pattern.compile("имя='(.*?)'фамилия='(.*?)'почта='(.*?)'ник='(.*?)'");
            Matcher matcher = pattern.matcher(txt);
            for (String userString : userStrings)
                for (int i = 0; i < userStrings.length; i++) {
                    if (matcher.find()) {
                        map.put(matcher.group(4), new User(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4)));
                    }
                }
            return map;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
