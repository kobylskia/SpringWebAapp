package garage.webapp.controllers;

import garage.webapp.entity.Tool;
import garage.webapp.services.ToolServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="mygarage", description="List of all tools in my garage")
public class ToolController {


    private ToolServices toolServices;

    @Autowired
    public void setToolServices(ToolServices toolServices){this.toolServices = toolServices; }


    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
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

    @ApiOperation(value = "Add a tool")
    @RequestMapping(value = "tool", method = RequestMethod.POST)
    public String saveTool(Tool tool){
        toolServices.saveTool(tool);
        return "redirect:/tool/" + tool.getId();
    }

    @ApiOperation(value = "Search a tool with an ID",response = Tool.class)
    @RequestMapping("tool/{id}")
    public String showTool(@PathVariable Integer id, Model model){
        model.addAttribute("tool", toolServices.getToolById(id));
        return "toolshow";
    }

    @ApiOperation(value = "Edit tool's infromation")
    @RequestMapping("tool/edit/{id}")
    public String editTool(@PathVariable Integer id, Model model){
        model.addAttribute("tool", toolServices.getToolById(id));
        return "toolform";
    }

    @ApiOperation(value = "Delete a tool")
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
