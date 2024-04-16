package ca.usherbrooke.veo.xastresstester.delete;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteMapper {
  void delete();
}
