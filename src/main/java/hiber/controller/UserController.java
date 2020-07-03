package hiber.controller;

import hiber.entity.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "list-users";
    }

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String showFormForAdd(User user) {
		return "add-user-form";
	}

	//submit button action here
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/updateForm/{id}", method = RequestMethod.GET)
	public String showFormForUpdate(@PathVariable(name = "id") int id,
									Model theModel) {
		User user = userService.getUser(id);
		theModel.addAttribute("user", user);
		return "user-form";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable(name = "id") int id) {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
}
