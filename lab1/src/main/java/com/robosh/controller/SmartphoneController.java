package com.robosh.controller;

import com.robosh.controller.command.Get.GetCommand;
import com.robosh.controller.command.Get.GetSmartphoneCommand;
import com.robosh.controller.command.Post.PostCommand;
import com.robosh.controller.command.Post.PostSmartphoneCommand;
import com.robosh.enam.Request;
import com.robosh.service.DbService;
import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;

public class SmartphoneController {

  private Map<String, PostCommand> postCommandMap;
  private Map<String, GetCommand> getCommandMap;

  @Qualifier("proxySmartphoneDbService")
  @Setter
  private DbService service;

  public void init() {
    postCommandMap = new HashMap<>();
    getCommandMap = new HashMap<>();
    postCommandMap.put("/smartphone", new PostSmartphoneCommand(service));
    getCommandMap.put("/smartphone", new GetSmartphoneCommand(service));
  }

  public Object executeRequest(Request request, String uri, Object parameters) {
    switch (request) {
      case GET:
        GetCommand getCommand = getCommandMap.get(uri);
        if (getCommand == null) {
          throw new UnsupportedOperationException("Error 404");
        } else {
          return getCommand.execute();
        }
      case POST:
        PostCommand postCommand = postCommandMap.get(uri);
        if (postCommand == null) {
          throw new UnsupportedOperationException("Error 404");
        } else {
          return postCommand.execute(parameters);
        }
      default:
        throw new UnsupportedOperationException("Unsupported request param");
    }
  }

}
