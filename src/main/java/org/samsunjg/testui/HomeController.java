package org.samsunjg.testui;

import com.google.gson.Gson;
import org.samsunjg.testui.UserResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getUsers(Model model) {
        String url = "https://reqres.in/api/users?page=1";
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // Parse JSON response using Gson
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(jsonResponse, UserResponse.class);

        // Add users to model
        model.addAttribute("users", userResponse.getData());
        return "userList";
    }

    @GetMapping("/add")
    public String addUser() {
        // Logic xử lý thêm người dùng tại đây (chỉ là ví dụ)
        return "addUser";
    }
}

