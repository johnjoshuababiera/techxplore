package com.acn.texchxplore.repository;

import com.acn.texchxplore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByDiscounted(boolean discounted);
}
