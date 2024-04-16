package ca.usherbrooke.veo.xastresstester.insert;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InsertMapper {
  void insert(int i);
}
