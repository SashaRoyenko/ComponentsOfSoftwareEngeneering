package com.robosh.controller.command.Post;

import com.robosh.entities.Smartphone;
import com.robosh.parser.Parser;
import com.robosh.parser.ParserFactory;
import com.robosh.service.DbService;

public class PostSmartphoneCommand implements PostCommand {

  private Parser parser;
  private DbService smartphoneDbService;

  public PostSmartphoneCommand(DbService smartphoneDbService) {
    this.parser = ParserFactory.getSmartphoneInputParser();
    this.smartphoneDbService = smartphoneDbService;
  }

  @Override
  public Smartphone execute(Object input) {
    Smartphone smartphone = (Smartphone) parser.parse((String) input);
    smartphoneDbService.save(smartphone);
    return smartphone;
  }

}

