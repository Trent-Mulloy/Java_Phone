package com.pt.javaphone.controllers;

//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.pt.javaphone.models.LoginUser;
import com.pt.javaphone.models.User;
// import com.pt.javaphone.repositories.UserRepository;
import com.pt.javaphone.services.UserService;

//.. don't forget to inlcude all your imports! ..

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
 
 
  //Used to Bind Form Results when using JSP and not React APP
//  @GetMapping("/")
//  public String index(Model model) {
 
//      // Bind empty User and LoginUser objects to the JSP
//      // to capture the form input
//      model.addAttribute("newUser", new User());
//      model.addAttribute("newLogin", new LoginUser());
//      return "AddUser.js";
//  }
 
//Used to register user when using binding result in JSP and not React App
//  @PostMapping("/api/register")
//  public String register(@Valid @ModelAttribute("newUser") User newUser, 
//          BindingResult result, Model model, HttpSession session) {
     
//      // TO-DO Later -- call a register method in the service
// 	 this.userServ.register(newUser, result);
//      // to do some extra validations and create a new user!
     
//      if(result.hasErrors()) {
//          // Be sure to send in the empty LoginUser before 
//          // re-rendering the page.
//          model.addAttribute("newLogin", new LoginUser());
//          return "index.jsp";
//      }
     
//      // No errors! 
//      // TO-DO Later: Store their ID from the DB in session, 
//      // in other words, log them in.
 
//      return "redirect:/home";
//  }

//Used to register user from Axios.post request in React APP where Axios.Post send form data in the form of "User" object
 @PostMapping("/register")
    User newUser(@RequestBody User newUser) {
        return this.userServ.register(newUser, newUser);
    }
 
    //Used to login a User when using binding and Model with JSP and not React APP
//  @PostMapping("/login")
//  public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
//          BindingResult result, Model model, HttpSession session) {
//      // Add once service is implemented:
//       User user = userServ.login(newLogin, result);
//      if(result.hasErrors()) {
//          model.addAttribute("newUser", new User());
//          return "index.jsp";
//      }
 
//      // No errors! 
//      // TO-DO Later: Store their ID from the DB in session, 
//      session.setAttribute("sessionId", user.getId());
 
//      return "redirect:/home";
//  }
 
//used when using JSP and not React APP to ensure user is logged in prior to being allowed in the rest of the site
//  @RequestMapping("/home")
//  public String home(HttpSession session, Model model) {
// 	 if(session.getAttribute("sessionId") == null) {
// 		 return "redirect:/";
// 	 }
// 	 else {
// 		Long userId = (Long) session.getAttribute("sessionId");
// 		model.addAttribute("user", this.userServ.one_user(userId));
// 		 return "home.jsp";
// 	 	}
// 	 }

//used to logout when using JSP and not React APP
//  @RequestMapping("/logout")
//  public String logout(HttpSession session) {
// 	 session.invalidate();
// 	 return "redirect:/";
//  }
 
}
