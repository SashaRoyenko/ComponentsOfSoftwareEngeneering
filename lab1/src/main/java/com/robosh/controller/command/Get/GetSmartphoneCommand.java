package com.robosh.controller.command.Get;

import com.robosh.entities.Smartphone;
import com.robosh.service.DbService;
import java.util.List;

public class GetSmartphoneCommand implements GetCommand {

  private DbService service;

  public GetSmartphoneCommand(DbService service) {
    this.service = service;
  }

  @Override
  public List<Smartphone> execute() {
    return service.findAll();
  }
}
