package springlabs.news.items.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import springlabs.news.items.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsService newService;

    public NewsController(NewsService NewsService) {
        this.newService = NewsService;
    }

    @GetMapping("/all")
    public String findAllItems(Model model) {
        model.addAttribute("news", newService.findAllItems());
        return "news";
    }

    @GetMapping
    public String findNewsByName(Model model, String title) {
        model.addAttribute("news", newService.findItemByName(title));
        return "news";
    }

}
