package com.springrest.springrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.springrest.springrest.dao.LoadDao;
import com.springrest.springrest.entities.Load;

@Service
public class LoadServiceImpl implements LoadService {
  @Autowired
  private LoadDao loadDao;

  @Override
  public List<Load> getLoads() {
    return loadDao.findAll();
  }

  @Override
  public Load getLoad(long loadId) {
    Optional<Load> result = loadDao.findById(loadId);
    return result.orElse(null);
  }

  @Override
  public Load addLoad(Load load) {
    loadDao.save(load);
    return load;
  }

  @Override
  public Load updateLoad(long loadId, Load updatedLoad) {
    Optional<Load> result = loadDao.findById(loadId);
    if (result.isPresent()) {
      Load existingLoad = result.get();
      existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
      existingLoad.setProductType(updatedLoad.getProductType());
      existingLoad.setTruckType(updatedLoad.getTruckType());
      existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
      existingLoad.setWeight(updatedLoad.getWeight());
      existingLoad.setComment(updatedLoad.getComment());
      existingLoad.setShipperId(updatedLoad.getShipperId());
      existingLoad.setDate(updatedLoad.getDate());

      loadDao.save(existingLoad);
      return existingLoad;
    } else {
      return null;
    }
  }

  @Override
  public void deleteLoad(long loadId) {
    loadDao.deleteById(loadId);
  }

  @Override
  public List<Load> getLoadsByShipperId(long shipperId) {
    return loadDao.findByShipperId(shipperId);
  }
}
