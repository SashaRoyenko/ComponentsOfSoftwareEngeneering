package com.robosh.controller;

import com.robosh.controller.command.Get.GetCommand;
import com.robosh.controller.command.Get.GetSmartphoneCommand;
import com.robosh.controller.command.Post.PostCommand;
import com.robosh.controller.command.Post.PostSmartphoneCommand;
import com.robosh.enam.Request;
import com.robosh.service.DbService;
import com.robosh.service.implementation.SmartphoneDbServiceImpl;
import com.robosh.service.proxy.ProxySmartphoneDbService;
import java.util.HashMap;
import java.util.Map;

public class SmartphoneController {

  private Map<String, PostCommand> postCommandMap;
  private Map<String, GetCommand> getCommandMap;
  private DbService service;

  public SmartphoneController() {
    postCommandMap = new HashMap<>();
    getCommandMap = new HashMap<>();
    service = new ProxySmartphoneDbService();
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
