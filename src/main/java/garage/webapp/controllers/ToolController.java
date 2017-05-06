package garage.webapp.controllers;

import garage.webapp.entity.Tool;
import garage.webapp.services.ToolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Aleksander on 05.05.2017.
 */

@Controller
public class ToolController {


    private ToolServices toolServices;

    @Autowired
    public void setToolServices(ToolServices toolServices){this.toolServices = toolServices; }

    @RequestMapping(value = "/tools", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("tools", toolServices.listAllTools());
        return "tools";
    }


    @RequestMapping("tool/new")
    public String newTool(Model model)
    {
        model.addAttribute("tool", new Tool());
        return "toolform";
    }

    @RequestMapping(value = "tool", method = RequestMethod.POST)
    public String saveTool(Tool tool){
        toolServices.saveTool(tool);
        return "redirect:/tool/" + tool.getId();
    }

    @RequestMapping("tool/{id}")
    public String showTool(@PathVariable Integer id, Model model){
        model.addAttribute("tool", toolServices.getToolById(id));
        return "toolshow";
    }

    @RequestMapping("tool/edit/{id}")
    public String editTool(@PathVariable Integer id, Model model){
        model.addAttribute("tool", toolServices.getToolById(id));
        return "toolform";
    }

    @RequestMapping("tool/delete/{id}")
    public String deleteTool(@PathVariable Integer id){
        toolServices.deleteTool(id);
        return "redirect:/tools";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
