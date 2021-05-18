package playground.cheeseblossom.jpa.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import playground.cheeseblossom.jpa.service.SampleService;

@Controller
@RequiredArgsConstructor
public class IndexController {

  private final SampleService sampleService;

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("index");
    sampleService.save();
    return mv;
  }
}
