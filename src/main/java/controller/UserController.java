package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/show")
    public ModelAndView show(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "3") int sizePage) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", userService.findAll(PageRequest.of(pageNumber, sizePage)));
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute User user) {
        userService.save(user);
        return new ModelAndView("redirect:/show");
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute User user) {
        userService.edit(user);
        return new ModelAndView("redirect:/show");
    }
    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        userService.delete(userService.findById(id));
        return new ModelAndView("redirect:/show");
    }
    @RequestMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", userService.findAllByName(findName));
        return modelAndView;
    }
}