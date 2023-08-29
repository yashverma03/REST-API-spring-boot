package com.springrest.springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Load;
import com.springrest.springrest.services.LoadService;

@RestController
public class LoadController {
  @Autowired
  private LoadService loadService;

  @GetMapping("/load")
  public ResponseEntity<List<Load>> getLoads() {
    try {
      List<Load> loads = this.loadService.getLoads();

      if (!loads.isEmpty()) {
        return ResponseEntity.ok(loads);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(null);
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(null);
    }
  }

  @PostMapping("/load")
  public ResponseEntity<String> addLoad(@RequestBody Load load) {
    try {
      Load addedLoad = this.loadService.addLoad(load);

      if (addedLoad != null) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Load details added successfully");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Failed to add load details.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred: " + e.getMessage());
    }
  }

  @GetMapping("/load")
  public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam("shipperId") long shipperId) {
    try {
      List<Load> loads = this.loadService.getLoadsByShipperId(shipperId);

      if (!loads.isEmpty()) {
        return ResponseEntity.ok(loads);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(null);
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(null);
    }
  }

  @GetMapping("/load/{loadId}")
  public ResponseEntity<Load> getLoad(@PathVariable String loadId) {
    try {
      long parsedLoadId = Long.parseLong(loadId);
      Load load = this.loadService.getLoad(parsedLoadId);

      if (load != null) {
        return ResponseEntity.ok(load);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @PutMapping("/load/{loadId}")
  public ResponseEntity<String> updateLoad(@PathVariable String loadId, @RequestBody Load updatedLoad) {
    try {
      long parsedLoadId = Long.parseLong(loadId);
      Load existingLoad = this.loadService.getLoad(parsedLoadId);

      if (existingLoad == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Load with ID " + loadId + " not found.");
      }

      Load updated = this.loadService.updateLoad(parsedLoadId, updatedLoad);

      if (updated != null) {
        return ResponseEntity.status(HttpStatus.OK)
            .body("Load details updated successfully.");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Failed to update load details.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred: " + e.getMessage());
    }
  }

  @DeleteMapping("/load/{loadId}")
  public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId) {
    try {
      long parsedLoadId = Long.parseLong(loadId);
      Load existingLoad = this.loadService.getLoad(parsedLoadId);

      if (existingLoad == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      this.loadService.deleteLoad(parsedLoadId);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
