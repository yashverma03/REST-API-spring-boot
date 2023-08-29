package com.springrest.springrest.services;

import java.util.List;
import com.springrest.springrest.entities.Load;

public interface LoadService {
  public List<Load> getLoads();

  public Load addLoad(Load load);

  public List<Load> getLoadsByShipperId(long shipperId);

  public Load getLoad(long loadId);

  public Load updateLoad(long loadId, Load updatedLoad);

  public void deleteLoad(long loadId);
}
