package com.common.springmvc.controller;

import com.common.springmvc.dto.StatDTO;
import com.common.springmvc.dto.ValueDTO;
import com.common.springmvc.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class RiskRestController {


  @Autowired
  RestService restService;

  @RequestMapping(value = "/risk", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StatDTO> risk(@RequestBody ValueDTO value) {

    if (ObjectUtils.isEmpty(value)) {
      return new ResponseEntity<StatDTO>(HttpStatus.BAD_REQUEST);
    }

    StatDTO stat = new StatDTO();
    stat.setValue(value.getValue());
    stat.setStat(value.getValue() + 1); // cool stat: we add 1 to the passed param

    return new ResponseEntity<StatDTO>(stat, HttpStatus.OK);
  }

}