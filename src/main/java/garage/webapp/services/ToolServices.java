package garage.webapp.services;

import garage.webapp.entity.Tool;


/**
 * Created by Aleksander on 05.05.2017.
 */
public interface ToolServices {

    Iterable<Tool> listAllTools();

    Tool getToolById(Integer id);

    Tool saveTool(Tool tool);

    void deleteTool(Integer id);



}
