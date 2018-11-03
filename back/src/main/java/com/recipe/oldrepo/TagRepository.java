package com.recipe.oldrepo;

import com.recipe.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {

	Tag findByNameIgnoreCase(String name);

 //   @Query("select tag from Tag tag where tag.")
//
//    void deleteTagFromRecept(Integer receptId, Integer tagId);
}
